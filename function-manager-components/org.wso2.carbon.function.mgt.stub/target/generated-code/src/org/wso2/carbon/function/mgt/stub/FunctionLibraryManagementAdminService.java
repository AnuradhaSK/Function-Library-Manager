

/**
 * FunctionLibraryManagementAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v10  Built on : Sep 04, 2013 (02:02:54 UTC)
 */

    package org.wso2.carbon.function.mgt.stub;

    /*
     *  FunctionLibraryManagementAdminService java interface
     */

    public interface FunctionLibraryManagementAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param createFunctionLibrary1
                
         */

         
                     public void createFunctionLibrary(

                        org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary2,java.lang.String tenantDomain3)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param createFunctionLibrary1
            
          */
        public void startcreateFunctionLibrary(

            org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary2,java.lang.String tenantDomain3,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    