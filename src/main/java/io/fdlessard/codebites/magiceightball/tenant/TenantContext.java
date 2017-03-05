package io.fdlessard.codebites.magiceightball.tenant;

import org.apache.commons.lang.StringUtils;

/**
 * Created by fdlessard on 17-02-11.
 */
public class TenantContext {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<String>()
    {
        @Override
        protected String initialValue() {
            return StringUtils.EMPTY;
        }
    };

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}