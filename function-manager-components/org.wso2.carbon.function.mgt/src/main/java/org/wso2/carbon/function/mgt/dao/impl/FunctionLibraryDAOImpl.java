package org.wso2.carbon.function.mgt.dao.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.function.mgt.FunctionLibMgtDBQueries;
import org.wso2.carbon.function.mgt.dao.FunctionLibraryDAO;
import org.wso2.carbon.function.mgt.model.FunctionLibrary;
import org.wso2.carbon.identity.core.util.IdentityDatabaseUtil;
import org.wso2.carbon.identity.core.util.IdentityTenantUtil;
import org.wso2.carbon.utils.multitenancy.MultitenantConstants;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FunctionLibraryDAOImpl implements FunctionLibraryDAO {

    private static Log log = LogFactory.getLog(FunctionLibraryDAOImpl.class);

    public void createFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain) {

        // get logged-in users tenant identifier.
        int tenantID = MultitenantConstants.INVALID_TENANT_ID;

        if (tenantDomain != null) {
            tenantID = IdentityTenantUtil.getTenantId(tenantDomain);
        }

        Connection connection = IdentityDatabaseUtil.getDBConnection();
        PreparedStatement addFunctionLibStmt = null;


        try {
            addFunctionLibStmt = connection.prepareStatement(FunctionLibMgtDBQueries.STORE_FUNCTIONLIB_INFO);
            addFunctionLibStmt.setString(1, functionLibrary.getFunctionLibraryName());
            addFunctionLibStmt.setString(2, functionLibrary.getDescription());
            addFunctionLibStmt.setString(3, "authentication");
            addFunctionLibStmt.setInt(4, tenantID);
            setBlobValue(functionLibrary.getFunctionLibraryScript(),addFunctionLibStmt,5);
            addFunctionLibStmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            IdentityDatabaseUtil.closeStatement(addFunctionLibStmt);
            IdentityDatabaseUtil.closeConnection(connection);
        }


        if (log.isDebugEnabled()) {
            log.debug("Function Library Stored successfully ");
        }

    }

    public FunctionLibrary loadFunctionLibrary(String functionLibraryName, String tenantDomain) {
        // get logged-in users tenant identifier.
        int tenantID = MultitenantConstants.INVALID_TENANT_ID;

        if (tenantDomain != null) {
            tenantID = IdentityTenantUtil.getTenantId(tenantDomain);
        }

        Connection connection = IdentityDatabaseUtil.getDBConnection();
        PreparedStatement getFunctionLibStmt =null;
        ResultSet resultSet = null;
        FunctionLibrary functionlib = new FunctionLibrary();
        try {
            getFunctionLibStmt = connection.prepareStatement(FunctionLibMgtDBQueries.LOAD_FUNCTIONLIB_FROM_TENANTID_AND_NAME);
            getFunctionLibStmt.setInt(1, tenantID);
            getFunctionLibStmt.setString(2, functionLibraryName);
            resultSet = getFunctionLibStmt.executeQuery();
            if(resultSet.next()){
                functionlib.setFunctionLibraryName(resultSet.getString("NAME"));
                functionlib.setDescription(resultSet.getString("DESCRIPTION"));
                functionlib.setFunctionLibraryScript(resultSet.getString("DATA"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            IdentityDatabaseUtil.closeStatement(getFunctionLibStmt);
            IdentityDatabaseUtil.closeResultSet(resultSet);
            IdentityDatabaseUtil.closeConnection(connection);
        }
        return functionlib;

    }

    public FunctionLibrary[] getAllFunctionLibraries(String tenantDomain) {
        int tenantID = MultitenantConstants.INVALID_TENANT_ID;

        if (tenantDomain != null) {
            tenantID = IdentityTenantUtil.getTenantId(tenantDomain);
        }
        Connection connection = IdentityDatabaseUtil.getDBConnection();
        PreparedStatement getFunctionLibrariesStmt = null;
        ResultSet functionLibsResultSet = null;

        ArrayList<FunctionLibrary> functionLibraries = new ArrayList<>();

        try {
            getFunctionLibrariesStmt = connection.prepareStatement(FunctionLibMgtDBQueries.LOAD_FUNCTIONLIB_FROM_TENANTID);
            getFunctionLibrariesStmt.setInt(1, tenantID);
            functionLibsResultSet = getFunctionLibrariesStmt.executeQuery();
            while (functionLibsResultSet.next()){
                FunctionLibrary functionlib=new FunctionLibrary();
                functionlib.setFunctionLibraryName(functionLibsResultSet.getString("NAME"));
                functionlib.setDescription(functionLibsResultSet.getString("DESCRIPTION"));
                functionlib.setFunctionLibraryScript(functionLibsResultSet.getString("DATA"));
                functionLibraries.add(functionlib);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            IdentityDatabaseUtil.closeStatement(getFunctionLibrariesStmt);
            IdentityDatabaseUtil.closeResultSet(functionLibsResultSet);
            IdentityDatabaseUtil.closeConnection(connection);
        }
        return functionLibraries.toArray(new FunctionLibrary[functionLibraries.size()]);

    }


    public void updateFunctionLibrary(FunctionLibrary functionLibrary, String tenantDomain, String oldFunctionLibName) {
        // get logged-in users tenant identifier.
        int tenantID = MultitenantConstants.INVALID_TENANT_ID;

        if (tenantDomain != null) {
            tenantID = IdentityTenantUtil.getTenantId(tenantDomain);
        }
        Connection connection = IdentityDatabaseUtil.getDBConnection();
        PreparedStatement updateFunctionLibStmt = null;
        try {
            updateFunctionLibStmt=connection.prepareStatement(FunctionLibMgtDBQueries.UPDATE_FUNCTIONLIB_INFO);
            updateFunctionLibStmt.setString(1,functionLibrary.getFunctionLibraryName());
            updateFunctionLibStmt.setString(2,functionLibrary.getDescription());
            setBlobValue(functionLibrary.getFunctionLibraryScript(),updateFunctionLibStmt,3);
            updateFunctionLibStmt.setInt(4,tenantID);
            updateFunctionLibStmt.setString(5,oldFunctionLibName);
            updateFunctionLibStmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            IdentityDatabaseUtil.closeConnection(connection);
            IdentityDatabaseUtil.closeStatement(updateFunctionLibStmt);
        }

    }

    public void deleteFunctionLibrary(String functionLibraryName, String tenantDomain) {
        int tenantID = MultitenantConstants.INVALID_TENANT_ID;

        if (tenantDomain != null) {
            tenantID = IdentityTenantUtil.getTenantId(tenantDomain);
        }
        Connection connection = IdentityDatabaseUtil.getDBConnection();
        PreparedStatement deleteFunctionLibStmt = null;

        try {
            deleteFunctionLibStmt=connection.prepareStatement(FunctionLibMgtDBQueries.REMOVE_FUNCTIONLIB);
            deleteFunctionLibStmt.setInt(1, tenantID);
            deleteFunctionLibStmt.setString(2,functionLibraryName);
            deleteFunctionLibStmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            IdentityDatabaseUtil.closeConnection(connection);
            IdentityDatabaseUtil.closeStatement(deleteFunctionLibStmt);
        }

    }

    /**
     * Set given string as Blob for the given index into the prepared-statement
     *
     * @param value    string value to be converted to blob
     * @param prepStmt Prepared statement
     * @param index    column index
     * @throws SQLException
     * @throws IOException
     */
    private void setBlobValue(String value, PreparedStatement prepStmt, int index) throws SQLException, IOException {
        if (value != null) {
            InputStream inputStream = new ByteArrayInputStream(value.getBytes());
            prepStmt.setBinaryStream(index, inputStream, inputStream.available());
        } else {
            prepStmt.setBinaryStream(index, new ByteArrayInputStream(new byte[0]), 0);
        }
    }

    /**
     * Get string from inputStream of a blob
     *
     * @param is input stream
     * @return
     * @throws IOException
     */
    private String getBlobValue(InputStream is) throws IOException {

        if (is != null) {
            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        log.error("Error in retrieving the Blob value", e);
                    }
                }
            }

            return sb.toString();
        }
        return null;
    }
}
