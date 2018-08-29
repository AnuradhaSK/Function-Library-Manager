package org.wso2.carbon.function.mgt.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.function.mgt.FunctionLibraryManagementService;
import org.wso2.carbon.function.mgt.FunctionLibraryManagementServiceImpl;

@Component(
        name = "function.library.management.service",
        immediate = true
)
public class FunctionLibraryManagementServiceComponent {
    private static Log log = LogFactory.getLog(FunctionLibraryManagementServiceComponent.class);
    private static BundleContext bundleContext;

    @Activate
    protected void activate(ComponentContext context) {
        bundleContext = context.getBundleContext();
        // Registering Functionl= library management service as a OSGIService
        bundleContext.registerService(FunctionLibraryManagementService.class.getName(), FunctionLibraryManagementServiceImpl.getInstance(),null);
        if (log.isDebugEnabled()) {
            log.debug("Function Library ManagementComponent bundle is activated");
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {
        if (log.isDebugEnabled()) {
            log.debug("Function Library ManagementComponent bundle is deactivated");
        }
    }


}
