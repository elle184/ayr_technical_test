package com.seb.phone.store.managed.bean;

import com.seb.phone.store.business.ModelService;
import com.seb.phone.store.persistence.entity.Model;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@ManagedBean
@ViewScoped
public class ProductManagedBean {

    @EJB
    private ModelService modelService;

    @Getter
    private List<Model> models;

    @PostConstruct
    public void init() {
        this.models = this.modelService.getAll();
    }
}
