package com.seb.phone.store.persistence.configuration;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
public class DBConnection {

    protected static Logger logger = Logger.getLogger(DBConnection.class.getName());

    private static final String URL = "jdbc:postgresql://localhost:5433/db_phone_store";

    private static final String USER = "client";

    private static final String PASSWORD = "20230128";

    @Getter
    private static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            logger.log(Level.SEVERE
                , "An error has occurred when trying to connect to the PostgreSQL database."
                , e);
        }
    }

    public static void close() {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
