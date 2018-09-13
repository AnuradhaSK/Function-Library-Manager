
/**
 * FunctionLibraryManagementAdminServiceFunctionLibraryManagementException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v10  Built on : Sep 04, 2013 (02:02:54 UTC)
 */

package org.wso2.carbon.function.mgt.stub;

public class FunctionLibraryManagementAdminServiceFunctionLibraryManagementException extends java.lang.Exception{

    private static final long serialVersionUID = 1536813943856L;
    
    private org.wso2.carbon.function.mgt.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException faultMessage;

    
        public FunctionLibraryManagementAdminServiceFunctionLibraryManagementException() {
            super("FunctionLibraryManagementAdminServiceFunctionLibraryManagementException");
        }

        public FunctionLibraryManagementAdminServiceFunctionLibraryManagementException(java.lang.String s) {
           super(s);
        }

        public FunctionLibraryManagementAdminServiceFunctionLibraryManagementException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public FunctionLibraryManagementAdminServiceFunctionLibraryManagementException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.wso2.carbon.function.mgt.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException msg){
       faultMessage = msg;
    }
    
    public org.wso2.carbon.function.mgt.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException getFaultMessage(){
       return faultMessage;
    }
}
    