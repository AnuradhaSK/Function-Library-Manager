

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
                    * @param loadFunctionLibrary6
                
         */

         
                     public org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary loadFunctionLibrary(

                        java.lang.String functionLibraryName7)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param loadFunctionLibrary6
            
          */
        public void startloadFunctionLibrary(

            java.lang.String functionLibraryName7,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllFunctionLibraries10
                
         */

         
                     public org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary[] getAllFunctionLibraries(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllFunctionLibraries10
            
          */
        public void startgetAllFunctionLibraries(

            

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param createFunctionLibrary13
                
         */

         
                     public void createFunctionLibrary(

                        org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary14)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param createFunctionLibrary13
            
          */
        public void startcreateFunctionLibrary(

            org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary14,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteFunctionLibrary16
                
         */

         
                     public void deleteFunctionLibrary(

                        java.lang.String functionLibraryName17)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteFunctionLibrary16
            
          */
        public void startdeleteFunctionLibrary(

            java.lang.String functionLibraryName17,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateFunctionLibrary19
                
         */

         
                     public void updateFunctionLibrary(

                        org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary20,java.lang.String oldFunctionLibraryName21)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateFunctionLibrary19
            
          */
        public void startupdateFunctionLibrary(

            org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary functionLibrary20,java.lang.String oldFunctionLibraryName21,

            final org.wso2.carbon.function.mgt.stub.FunctionLibraryManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    