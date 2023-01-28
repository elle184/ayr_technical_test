package com.seb.phone.store.persistence.dao;

import com.seb.phone.store.persistence.configuration.DBConnection;
import com.seb.phone.store.persistence.entity.Brand;
import com.seb.phone.store.persistence.entity.Model;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@NoArgsConstructor
public class ModelDAO {

    protected static Logger logger = Logger.getLogger(ModelDAO.class.getName());

    public List<Model> findAll() {
        String sql = "SELECT id, brand_id, name FROM model";
        List<Model> models = new ArrayList<>();
        DBConnection.connect();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                models.add(Model.builder()
                    .id(resultSet.getLong("id"))
                    .brand(Brand.builder().id(resultSet.getLong("brand_id")).build())
                    .build());
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE
                , "An error has ocurred when trying to return the models information."
                , e);
        }

        return models;
    }
}
