package io.fdlessard.codebites.magiceightball.configuration;

import io.fdlessard.codebites.magiceightball.tenant.MultiTenantJpaTransactionManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fdlessard on 17-03-02.
 */
@Configuration
@EnableJpaRepositories("io.fdlessard.codebites.magiceightball.repositories")
@EnableTransactionManagement
public class PersistenceConfiguration extends JpaBaseConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    protected PersistenceConfiguration(DataSource dataSource,
                                       JpaProperties properties,
                                       ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider) {
        super(dataSource, properties, jtaTransactionManagerProvider);

        LOGGER.info("PersistenceConfiguration()");
    }

    @Bean
    public PlatformTransactionManager transactionManager(MultiTenantJpaTransactionManager multiTenantJpaTransactionManager, EntityManagerFactory entityManagerFactory) {
        LOGGER.info("PersistenceConfiguration.transactionManager()");
        multiTenantJpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return multiTenantJpaTransactionManager;
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        LOGGER.info("PersistenceConfiguration.createJpaVendorAdapter()");
        EclipseLinkJpaVendorAdapter jpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        LOGGER.info("PersistenceConfiguration.getVendorProperties()");
        HashMap<String, Object> vendorProperties = new HashMap<>();
        vendorProperties.put(PersistenceUnitProperties.WEAVING, detectWeavingMode());
        vendorProperties.put(PersistenceUnitProperties.VALIDATION_MODE, ValidationMode.NONE.toString());
        return vendorProperties;
    }

    private String detectWeavingMode() {
        LOGGER.info("PersistenceConfiguration.detectWeavingMode()");
        return InstrumentationLoadTimeWeaver.isInstrumentationAvailable() ? "true" : "static";
    }
}