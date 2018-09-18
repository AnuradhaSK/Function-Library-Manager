package org.wso2.carbon.function.mgt;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.function.mgt.exception.FunctionLibraryManagementException;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;
import org.wso2.carbon.core.AbstractAdmin;

public class FunctionLibraryManagementAdminService extends AbstractAdmin {

    private static Log log = LogFactory.getLog(FunctionLibraryManagementAdminService.class);
    private FunctionLibraryManagementService functionLibMgtService;


    public void createFunctionLibrary (FunctionLibrary functionLibrary) throws FunctionLibraryManagementException{
        try {
            functionLibMgtService = FunctionLibraryManagementService.getInstance();
            functionLibMgtService.createFunctionLibrary(functionLibrary, getTenantDomain());
        }catch (FunctionLibraryManagementException flException){
            log.error("Error while creating function library "+functionLibrary.getFunctionLibraryName()+" for tenant domain "+getTenantDomain(),flException);
            System.out.println("Error at admin service"+flException);
            throw flException;
        }

    }

    public FunctionLibrary[] listFunctionLibraries() throws FunctionLibraryManagementException{
        try {
            functionLibMgtService = FunctionLibraryManagementService.getInstance();
            FunctionLibrary[] functionLibraries = functionLibMgtService.listFunctionLibraries(getTenantDomain());
            return functionLibraries;
        }catch(FunctionLibraryManagementException flException){
            log.error("Error while retrieving function libraris for tenant: " + getTenantDomain(),flException);
            throw flException;
        }
    }

    public FunctionLibrary getFunctionLibrary(String functionLibraryName) throws FunctionLibraryManagementException {
        try {
            functionLibMgtService =FunctionLibraryManagementService.getInstance();
            FunctionLibrary functionLibrary = null;
            functionLibrary = functionLibMgtService.getFunctionLibrary(functionLibraryName,getTenantDomain());
            return functionLibrary;
        } catch (FunctionLibraryManagementException flException) {
            log.error("Error while retrieving function library "+ functionLibraryName+ " for tenant domain "+ getTenantDomain(),flException);
            throw flException;
        }

    }

    public void deleteFunctionLibrary(String functionLibraryName) throws FunctionLibraryManagementException{
        try {
        functionLibMgtService = FunctionLibraryManagementService.getInstance();
        functionLibMgtService.deleteFunctionLibrary(functionLibraryName,getTenantDomain());
        } catch (FunctionLibraryManagementException flException) {
            log.error("Error while deleting function library "+ functionLibraryName+ " for tenant domain "+getTenantDomain(),flException);
            throw flException;
        }
    }

    public void updateFunctionLibrary(FunctionLibrary functionLibrary, String oldFunctionLibraryName) throws FunctionLibraryManagementException{

        try {
            functionLibMgtService = FunctionLibraryManagementService.getInstance();
            functionLibMgtService.updateFunctionLibrary(functionLibrary,getTenantDomain(),oldFunctionLibraryName);
        } catch (FunctionLibraryManagementException flException) {
            log.error("Error while updating function library "+oldFunctionLibraryName+ "for tenant domain "+ getTenantDomain(),flException);
            System.out.println("Error at admin service"+flException);
            throw flException;
        }
    }

}
