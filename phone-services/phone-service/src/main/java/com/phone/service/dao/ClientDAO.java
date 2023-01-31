package com.phone.service.dao;

import com.phone.service.dto.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Service definition to manage the information about.
 */
@Repository
public class ClientDAO extends AbstractDAO {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public void create(Client client) {
        this.callClientProcedure(client, "call sp_create_client(?,?)");
    }

    public void update(Client client) {
        this.callClientProcedure(client, "call sp_update_client(?, ?)");
    }

    public Client findBySecurityCode(String securityCode) {
        return this.jdbcTemplate.query(
            "SELECT id, security_code, full_name, creation_date, modification_date FROM client WHERE security_code = ?"
            , new ResultSetExtractor<Client>(){
                @Override
                public Client extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    Client client = null;

                    while (resultSet.next()) {
                        client = Client.builder()
                            .id(resultSet.getLong("id"))
                            .securityCode(resultSet.getString("security_code"))
                            .fullName(resultSet.getString("full_name"))
                            .creationDate(resultSet.getObject("creation_date", LocalDateTime.class))
                            .modificationDate(resultSet.getObject("modification_date", LocalDateTime.class))
                            .build();
                    }

                    return client;
                }
            }, new Object[]{securityCode});
    }
}
