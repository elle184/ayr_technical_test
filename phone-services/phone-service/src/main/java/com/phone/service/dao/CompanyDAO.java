package com.phone.service.dao;

import com.phone.service.dto.Company;
import com.phone.service.enums.DbActionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@Repository
public class CompanyDAO extends AbstractDAO {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public void create(Company company) {
        this.callCompanyProcedure(company, DbActionEnum.CREATE);
    }

    public void update(Company company) {
        this.callCompanyProcedure(company, DbActionEnum.UPDATE);
    }

    public Company findById(Long id) {
        return this.jdbcTemplate.query(
            "SELECT id, name, address, phone_number, creation_date, modification_date"
            , new ResultSetExtractor<Company>() {
                @Override
                public Company extractData(ResultSet rs) throws SQLException, DataAccessException {
                    Company company = null;

                    while (rs.next()) {
                        company = Company.builder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("name"))
                            .address(rs.getString("address"))
                            .phoneNumber(rs.getInt("phone_number"))
                            .creationDate(rs.getObject("creation_date", LocalDateTime.class))
                            .modificationDate(rs.getObject("modification_date", LocalDateTime.class))
                            .build();
                    }

                    return company;
                }
            }, new Object[]{id});
    }
}
