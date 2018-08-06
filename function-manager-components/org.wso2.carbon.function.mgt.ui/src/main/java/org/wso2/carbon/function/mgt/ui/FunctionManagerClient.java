package org.wso2.carbon.function.mgt.ui;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.wso2.carbon.function.mgt.data.xsd.Function;
import org.wso2.carbon.function.mgt.stub.FunctionManagerStub;

import java.rmi.RemoteException;

public class FunctionManagerClient {
    private FunctionManagerStub stub;

    public FunctionManagerClient(ConfigurationContext configCtx, String backendServerURL, String cookie) throws Exception{
        String serviceURL = backendServerURL + "FunctionManager";
        stub = new FunctionManagerStub(configCtx, serviceURL);
        ServiceClient client = stub._getServiceClient();
        Options options = client.getOptions();
        options.setManageSession(true);
        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);
    }

    public Function[] getFunctions() throws Exception{
        try{
            return stub.getFunctions();
        }catch (RemoteException e) {
            String msg = "Cannot get the list of Function"
                    + " . Backend service may be unavailable";
            throw new Exception(msg, e);
        }
    }
}

