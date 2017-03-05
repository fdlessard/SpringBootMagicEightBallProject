package io.fdlessard.codebites.magiceightball.tenant;

import io.fdlessard.codebites.magiceightball.controllers.MagicEightBallController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;

import static org.eclipse.persistence.config.PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT;

/**
 * Created by fdlessard on 17-03-03.
 */
@Component
public class MultiTenantJpaTransactionManager extends JpaTransactionManager {

    private TenantResolver tenantResolver;

    public MultiTenantJpaTransactionManager(TenantResolver tenantResolver) {
        logger.info("MultiTenantJpaTransactionManager - Creation");
        this.tenantResolver = tenantResolver;
    }

    @Override
    public void doBegin(Object transaction, final TransactionDefinition definition) {

        logger.info("MultiTenantJpaTransactionManager.doBegin()");
        super.doBegin(transaction, definition);
        EntityManagerHolder entityManagerHolder = (EntityManagerHolder) TransactionSynchronizationManager.getResource(getEntityManagerFactory());
        EntityManager entityManager = entityManagerHolder.getEntityManager();
        String currentTenant = tenantResolver.getCurrentTenant();
        logger.info("MultiTenantJpaTransactionManager.doBegin() - currentTenant: " + currentTenant);
        String currentTenantSet =  (String) entityManager.getProperties().get(MULTITENANT_PROPERTY_DEFAULT);
        logger.info("MultiTenantJpaTransactionManager.doBegin() - currentTenantSet: " + currentTenantSet);

        if(currentTenantSet != null && !currentTenantSet.equals(currentTenant)) {
            throw new IllegalStateException("Resource conflict - The EntityManager is already assigned to tenant : " + currentTenant);
        }
        entityManager.setProperty(MULTITENANT_PROPERTY_DEFAULT, currentTenant);
    }
}
