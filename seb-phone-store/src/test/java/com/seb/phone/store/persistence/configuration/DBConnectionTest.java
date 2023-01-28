package com.seb.phone.store.persistence.configuration;

import org.junit.Assert;
import org.junit.Test;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
public class DBConnectionTest {

    @Test
    public void getConnection() {
        DBConnection.connect();

        Assert.assertNotEquals(null, "Connected to database");
    }
}
