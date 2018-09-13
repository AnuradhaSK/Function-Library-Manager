package org.wso2.carbon.function.mgt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.function.mgt.dao.FunctionLibraryDAO;
import org.wso2.carbon.function.mgt.dao.impl.FunctionLibraryDAOImpl;
import org.wso2.carbon.function.mgt.exception.FunctionLibraryManagementException;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;


public class FunctionLibraryManagementServiceImpl extends FunctionLibraryManagementService {

    private static final Log log = LogFactory.getLog(FunctionLibraryManagementServiceImpl.class);
    private static volatile FunctionLibraryManagementServiceImpl functionLibMgtService;

    private FunctionLibraryManagementServiceImpl() {
    }

    public static FunctionLibraryManagementServiceImpl getInstance() {

        if (functionLibMgtService == null) {
            synchronized (FunctionLibraryManagementServiceImpl.class) {
                if (functionLibMgtService == null) {
                    functionLibMgtService = new FunctionLibraryManagementServiceImpl();
                }
            }
        }
        return functionLibMgtService;
    }

    public void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain) throws FunctionLibraryManagementException {
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        functionLibraryDAO.createFunctionLibrary(functionLibrary, tenantDomain);
    }

    public FunctionLibrary[] listFunctionLibraries(String tenantDomain) throws FunctionLibraryManagementException {
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        return functionLibraryDAO.listFunctionLibraries(tenantDomain);

    }

    public FunctionLibrary  getFunctionLibrary(String functionLibraryName, String tenantDomain) throws FunctionLibraryManagementException {
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        return functionLibraryDAO.getFunctionLibrary(functionLibraryName,tenantDomain);
    }

    public void deleteFunctionLibrary(String functionLibraryName, String tenantDomain) throws FunctionLibraryManagementException {
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        functionLibraryDAO.deleteFunctionLibrary(functionLibraryName,tenantDomain);
    }

    public void updateFunctionLibrary(FunctionLibrary functionLibrary,String tenatDomain, String oldFunctionLibraryName) throws FunctionLibraryManagementException {
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        functionLibraryDAO.updateFunctionLibrary(functionLibrary,tenatDomain,oldFunctionLibraryName);
    }

}