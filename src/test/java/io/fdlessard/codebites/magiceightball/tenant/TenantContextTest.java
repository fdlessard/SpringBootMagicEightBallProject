package io.fdlessard.codebites.magiceightball.tenant;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fdlessard on 17-03-05.
 */
public class TenantContextTest {

    public static final String CURRENT_TENANT = "currentTenant";

    @Test
    public void setCurrentTenant() throws Exception {
        TenantContext.setCurrentTenant(CURRENT_TENANT);
        assertEquals(CURRENT_TENANT, TenantContext.getCurrentTenant());
    }

    @Test
    public void clear() throws Exception {
        TenantContext.setCurrentTenant(CURRENT_TENANT);
        assertEquals(CURRENT_TENANT, TenantContext.getCurrentTenant());
        TenantContext.clear();
        assertEquals(StringUtils.EMPTY, TenantContext.getCurrentTenant());
    }
}