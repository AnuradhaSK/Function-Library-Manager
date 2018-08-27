package org.wso2.carbon.function.mgt.dao;

import org.wso2.carbon.function.mgt.model.FunctionLibrary;

import java.util.List;

public interface FunctionLibraryDAO {

    void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain);
    FunctionLibrary loadFunctionLibrary(String functionLibraryName, String tenantDomain);
    List<FunctionLibrary> getAllFunctionLibraries(String tenantDomain);
    void updateFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain, String oldFunctionLibName);
    void deleteFunctionLibrary(String functionLibraryName, String tenantDomain);
}
