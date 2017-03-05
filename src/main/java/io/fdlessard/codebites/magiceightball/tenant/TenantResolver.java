package io.fdlessard.codebites.magiceightball.tenant;

/**
 * Created by fdlessard on 17-02-11.
 */
public interface TenantResolver {

    String getTenantKey();
    String getCurrentTenant();
    void setCurrentTenant(String currentTenant);
}
