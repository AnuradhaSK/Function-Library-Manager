package org.wso2.carbon.function.mgt;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;


public class FunctionLibraryManagementAdminService {

    private static Log log = LogFactory.getLog(FunctionLibraryManagementAdminService.class);
    private FunctionLibraryManagementService functionLibMgtService;


    public void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain) {
        functionLibMgtService = FunctionLibraryManagementService.getInstance();
        functionLibMgtService.createFunctionLibrary(functionLibrary,tenantDomain);


    }
}
