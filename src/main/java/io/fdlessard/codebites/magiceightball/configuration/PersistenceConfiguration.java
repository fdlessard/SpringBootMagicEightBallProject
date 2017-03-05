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
import org.springframework.orm.jpa.JpaTransactionManager;
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


/*    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setPackagesToScan(new String[]{"io.fdlessard.codebites.magiceightball"});
       // entityManagerFactoryBean.setPersistenceUnitName("MyTestPU");

        //entityManagerFactoryBean.setJpaVendorAdapter(createJpaVendorAdapter());
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }
    */

    @Bean
    public PlatformTransactionManager transactionManager(MultiTenantJpaTransactionManager multiTenantJpaTransactionManager, EntityManagerFactory entityManagerFactory) {
        LOGGER.info("PersistenceConfiguration.transactionManager()");
        multiTenantJpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return multiTenantJpaTransactionManager;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
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




/*
    @Bean
    public DataSource dataSource() {

        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .build();

        return embeddedDatabase;
    }
*/

/*    @Bean
    public JpaProperties jpaProperties() {
        LOGGER.info("PersistenceConfiguration.jpaProperties()");

        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:test");
        //properties.put("javax.persistence.jdbc.username", "APP");
        //properties.put("javax.persistence.jdbc.password", "APP");

        //properties.put("javax.persistence.schema-generation.database.action", "create");
        properties.put("eclipselink.logging.parameters", "true");
        properties.put("eclipselink.logging.level", "FINEST");

        properties.put("eclipselink.target-database", "org.eclipse.persistence.platform.database.H2Platform");
        properties.put("eclipselink.weaving", "false");
        //properties.put("eclipselink.ddl-generation", "drop-and-create-tables");

       JpaProperties jpaProperties = new JpaProperties();
       jpaProperties.setProperties(properties);
        
        return jpaProperties;
    }*/


}