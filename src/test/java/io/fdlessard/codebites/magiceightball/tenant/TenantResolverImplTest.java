package io.fdlessard.codebites.magiceightball.tenant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fdlessard on 17-03-05.
 */
public class TenantResolverImplTest {

    private static final String TENANT_KEY = "tenantKey";
    public static final String CURRENT_TENANT = "currentTenant";

    private TenantResolver tenantResolver;
    @Before
    public void setUp() throws Exception {
        tenantResolver = new TenantResolverImpl(TENANT_KEY);
    }

    @Test
    public void getTenantKey() throws Exception {
        assertEquals(TENANT_KEY, tenantResolver.getTenantKey());
    }

    @Test
    public void getCurrentTenant() throws Exception {
        tenantResolver.setCurrentTenant(CURRENT_TENANT);
        assertEquals(CURRENT_TENANT, tenantResolver.getCurrentTenant());
    }

}