package io.fdlessard.codebites.magiceightball.tenant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by fdlessard on 17-02-11.
 */
@Component
public class TenantResolverImpl implements TenantResolver {
    
    private String tenantKey;

    public TenantResolverImpl( @Value("${tenantKey}") String tenantKey) {
        this.tenantKey = tenantKey;
    }

    @Override
    public String getTenantKey() {
        return tenantKey;
    }

    @Override
    public String getCurrentTenant() {
        return TenantContext.getCurrentTenant();
    }

    @Override
    public void setCurrentTenant(String currentTenant) {
        TenantContext.setCurrentTenant(currentTenant);
    }
}
