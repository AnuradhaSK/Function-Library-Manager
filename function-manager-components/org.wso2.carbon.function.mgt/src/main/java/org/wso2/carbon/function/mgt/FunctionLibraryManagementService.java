package org.wso2.carbon.function.mgt;

import org.wso2.carbon.function.mgt.model.FunctionLibrary;

public abstract class FunctionLibraryManagementService {

    public static FunctionLibraryManagementService getInstance() {
        return FunctionLibraryManagementServiceImpl.getInstance();
    }

    public abstract void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain);

}