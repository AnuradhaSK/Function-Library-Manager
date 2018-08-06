<%@ page import="org.apache.axis2.context.ConfigurationContext" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>
<%@ page import="org.wso2.carbon.utils.ServerConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage" %>
<%@ page import="org.wso2.carbon.function.mgt.ui.FunctionManagerClient" %>
<%@ page import="org.wso2.carbon.function.mgt.data.xsd.Function" %>

<%
        String serverURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
        ConfigurationContext configContext =
                (ConfigurationContext) config.getServletContext().getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);
        String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);

        FunctionManagerClient client;
        Function[] functions;

        try {
            client = new FunctionManagerClient(configContext, serverURL, cookie);
            functions = client.getFunctions();
        } catch (Exception e) {
            CarbonUIMessage.sendCarbonUIMessage(e.getMessage(), CarbonUIMessage.ERROR, request, e);
%>
            <script type="text/javascript">
                   location.href = "../admin/error.jsp";
            </script>
<%
            return;
    }
%>

<div id="middle">
    <h2>Function Management</h2>

    <div id="workArea">
        <table class="styledLeft" id="moduleTable">
                <thead>
                <tr>
                    <th width="20%">ID</th>
                    <th width="40%">Name</th>
                </tr>
                </thead>
                <tbody>
           <%
                   for(Function function:functions){
           %>
                   <tr>
                       <td><%=function.getID()%></td>
                    <td><%=function.getName()%></td>

                </tr>
           <%
                   }
           %>
                </tbody>
         </table>
    </div>
</div>