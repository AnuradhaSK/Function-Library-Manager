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
<%@ page import="org.apache.axis2.context.ConfigurationContext" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>
<%@ page import="org.wso2.carbon.utils.ServerConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage" %>

<script type="text/javascript">
    function createFunctionLibOnclick() {
        var functionLibName = document.getElementById("functionLibName").value;
        var description = document.getElementById("functionLib-description").value;
        if( functionLibName == '') {
            CARBON.showWarningDialog('Please provide function library ID');
            location.href = '#';
        } else if (!validateTextForIllegal(document.getElementById("functionLibName"))) {
            return false;
        }else {
            $("#add-functionlib-form").submit();
            return true;
        }
    }
    function validateTextForIllegal(fild) {
        var isValid = doValidateInput(fild, "Provided function library name is invalid.");
        if (isValid) {
            return true;
        } else {
            return false;
        }
    }
    var openFile = function (event) {
        var input = event.target;
        var reader = new FileReader();
        reader.onload = function () {
            var data = reader.result;
            document.getElementById('functionlib-file-content').value = data;
        };
        document.getElementById('functionlib-file-name').value = input.files[0].name;
        reader.readAsText(input.files[0]);
    };
    function importFunctionLibOnclick()() {
        
    }
    function showManual() {
        $("#add-functionlib-form").show();
        $("#upload-functionlib-form").hide();
    }
    function showFile() {
        $("#add-functionlib-form").hide();
        $("#upload-functionlib-form").show();
    }



</script>

<fmt:bundle basename="org.wso2.carbon.function.mgt.ui.i18n.Resources">
    <div id="workArea">
    <div id="middle">
        <h2>Add New Function Library</h2>
        <table class="styledLeft" width="100%">
            <thead>
            <tr>
                <th><fmt:message key="title.functionlib.select.mode"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="radio" id="manual-option" name="upload-type-selector" checked="checked"
                           onclick="showManual();">
                    <label for="manual-option">Manual Configuration</label>
                </td>

            </tr>
            <tr>
                <td>
                    <input type="radio" id="file-option" name="upload-type-selector" onclick="showFile();">
                    <label for="file-option">File Configuration</label>
                </td>
            </tr>

            </tbody>
        </table>
        <br/>
        <form id="add-functionlib-form" name="add-functionlib-form" method="post"
              action="add-functionlib-finish-ajaxprocessor.jsp">
            <div class="sectionSeperator togglebleTitle"><fmt:message key='title.config.function.basic.config'/></div>
            <div class="sectionSub">
                <table class="carbonFormTable">
                    <tr>
                        <td style="width:15%" class="leftCol-med labelField"><fmt:message key='config.function.info.basic.name'/>:<span class="required">*</span></td>
                        <td>
                            <input id="functionLibName" name="functioLibnName" type="text" value="" white-list-patterns="^[a-zA-Z0-9\s._-]*$" autofocus/>
                            <div class="sectionHelp">
                                <fmt:message key='help.name'/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="leftCol-med labelField">Description:</td>
                        <td>
                            <textarea style="width:50%" type="text" name="functionLib-description" id="functionLib-description" class="text-box-big"></textarea>
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
            style="height: 500px;width: 100%; display: block;">

            </textarea>

        </div>

            </div>
            </div>
        <div style="clear:both"></div>
        <div class="buttonRow" style=" margin-top: 10px;">
            <input id="createLib" type="button" value="<fmt:message key='button.reg.function.manager'/>"  onclick="createFunctionLibOnclick()"/>
            <input type="button" value="<fmt:message key='button.cancel'/>"
                   javascript:location.href='function-mgt-add.jsp'/>
        </div>
        </form>

        <form id="upload-functionlib-form" name="upload-functionlib-form" method="post"
              action="#">
            <table class="styledLeft" width="100%">
                <thead>
                <tr>
                    <th><fmt:message key="upload.function.library.file"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <span>File Location: </span><input type="file" class="button" id="functionlib_file" name="functionlib_file" onchange='openFile(event)'/>
                    </td>
                    <textarea hidden="hidden" name="functionlib-file-content" id="functionlib-file-content"></textarea>
                    <textarea hidden="hidden" name="functionlib-file-name" id="functionlib-file-name"></textarea>
                </tr>
                <tr>
                    <td>
                        <input type="button" class="button"  value="<fmt:message key='button.import.function.library'/>"
                               onclick="importFunctionLibOnclick();"/>
                        <input type="button" class="button" onclick="javascript:location.href='function-mgt-list.jsp'" value="<fmt:message key='button.cancel'/>" />
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    </div>
</fmt:bundle>
<script src="./js/function-lib-mgt.js"></script>