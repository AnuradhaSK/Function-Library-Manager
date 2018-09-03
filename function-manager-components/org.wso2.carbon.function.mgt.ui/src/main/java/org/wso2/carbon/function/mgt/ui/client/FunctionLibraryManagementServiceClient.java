package org.wso2.carbon.function.mgt.ui.client;


import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary;
import org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceStub;

import java.rmi.RemoteException;

public class FunctionLibraryManagementServiceClient {
    FunctionLibraryManagementAdminServiceStub stub;
    Log log = LogFactory.getLog(FunctionLibraryManagementServiceClient.class);
    boolean debugEnabled = log.isErrorEnabled();

    public FunctionLibraryManagementServiceClient(String cookie, String backendServerURL, ConfigurationContext configCtx) throws AxisFault {

        String serviceURL = backendServerURL + "FunctionLibraryManagementAdminService";
        stub = new FunctionLibraryManagementAdminServiceStub(configCtx,serviceURL);

        ServiceClient client = stub._getServiceClient();
        Options option = client.getOptions();
        option.setManageSession(true);
        option.setProperty(HTTPConstants.COOKIE_STRING, cookie);

        if (debugEnabled){
            log.debug("Invoking service" + serviceURL);
        }

    }

    public void createFunctionLibrary(FunctionLibrary functionLibrary){
        if(debugEnabled){
            log.debug("Registering function library" + functionLibrary.getFunctionLibraryName());
            try {
                stub.createFunctionLibrary(functionLibrary);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }

    public FunctionLibrary[] getAllFunctionLibraries(){
        try {
            return stub.getAllFunctionLibraries();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new FunctionLibrary[0];
    }

    public FunctionLibrary loadFunctionLibrary(String functionLibraryName){
        try {
            return stub.loadFunctionLibrary(functionLibraryName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteFunctionLibrary(String functionLibraryName){
        try {
            stub.deleteFunctionLibrary(functionLibraryName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
