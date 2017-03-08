package io.fdlessard.codebites.magiceightball.configuration;

import io.fdlessard.codebites.magiceightball.tenant.TenantInterceptorAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import static org.mockito.Mockito.*;

/**
 * Created by fdlessard on 17-03-06.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationConfigurationTest {

    @Mock
    private TenantInterceptorAdapter tenantInterceptorAdapter;
    @Mock
    private InterceptorRegistry registry;

    private ApplicationConfiguration applicationConfiguration;

    @Before
    public void setUp() throws Exception {
        applicationConfiguration = new ApplicationConfiguration(tenantInterceptorAdapter);
        when(registry.addInterceptor(tenantInterceptorAdapter)).thenReturn(new InterceptorRegistration(tenantInterceptorAdapter));
    }

    @Test()
    public void addInterceptors() throws Exception {
        applicationConfiguration.addInterceptors(registry);
        verify(registry, times(1)).addInterceptor(tenantInterceptorAdapter);
    }
}