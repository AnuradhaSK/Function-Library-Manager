<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="carbon" uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar"%>
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
<fmt:bundle basename="org.wso2.carbon.function.mgt.ui.i18n.Resources">
    <div id="middle">
        <h2>Function Library Management</h2>

        <div id="workArea">

            <div class="sectionSeperator togglebleTitle"><fmt:message key="title.config.import.functionlibrary"/></a></div>


            <div class="toggle_container sectionSub" style="margin-bottom:10px;" id="stepsConfRow">
                <table>
                    <tr>
                        <td><a title="<fmt:message key='import.function.info'/>"
                               onclick=""
                               href="#"
                               class="icon-link"
                               style="background-image: url(images/import.gif)">
                            <fmt:message key='import'/>
                        </a>
                        </td>
                    </tr>
                </table>
            </div>
            <table class="styledLeft" id="moduleTable">
                <thead>
                <tr>
                    <th width="60%">Name</th>
                    <th width="40%">Actions</th>

                </tr>
                </thead>
                <tbody>
                <%
                    for(Function function:functions){
                %>
                <tr>

                    <td><%=function.getName()%></td>
                    <td>
                        <a title="<fmt:message key='edit.function.info'/>"
                           onclick=""
                           href="function-mgt-edit.jsp"
                           class="icon-link"
                           style="background-image: url(images/edit.gif)">
                            <fmt:message key='edit'/>
                        </a>
                        <a title="<fmt:message key='export.function.info'/>"
                           onclick=""
                           href="#"
                           class="icon-link"
                           style="background-image: url(images/export.gif)">
                            <fmt:message key='export'/>
                        </a>
                        <a title="<fmt:message key='delete.function.info'/>"
                           onclick=""
                           href="#"
                           class="icon-link"
                           style="background-image: url(images/delete.gif)">
                            <fmt:message key='delete'/>
                        </a>


                    </td>

                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</fmt:bundle>
