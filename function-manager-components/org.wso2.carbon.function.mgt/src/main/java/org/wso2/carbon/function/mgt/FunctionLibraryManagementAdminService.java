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

    public FunctionLibrary[] getAllFunctionLibraries(){
        functionLibMgtService = FunctionLibraryManagementService.getInstance();
        FunctionLibrary[] functionLibraries = functionLibMgtService.getAllFunctionLibraries(getTenantDomain());
        return functionLibraries;
    }

    public FunctionLibrary loadFunctionLibrary(String functionLibraryName){
        functionLibMgtService =FunctionLibraryManagementService.getInstance();
        FunctionLibrary functionLibrary = functionLibMgtService.loadFunctionLibrary(functionLibraryName,getTenantDomain());
        return functionLibrary;
    }

    public void deleteFunctionLibrary(String functionLibraryName){
        functionLibMgtService = FunctionLibraryManagementService.getInstance();
        functionLibMgtService.deleteFunctionLibrary(functionLibraryName,getTenantDomain());
    }

    public void updateFunctionLibrary(FunctionLibrary functionLibrary, String oldFunctionLibraryName){
        functionLibMgtService = FunctionLibraryManagementService.getInstance();
        functionLibMgtService.updateFunctionLibrary(functionLibrary,getTenantDomain(),oldFunctionLibraryName);
    }

}
