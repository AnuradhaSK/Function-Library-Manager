
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v10  Built on : Apr 16, 2014 (01:16:09 UTC)
 */

        
            package org.wso2.carbon.function.mgt;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://model.mgt.function.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "FunctionLibrary".equals(typeName)){
                   
                            return  org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://exception.mgt.function.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "FunctionLibraryManagementException".equals(typeName)){
                   
                            return  org.wso2.carbon.function.mgt.exception.xsd.FunctionLibraryManagementException.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    