package com.phone.service.dao;

import com.phone.service.dto.Company;
import com.phone.service.dto.Plan;
import com.phone.service.enums.DbActionEnum;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class PlanDAO extends AbstractDAO {

    public void create(Plan plan) {
        this.callPlanProcedure(plan, DbActionEnum.CREATE);
    }

    public void update(Plan plan) {
        this.callPlanProcedure(plan, DbActionEnum.UPDATE);
    }

    public void delete(Long id) {
        this.callPlanProcedure(
            Plan.builder().id(id).build(), DbActionEnum.DELETE);
    }

    public Plan findById(Long id) {
        return this.jdbcTemplate.query(
            "SELECT id, company_id, name, price::decimal, creation_date, modification_date " +
                "FROM plan " +
                "WHERE id = ?"
            , new ResultSetExtractor<Plan>() {
                @Override
                public Plan extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    Plan plan = null;

                    while (resultSet.next()) {
                        plan = Plan.builder()
                            .id(resultSet.getLong("id"))
                            .company(Company.builder().id(resultSet.getLong("company_id")).build())
                            .name(resultSet.getString("name"))
                            .price(resultSet.getDouble("price"))
                            .creationDate(resultSet.getObject("creation_date", LocalDateTime.class))
                            .modificationDate(resultSet.getObject("creation_date", LocalDateTime.class))
                            .build();
                    }

                    return plan;
                }
            }, new Object[]{id});
    }
}
