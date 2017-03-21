package io.fdlessard.codebites.magiceightball.tenant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.jpa.JpaTransactionManager;

import static org.junit.Assert.*;

/**
 * Created by fdlessard on 17-03-05.
 */
@RunWith(MockitoJUnitRunner.class)
public class MultiTenantJpaTransactionManagerTest {

    public static final String TENANT_KEY = "tenantKey";
    public static final String CURRENT_TENANT = "currentTenant";

    @Mock
    private TenantResolver tenantResolver;

    private MultiTenantJpaTransactionManager multiTenantJpaTransactionManager;

    @Before
    public void setUp() throws Exception {
        Mockito.when(tenantResolver.getTenantKey()).thenReturn(TENANT_KEY);
        Mockito.when(tenantResolver.getCurrentTenant()).thenReturn(CURRENT_TENANT);
        multiTenantJpaTransactionManager = new MultiTenantJpaTransactionManager(tenantResolver);
    }

    @Test
    public void doBegin() throws Exception {
   //     multiTenantJpaTransactionManager.doBegin(null, null);
    }
}