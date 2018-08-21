package org.wso2.carbon.function.mgt.dao;

import org.wso2.carbon.function.mgt.model.FunctionLibrary;

public interface FunctionLibraryDAO {

    void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain);

    FunctionLibrary loadFunctionLibrary();
    void updateFunctionLibrary();
    void deleteFunctionLibrary();
}
