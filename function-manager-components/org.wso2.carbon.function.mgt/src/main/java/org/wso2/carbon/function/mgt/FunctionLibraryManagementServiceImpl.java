package org.wso2.carbon.function.mgt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.function.mgt.dao.FunctionLibraryDAO;
import org.wso2.carbon.function.mgt.dao.impl.FunctionLibraryDAOImpl;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;

import java.util.List;

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

    public void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain) {
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        functionLibraryDAO.createFunctionLibrary(functionLibrary, tenantDomain);
    }

    public FunctionLibrary[] getAllFunctionLibraries(String tenantDomain) {
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        return functionLibraryDAO.getAllFunctionLibraries(tenantDomain);

    }

    public FunctionLibrary  loadFunctionLibrary(String functionLibraryName, String tenantDomain){
        FunctionLibraryDAO functionLibraryDAO = new FunctionLibraryDAOImpl();
        return functionLibraryDAO.loadFunctionLibrary(functionLibraryName,tenantDomain);
    }

}