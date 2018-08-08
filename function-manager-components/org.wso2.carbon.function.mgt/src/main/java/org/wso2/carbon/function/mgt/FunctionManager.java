package org.wso2.carbon.function.mgt;
import org.wso2.carbon.function.mgt.data.Function;
public class FunctionManager {
    private Function[] functions;

    public FunctionManager() {
        functions = new Function[2];
        functions[0] = new Function("function lib 1");
        functions[1] = new Function("function lib 2");
    }

    public Function[] getFunctions() {
        return functions;
    }

}
