package org.wso2.carbon.function.mgt.data;

public class Function {
    private int ID;
    private String Name;

    public Function(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
}
