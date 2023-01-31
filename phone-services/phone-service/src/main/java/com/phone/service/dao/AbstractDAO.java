package com.phone.service.dao;

import com.phone.service.dto.Client;
import com.phone.service.dto.Company;
import com.phone.service.dto.PhoneServiceDTO;
import com.phone.service.dto.Plan;
import com.phone.service.enums.DbActionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

public class AbstractDAO {

    @Autowired
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

                if (null != company.getId()) {
                    callableStatement.setLong(1, company.getId());
                } else {
                    callableStatement.setNull(1, Types.NULL);
                }

                callableStatement.setString(2, dbAction.getAction());
                callableStatement.setString(3, company.getName());
                callableStatement.setString(4, company.getAddress());
                callableStatement.setInt(5, company.getPhoneNumber());

                return callableStatement;
            }
        }, sqlParameters);
    }

    protected void callPlanProcedure(Plan plan, DbActionEnum dbAction) {
        List<SqlParameter> sqlParameters = Arrays.asList(
            new SqlParameter(Types.VARCHAR)
            , new SqlParameter(Types.INTEGER)
            , new SqlParameter(Types.INTEGER)
            , new SqlParameter(Types.VARCHAR)
            , new SqlParameter(Types.INTEGER));

        this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement callableStatement = con.prepareCall("call sp_manage_company_plan(?, ?, ?, ?, ?)");
                callableStatement.setString(1, dbAction.getAction());

                if (null != plan.getId()) {
                    callableStatement.setLong(2, plan.getId());
                } else {
                    callableStatement.setNull(2, Types.NULL);
                }

                callableStatement.setLong(3, plan.getCompany().getId());
                callableStatement.setString(4, plan.getName());
                callableStatement.setDouble(5, plan.getPrice());

                return callableStatement;
            }
        }, sqlParameters);
    }

    protected void callPhoneServiceProcedure(PhoneServiceDTO phoneService, String procedureName) {
        List<SqlParameter> sqlParameters = Arrays.asList(
            new SqlParameter(Types.INTEGER)
            , new SqlParameter(Types.INTEGER)
            , new SqlParameter(Types.INTEGER));

        this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement callableStatement = con.prepareCall(procedureName);
                callableStatement.setLong(1, phoneService.getClient().getId());
                callableStatement.setLong(2, phoneService.getPlan().getId());
                callableStatement.setInt(3, phoneService.getPhoneNumber());

                return callableStatement;
            }
        }, sqlParameters);
    }
}
