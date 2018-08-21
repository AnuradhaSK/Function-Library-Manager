var myCodeMirror = CodeMirror.fromTextArea(scriptTextArea, {
    theme: "mdn-like",
    keyMap: "sublime",
    mode: "javascript",
    lineNumbers: true,
    lineWrapping: true,
    lineWiseCopyCut: true,
    pasteLinesPerSelection: true,
    // extraKeys: {
    //     "Ctrl-Space": "autocomplete",
    //     "F11": function (myCodeMirror) {
    //         myCodeMirror.setOption("fullScreen", !myCodeMirror.getOption("fullScreen"));
    //     },
    //     "Esc": function (myCodeMirror) {
    //         if (myCodeMirror.getOption("fullScreen")) myCodeMirror.setOption("fullScreen", false);
    //     },
    //     "Shift-Ctrl-F": function (myCodeMirror) {
    //         CodeMirror.commands["selectAll"](myCodeMirror);
    //         autoFormatSelection(myCodeMirror);
    //     }
    // },
    indentWithTabs: true,
    autoCloseBrackets: true,
    matchBrackets: true,
    gutters: ["CodeMirror-lint-markers", "CodeMirror-linenumbers", "CodeMirror-foldgutter"],
    foldGutter: true,
    lint: true,
    showCursorWhenSelecting: true,
    styleActiveLine: true,
});
