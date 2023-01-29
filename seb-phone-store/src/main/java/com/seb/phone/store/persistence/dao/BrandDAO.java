package com.seb.phone.store.persistence.dao;

import com.seb.phone.store.persistence.configuration.DBConnection;
import com.seb.phone.store.persistence.entity.Brand;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class BrandDAO {

    protected static Logger logger = Logger.getLogger(BrandDAO.class.getName());

    public Brand findById(Long id) {
        String sql = "SELECT name FROM brand WHERE id = ?";
        DBConnection.connect();
        Brand brand = null;

        try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                brand = Brand.builder().name(resultSet.getString("name")).build();
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE
                , String.format("An error has occurred when trying to return the brand information with the id %d", id)
                , e);
        } finally {
            DBConnection.close();
        }

        return brand;
    }
}
