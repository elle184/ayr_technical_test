package com.seb.phone.store.persistence.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
public class ModelDAOTest {

    @Test
    public void findAll() {
        ModelDAO modelDao = new ModelDAO();

        Assert.assertNotEquals(0, modelDao.findAll().size());
    }
}
