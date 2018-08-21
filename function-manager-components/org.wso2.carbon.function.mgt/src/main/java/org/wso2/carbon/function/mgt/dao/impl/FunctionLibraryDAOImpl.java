package org.wso2.carbon.function.mgt.dao.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.database.utils.jdbc.JdbcTemplate;
import org.wso2.carbon.function.mgt.FunctionLibMgtDBQueries;
import org.wso2.carbon.function.mgt.dao.FunctionLibraryDAO;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;
import org.wso2.carbon.function.mgt.util.JdbcUtils;
import org.wso2.carbon.identity.core.util.IdentityTenantUtil;
import org.wso2.carbon.utils.multitenancy.MultitenantConstants;


public class FunctionLibraryDAOImpl implements FunctionLibraryDAO {

    private static Log log = LogFactory.getLog(FunctionLibraryDAOImpl.class);

    public void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain) {

        // get logged-in users tenant identifier.
        int tenantID = MultitenantConstants.INVALID_TENANT_ID;

        if (tenantDomain != null) {
            tenantID = IdentityTenantUtil.getTenantId(tenantDomain);
        }
        JdbcTemplate jdbcTemplate = JdbcUtils.getNewTemplate();

//        jdbcTemplate.executeInsert(FunctionLibMgtDBQueries.STORE_FUNCTIONLIB_INFO,(preparedStatement -> {
//            preparedStatement.setString(1, functionLibrary.getFunctionLibraryName());
//            preparedStatement.setString(2, functionLibrary.getDescription());
//            preparedStatement.setString(3, "authentication");
//            preparedStatement.setInt(4, tenantID);
//            preparedStatement.setBlob(5, );
//        }),functionLibrary,true);

        if (log.isDebugEnabled()) {
            log.debug("Function Library Stored successfully ");
        }

    }

    public FunctionLibrary loadFunctionLibrary() {
        return new FunctionLibrary();
    }

    public void updateFunctionLibrary() {

    }

    public void deleteFunctionLibrary() {

    }
}
