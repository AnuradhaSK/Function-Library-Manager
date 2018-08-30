package org.wso2.carbon.function.mgt;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;
import org.wso2.carbon.core.AbstractAdmin;

public class FunctionLibraryManagementAdminService extends AbstractAdmin {

    private static Log log = LogFactory.getLog(FunctionLibraryManagementAdminService.class);
    private FunctionLibraryManagementService functionLibMgtService;


    public void createFunctionLibrary(FunctionLibrary functionLibrary) {
        functionLibMgtService = FunctionLibraryManagementService.getInstance();
        functionLibMgtService.createFunctionLibrary(functionLibrary, getTenantDomain());

    }


}
