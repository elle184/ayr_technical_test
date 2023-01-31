package com.phone.service.dao;

import com.phone.service.dto.Client;
import com.phone.service.dto.PhoneServiceDTO;
import com.phone.service.dto.Plan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PhoneServiceDAO extends AbstractDAO {

    public void create(PhoneServiceDTO phoneService) {
        this.callPhoneServiceProcedure(
            phoneService, "call sp_create_phone_service(?, ?, ?)");
    }

    public void update(PhoneServiceDTO phoneService) {
        this.callPhoneServiceProcedure(phoneService, "call sp_create_phone_service(?, ?, ?)");
    }

    public void delete(PhoneServiceDTO phoneService) {
        List<SqlParameter> sqlParameters = Arrays.asList(
            new SqlParameter(Types.INTEGER)
            , new SqlParameter(Types.INTEGER));

        this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement callableStatement = con.prepareCall("call sp_delete_phone_service(?, ?)");
                callableStatement.setLong(1, phoneService.getClient().getId());
                callableStatement.setInt(2, phoneService.getPhoneNumber());

                return callableStatement;
            }
        }, sqlParameters);
    }

    public List<PhoneServiceDTO> findByClient(Long clientId) {
        return this.jdbcTemplate.query(
            "SELECT id, client_id, plan_id, phone_number, creation_date, modification_date "
                + "FROM phone_service "
                + "WHERE client_id = ?"
            , new ResultSetExtractor<List<PhoneServiceDTO>>() {
                @Override
                public List<PhoneServiceDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                    List<PhoneServiceDTO> clientPhoneServices = new ArrayList<>();

                    while (rs.next()) {
                        clientPhoneServices.add(
                            PhoneServiceDTO.builder()
                                .id(rs.getLong("id"))
                                .client(Client.builder().id(rs.getLong("client_id")).build())
                                .plan(Plan.builder().id(rs.getLong("plan_id")).build())
                                .phoneNumber(rs.getInt("phone_number"))
                                .creationDate(rs.getObject("creation_date", LocalDateTime.class))
                                .modificationDate(rs.getObject("modification_date", LocalDateTime.class))
                                .build()
                        );
                    }

                    return clientPhoneServices;
                }
            }
        , new Object[]{clientId});
    }

    public PhoneServiceDTO findByClientAndPhoneNumber(Long clientId, Integer phoneNumber) {
        return this.jdbcTemplate.query(
            "SELECT id, client_id, plan_id, phone_number, creation_date, modification_date "
                + "FROM phone_service "
                + "WHERE client_id = ? "
                + "AND phone_number = ?"
            , new ResultSetExtractor<PhoneServiceDTO>() {
                @Override
                public PhoneServiceDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
                    PhoneServiceDTO phoneService = null;

                    while (rs.next()) {
                        phoneService = PhoneServiceDTO.builder()
                            .id(rs.getLong("id"))
                            .client(Client.builder().id(rs.getLong("client_id")).build())
                            .plan(Plan.builder().id(rs.getLong("plan_id")).build())
                            .phoneNumber(rs.getInt("phone_number"))
                            .creationDate(rs.getObject("creation_date", LocalDateTime.class))
                            .modificationDate(rs.getObject("modification_date", LocalDateTime.class))
                            .build();
                    }

                    return phoneService;
                }
            }
        , new Object[]{clientId, phoneNumber});
    }
}
