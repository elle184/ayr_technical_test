package com.seb.phone.store.persistence.dao;

import com.seb.phone.store.persistence.configuration.DBConnection;
import com.seb.phone.store.persistence.entity.Model;
import com.seb.phone.store.persistence.entity.Stock;
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
public class StockDAO {

    protected static Logger logger = Logger.getLogger(StockDAO.class.getName());

    public Stock findByModel(Model model) {
        String sql = "SELECT id, price::decimal, in_stock, rating FROM stock WHERE model_id = ?";
        Stock stock = null;
        DBConnection.connect();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, model.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                stock = Stock.builder()
                    .id(resultSet.getLong("id"))
                    .price(resultSet.getDouble("price"))
                    .inStock(resultSet.getInt("in_stock"))
                    .rating(resultSet.getInt("rating"))
                    .build();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE
                , String.format("An error has occurred when trying to return the stock information for model {}", model.getId())
                , e);
        } finally {
            DBConnection.close();
        }

        return stock;
    }
}
