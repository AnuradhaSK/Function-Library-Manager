package org.wso2.carbon.function.mgt.internal;

import javax.sql.DataSource;

public class FunctionLibraryManagementComponentDataHolder {

    private static FunctionLibraryManagementComponentDataHolder instance = new FunctionLibraryManagementComponentDataHolder();
    private DataSource dataSource;

    public static FunctionLibraryManagementComponentDataHolder getInstance() {

        return instance;
    }

    public DataSource getDataSource() {

        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
    }
}
