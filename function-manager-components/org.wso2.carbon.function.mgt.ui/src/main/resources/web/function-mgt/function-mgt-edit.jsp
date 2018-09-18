<link rel="stylesheet" href="codemirror/lib/codemirror.css">
<link rel="stylesheet" href="codemirror/theme/mdn-like.css">
<link rel="stylesheet" href="codemirror/addon/dialog/dialog.css">
<link rel="stylesheet" href="codemirror/addon/display/fullscreen.css">
<link rel="stylesheet" href="codemirror/addon/fold/foldgutter.css">
<link rel="stylesheet" href="codemirror/addon/hint/show-hint.css">
<link rel="stylesheet" href="codemirror/addon/lint/lint.css">

<link rel="stylesheet" href="css/function-lib-mgt.css">

<script src="codemirror/lib/codemirror.js"></script>
<script src="codemirror/keymap/sublime.js"></script>
<script src="codemirror/mode/javascript/javascript.js"></script>

<script src="codemirror/addon/lint/jshint.min.js"></script>
<script src="codemirror/addon/lint/lint.js"></script>
<script src="codemirror/addon/lint/javascript-lint.js"></script>
<script src="codemirror/addon/hint/anyword-hint.js"></script>
<script src="codemirror/addon/hint/show-hint.js"></script>
<script src="codemirror/addon/hint/javascript-hint.js"></script>
<script src="codemirror/addon/hint/wso2-hints.js"></script>

<script src="codemirror/addon/edit/closebrackets.js"></script>
<script src="codemirror/addon/edit/matchbrackets.js"></script>
<script src="codemirror/addon/fold/brace-fold.js"></script>
<script src="codemirror/addon/fold/foldcode.js"></script>
<script src="codemirror/addon/fold/foldgutter.js"></script>
<script src="codemirror/addon/display/fullscreen.js"></script>
<script src="codemirror/addon/display/placeholder.js"></script>
<script src="codemirror/addon/comment/comment.js"></script>
<script src="codemirror/addon/selection/active-line.js"></script>
<script src="codemirror/addon/dialog/dialog.js"></script>
<script src="codemirror/addon/display/panel.js"></script>
<script src="codemirror/util/formatting.js"></script>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="carbon" uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="org.wso2.carbon.utils.ServerConstants" %>
<%@ page import="org.apache.axis2.context.ConfigurationContext" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.function.mgt.model.xsd.FunctionLibrary" %>
<%@ page import="org.wso2.carbon.function.mgt.ui.client.FunctionLibraryManagementServiceClient" %>
<%@ page import="org.owasp.encoder.Encode" %>


<script type="text/javascript">
    function UpdateFunctionLibOnclick() {
        var functionLibName = document.getElementById("functionLibraryName").value;
        console.log(functionLibName);
        if( functionLibName == '') {
            CARBON.showWarningDialog('Please provide function library Name');
            location.href = '#';
            /*} else if (!validateTextForIllegal(document.getElementById("functionLibName"))) {
                 return false;*/
        }else {
            $("#update-functionlib-form").submit();
            return true;
        }
    }
</script>
<fmt:bundle
        basename="org.wso2.carbon.function.mgt.ui.i18n.Resources">
    <carbon:breadcrumb label="functionlib.mgt"
                       resourceBundle="org.wso2.carbon.function.mgt.ui.i18n.Resources"
                       topPage="true" request="<%=request%>"/>



    <%
        String functionLibraryName = request.getParameter("functionLibraryName");
        String BUNDLE = "org.wso2.carbon.function.mgt.ui.i18n.Resources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE, request.getLocale());
        FunctionLibrary functionLibrary =null;
        if (functionLibraryName != null && !"".equals(functionLibraryName)) {

            try {
                String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);
                String backendServerURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
                ConfigurationContext configContext = (ConfigurationContext) config.getServletContext().getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);

                FunctionLibraryManagementServiceClient serviceClient = new FunctionLibraryManagementServiceClient(cookie, backendServerURL, configContext);
                functionLibrary = serviceClient.getFunctionLibrary(functionLibraryName);


            } catch (Exception e) {
                String message = resourceBundle.getString("alert.error.while.reading.function.libraries") + " : " + e.getMessage();
                CarbonUIMessage.sendCarbonUIMessage(message, CarbonUIMessage.ERROR, request, e);
            }
        }

    %>
    <div id="workArea">
        <div id="middle">
            <h2>Edit Function Library</h2>

            <form id="update-functionlib-form" name="update-functionlib-form" method="post"
                  action="edit-functionlib-finish-ajaxprocessor.jsp">

                <input type="hidden" name="oldFunctionLibraryName" id="oldFunctionLibraryName" value="<%=Encode.forHtmlAttribute(functionLibraryName)%>"/>

                <div class="sectionSeperator togglebleTitle"><fmt:message key='title.config.function.basic.config'/></div>
                <div class="sectionSub">
                    <table class="carbonFormTable">
                        <tr>
                            <td style="width:15%" class="leftCol-med labelField"><fmt:message key='config.function.info.basic.name'/>:<span class="required">*</span></td>
                            <td>
                                <input id="functionLibraryName" name="functionLibraryName" type="text" value="<%=Encode.forHtmlAttribute(functionLibraryName)%>" white-list-patterns="^[a-zA-Z0-9\s._-]*$" autofocus/>
                                <div class="sectionHelp">
                                    <fmt:message key='help.name'/>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td class="leftCol-med labelField">Description:</td>
                            <td>
                                <textarea style="width:50%" type="text" name="functionLib-description" id="functionLib-description" class="text-box-big"><%=functionLibrary.getDescription() != null ? Encode.forHtmlContent(functionLibrary.getDescription()):""%>
                                </textarea>
                                <div class="sectionHelp">
                                    <fmt:message key='help.desc'/>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>

                <h2 id="authentication_step_config_head" class="sectionSeperator trigger active">
                    <a href="#">Function Library Script</a>
                </h2>
                <div class="toggle_container" id="editorRow">
                    <div style="position: relative;">
                        <div id="codeMirror">
            <textarea id="scriptTextArea" name="scriptTextArea"
                      placeholder="Write JavaScript Function..."
                      style="height: 500px;width: 100%; display: block;"><%=functionLibrary.getFunctionLibraryScript() != null ? Encode.forHtmlContent(functionLibrary.getFunctionLibraryScript()) : "" %>
            </textarea>

                        </div>

                    </div>
                </div>
                <div style="clear:both"></div>
                <div class="buttonRow" style=" margin-top: 10px;">
                    <input id="update" type="button" value="<fmt:message key='button.update.function.manager'/>"
                        onclick="UpdateFunctionLibOnclick()"/>
                    <input type="button" onclick="javascript:location.href='function-mgt-list.jsp'" value="<fmt:message key='button.cancel'/>" />
                </div>
            </form>
        </div>
    </div>
</fmt:bundle>
<script src="./js/function-lib-mgt.js"></script>