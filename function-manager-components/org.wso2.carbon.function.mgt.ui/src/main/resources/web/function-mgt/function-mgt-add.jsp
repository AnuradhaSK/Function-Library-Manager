<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="carbon" uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar"%>
<%@ page import="org.apache.axis2.context.ConfigurationContext" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>
<%@ page import="org.wso2.carbon.utils.ServerConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage" %>


<fmt:bundle basename="org.wso2.carbon.function.mgt.ui.i18n.Resources">
    <div id="workArea">
    <div id="middle">
        <h2>Add New Function Library</h2>

        <form id="add-function-form" name="add-function-library-form" method="post"
              action="">
            <div class="sectionSeperator togglebleTitle"><fmt:message key='title.config.function.basic.config'/></div>
            <div class="sectionSub">
                <table class="carbonFormTable">
                    <tr>
                        <td style="width:15%" class="leftCol-med labelField"><fmt:message key='config.function.info.basic.name'/>:<span class="required">*</span></td>
                        <td>
                            <input id="functionName" name="functionName" type="text" value="" white-list-patterns="^[a-zA-Z0-9\s._-]*$" autofocus/>
                            <div class="sectionHelp">
                                <fmt:message key='help.name'/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="leftCol-med labelField">Description:</td>
                        <td>
                            <textarea style="width:50%" type="text" name="function-description" id="function-description" class="text-box-big"></textarea>
                            <div class="sectionHelp">
                                <fmt:message key='help.desc'/>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>

        <h2 id="authentication_step_config_head" class="sectionSeperator trigger active">
            <a href="#">Function Script</a>
        </h2>
    <div>
    <textarea id="scriptTextArea" name="scriptTextArea"
              placeholder="Write JavaScript Function..."
              style="height: 500px;width: 100%; display: block;">

    </textarea>


    </div>

        <div style="clear:both"></div>
        <div class="buttonRow" style=" margin-top: 10px;">
            <input id="createApp" type="button" value="<fmt:message key='button.update.function.manager'/>"/>
            <input type="button" value="<fmt:message key='button.cancel'/>"
                   onclick=""/>
        </div>
        </form>
    </div>
    </div>
</fmt:bundle>