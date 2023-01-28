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
public class BrandDAOTest {

    @Test
    public void findById() {
        BrandDAO brandDao = new BrandDAO();

        Assert.assertNotNull(brandDao.findById(1L));
    }
}
