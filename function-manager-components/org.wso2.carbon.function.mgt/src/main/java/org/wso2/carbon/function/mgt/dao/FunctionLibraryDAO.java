package org.wso2.carbon.function.mgt.dao;

import org.wso2.carbon.function.mgt.exception.FunctionLibraryManagementException;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;

public interface FunctionLibraryDAO {

    void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain)
            throws FunctionLibraryManagementException;
    FunctionLibrary loadFunctionLibrary(String functionLibraryName, String tenantDomain);
    FunctionLibrary[] getAllFunctionLibraries(String tenantDomain) throws FunctionLibraryManagementException;
    void updateFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain, String oldFunctionLibName) throws FunctionLibraryManagementException;
    void deleteFunctionLibrary(String functionLibraryName, String tenantDomain) throws FunctionLibraryManagementException;
}
