package io.fdlessard.codebites.magiceightball.tenant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by fdlessard on 17-03-05.
 */
@RunWith(MockitoJUnitRunner.class)
public class TenantInterceptorAdapterTest {

    public static final String TENANT_KEY = "tenantKey";
    public static final String CURRENT_TENANT = "currentTenant";

    @Mock
    private TenantResolver tenantResolver;

    private TenantInterceptorAdapter tenantInterceptorAdapter;

    @Before
    public void setUp() throws Exception {
        Mockito.when(tenantResolver.getTenantKey()).thenReturn(TENANT_KEY);
        tenantInterceptorAdapter = new TenantInterceptorAdapter(tenantResolver);
    }

    @Test
    public void preHandle() throws Exception {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.addHeader(TENANT_KEY, CURRENT_TENANT);
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        assertTrue(tenantInterceptorAdapter.preHandle(mockHttpServletRequest, mockHttpServletResponse, null));
    }

    @Test
    public void preHandleWithNoTenant() throws Exception {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        assertFalse(tenantInterceptorAdapter.preHandle(mockHttpServletRequest, mockHttpServletResponse, null));
    }
}