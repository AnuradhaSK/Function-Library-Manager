package org.wso2.carbon.function.mgt.data;

public class Function {
    private String Name;

    public Function(String Name) {
        this.Name = Name;
    }


    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
}
