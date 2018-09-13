

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
                    * @param listFunctionLibraries6
                
             * @throws org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException : 
         */

         
                     public org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary[] listFunctionLibraries(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listFunctionLibraries6
            
          */
        public void startlistFunctionLibraries(

            

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param createFunctionLibrary9
                
             * @throws org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException : 
         */

         
                     public void createFunctionLibrary(

                        org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary10)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param createFunctionLibrary9
            
          */
        public void startcreateFunctionLibrary(

            org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary10,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteFunctionLibrary12
                
             * @throws org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException : 
         */

         
                     public void deleteFunctionLibrary(

                        java.lang.String functionLibraryName13)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteFunctionLibrary12
            
          */
        public void startdeleteFunctionLibrary(

            java.lang.String functionLibraryName13,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateFunctionLibrary15
                
             * @throws org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException : 
         */

         
                     public void updateFunctionLibrary(

                        org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary16,java.lang.String oldFunctionLibraryName17)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateFunctionLibrary15
            
          */
        public void startupdateFunctionLibrary(

            org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary16,java.lang.String oldFunctionLibraryName17,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getFunctionLibrary19
                
             * @throws org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException : 
         */

         
                     public org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary getFunctionLibrary(

                        java.lang.String functionLibraryName20)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceFunctionLibraryManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getFunctionLibrary19
            
          */
        public void startgetFunctionLibrary(

            java.lang.String functionLibraryName20,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    