package org.wso2.carbon.function.mgt.util;

import org.wso2.carbon.database.utils.jdbc.JdbcTemplate;
import org.wso2.carbon.function.mgt.internal.FunctionLibraryManagementComponentDataHolder;

public class JdbcUtils {
    /**
     * Get a new Jdbc Template.
     *
     * @return a new Jdbc Template.
     */
    public static JdbcTemplate getNewTemplate() {

        return new JdbcTemplate(FunctionLibraryManagementComponentDataHolder.getInstance().getDataSource());
    }
}
