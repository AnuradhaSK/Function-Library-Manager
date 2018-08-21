package org.wso2.carbon.function.mgt.model;

public class FunctionLibrary {

    private String functionLibraryName;
    private String description;

    public FunctionLibrary(String functionLibraryName) {
        this.functionLibraryName = functionLibraryName;
    }

    public FunctionLibrary() {

    }

    /**
     * Get function library name.
     *
     * @return function library name
     */
    public String getFunctionLibraryName() {
        return functionLibraryName;
    }

    /**
     * Set function library name.
     *
     * @param functionLibraryName function library name
     */
    public void setFunctionLibraryName(String functionLibraryName) {
        this.functionLibraryName = functionLibraryName;
    }

    /**
     * Get function library description.
     *
     * @return function library description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set function library description.
     *
     * @param description function library description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}


