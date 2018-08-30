<%@ page import="org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary" %>
<%@ page import="org.wso2.carbon.utils.ServerConstants" %>
<%@ page import="org.apache.axis2.context.ConfigurationContext" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.function.mgt.ui.client.FunctionLibraryManagementServiceClient" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>
<%

    String httpMethod = request.getMethod();
    if (!"post".equalsIgnoreCase(httpMethod)) {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return;
    }

    String functionLibName = request.getParameter("functionLibName");
    String description = request.getParameter("functionLib-description");
    String content = request.getParameter("scriptTextArea");


    if (functionLibName != null && !"".equals(functionLibName)) {

        FunctionLibrary functionLibrary = new FunctionLibrary();
        functionLibrary.setFunctionLibraryName(functionLibName);
        functionLibrary.setDescription(description);
        functionLibrary.setFunctionLibraryScript(content);
        System.out.println(functionLibName);
        String backendServerURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
        ConfigurationContext configContext =
                (ConfigurationContext) config.getServletContext().getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);
        String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);

        FunctionLibraryManagementServiceClient serviceClient = new FunctionLibraryManagementServiceClient(cookie,backendServerURL,configContext);
        serviceClient.createFunctionLibrary(functionLibrary);
        %>
<script>
    location.href = 'function-mgt-add.jsp';
</script>
<%}
else
{%>
    <script>
        location.href = 'function-mgt-add.jsp';
</script>
<%}
%>


    }
