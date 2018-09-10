
/**
 * FunctionLibraryManagementAdminServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v10  Built on : Sep 04, 2013 (02:02:54 UTC)
 */

    package org.wso2.carbon.function.mgt.stub;

    /**
     *  FunctionLibraryManagementAdminServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class FunctionLibraryManagementAdminServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public FunctionLibraryManagementAdminServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public FunctionLibraryManagementAdminServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for loadFunctionLibrary method
            * override this method for handling normal response from loadFunctionLibrary operation
            */
           public void receiveResultloadFunctionLibrary(
                    org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from loadFunctionLibrary operation
           */
            public void receiveErrorloadFunctionLibrary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllFunctionLibraries method
            * override this method for handling normal response from getAllFunctionLibraries operation
            */
           public void receiveResultgetAllFunctionLibraries(
                    org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllFunctionLibraries operation
           */
            public void receiveErrorgetAllFunctionLibraries(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createFunctionLibrary method
            * override this method for handling normal response from createFunctionLibrary operation
            */
           public void receiveResultcreateFunctionLibrary(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createFunctionLibrary operation
           */
            public void receiveErrorcreateFunctionLibrary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteFunctionLibrary method
            * override this method for handling normal response from deleteFunctionLibrary operation
            */
           public void receiveResultdeleteFunctionLibrary(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteFunctionLibrary operation
           */
            public void receiveErrordeleteFunctionLibrary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateFunctionLibrary method
            * override this method for handling normal response from updateFunctionLibrary operation
            */
           public void receiveResultupdateFunctionLibrary(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateFunctionLibrary operation
           */
            public void receiveErrorupdateFunctionLibrary(java.lang.Exception e) {
            }
                


    }
    