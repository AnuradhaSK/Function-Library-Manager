<%@ taglib prefix="carbon" uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="org.wso2.carbon.utils.ServerConstants" %>
<%@ page import="org.apache.axis2.context.ConfigurationContext" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>
<%@ page import="org.wso2.carbon.function.mgt.ui.client.FunctionLibraryManagementServiceClient" %>
<%@ page import="org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage" %>
<%@ page import="org.owasp.encoder.Encode" %>

<fmt:bundle
        basename="org.wso2.carbon.function.mgt.ui.i18n.Resources">
    <carbon:breadcrumb label="functionlib.mgt"
                       resourceBundle="org.wso2.carbon.function.mgt.ui.i18n.Resources"
                       topPage="true" request="<%=request%>"/>



    <%
        String functionLibraryName = request.getParameter("functionLibraryName");
        String BUNDLE = "org.wso2.carbon.function.mgt.ui.i18n.Resources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE, request.getLocale());

        if (functionLibraryName != null && !"".equals(functionLibraryName)) {

            try {

                String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);
                String backendServerURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
                ConfigurationContext configContext = (ConfigurationContext) config.getServletContext().getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);

                FunctionLibraryManagementServiceClient serviceClient = new FunctionLibraryManagementServiceClient(cookie, backendServerURL, configContext);
                FunctionLibrary functionLibrary = serviceClient.loadFunctionLibrary(functionLibraryName);


            } catch (Exception e) {
                String message = resourceBundle.getString("alert.error.while.reading.function.libraries") + " : " + e.getMessage();
                CarbonUIMessage.sendCarbonUIMessage(message, CarbonUIMessage.ERROR, request, e);
            }
        }
    %>
    <script>
        location.href = 'function-mgt-edit.jsp?functionLibraryName=<%=Encode.forUriComponent(functionLibraryName)%>';
    </script>
</fmt:bundle>