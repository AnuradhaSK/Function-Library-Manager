package org.wso2.carbon.function.mgt;

import org.wso2.carbon.function.mgt.exception.FunctionLibraryManagementException;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;

public interface FunctionLibraryManagementService {


    void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain)
            throws FunctionLibraryManagementException;

    FunctionLibrary[] listFunctionLibraries (String tenantDomain)
            throws FunctionLibraryManagementException;

    FunctionLibrary getFunctionLibrary (String functionLibraryName, String tenantDomain)
            throws FunctionLibraryManagementException;

    void deleteFunctionLibrary (String functionLibraryName, String tenantDomain)
            throws FunctionLibraryManagementException;

    void updateFunctionLibrary (FunctionLibrary functionLibrary,String tenatDomain, String oldFunctionLibraryName)
            throws FunctionLibraryManagementException;
}