package com.seb.phone.store.business.impl;

import com.seb.phone.store.business.ModelService;
import com.seb.phone.store.persistence.dao.ModelDAO;
import com.seb.phone.store.persistence.entity.Model;

import java.util.List;
import javax.ejb.Stateless;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@Stateless
public class ModelServiceImpl implements ModelService {

    private ModelDAO modelDao;

    @Override
    public List<Model> getAll() {
        this.modelDao = new ModelDAO();
        List<Model> models = this.modelDao.findAll();

        return models;
    }
}
