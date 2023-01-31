package com.phone.service.dao;

import com.phone.service.dto.Client;
import com.phone.service.dto.Company;
import com.phone.service.enums.DbActionEnum;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
public class AbstractDAO {

    protected JdbcTemplate jdbcTemplate;

    protected void callClientProcedure(Client client, String procedureName) {
        List<SqlParameter> sqlParameters = Arrays.asList(
            new SqlParameter(Types.VARCHAR)
            , new SqlParameter(Types.VARCHAR));

        this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement callableStatement = con.prepareCall(procedureName);
                callableStatement.setString(1, client.getSecurityCode());
                callableStatement.setString(2, client.getFullName());

                return callableStatement;
            }
        }, sqlParameters);
    }

    protected void callCompanyProcedure(Company company, DbActionEnum dbAction) {
        List<SqlParameter> sqlParameters = Arrays.asList(
            new SqlParameter(Types.INTEGER)
            , new SqlParameter(Types.VARCHAR)
            , new SqlParameter(Types.VARCHAR)
            , new SqlParameter(Types.VARCHAR)
            , new SqlParameter(Types.INTEGER));

        this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement callableStatement = con.prepareCall("call sp_manage_company(?, ?, ?, ?, ?)");
                callableStatement.setLong(1, company.getId());
                callableStatement.setString(2, dbAction.getAction());
                callableStatement.setString(3, company.getName());
                callableStatement.setString(4, company.getAddress());
                callableStatement.setInt(5, company.getPhoneNumber());

                return callableStatement;
            }
        }, sqlParameters);
    }
}
