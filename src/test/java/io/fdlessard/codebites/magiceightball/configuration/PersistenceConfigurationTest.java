package io.fdlessard.codebites.magiceightball.configuration;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by fdlessard on 17-03-06.
 */
@RunWith(MockitoJUnitRunner.class)
public class PersistenceConfigurationTest {

    @Mock
    private DataSource dataSource;
    @Mock
    private JpaProperties properties;
    @Mock
    private ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider;
    @Mock
    private ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers;

    private PersistenceConfiguration persistenceConfiguration;

    @Before
    public void setUp() throws Exception {
        persistenceConfiguration = new PersistenceConfiguration(dataSource, properties, jtaTransactionManagerProvider, transactionManagerCustomizers);
    }

    @Test
    public void transactionManager() throws Exception {
        PlatformTransactionManager platformTransactionManager = persistenceConfiguration.transactionManager();
        assertNotNull(platformTransactionManager);
    }

    @Test
    public void createJpaVendorAdapter() throws Exception {
        assertNotNull(persistenceConfiguration.createJpaVendorAdapter());
        assertTrue(persistenceConfiguration.createJpaVendorAdapter() instanceof EclipseLinkJpaVendorAdapter);
    }

    @Test
    public void getVendorProperties() throws Exception {
        Map<String, Object> vendorProperties = persistenceConfiguration.getVendorProperties();
        assertNotNull(vendorProperties);
        assertNotNull(vendorProperties.get(PersistenceUnitProperties.WEAVING));
        assertNotNull(vendorProperties.get(PersistenceUnitProperties.VALIDATION_MODE));
    }

}