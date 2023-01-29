package com.seb.phone.store.managed.bean;

import com.seb.phone.store.business.ModelService;
import com.seb.phone.store.business.ProductService;
import com.seb.phone.store.business.vo.Client;
import com.seb.phone.store.business.vo.Product;
import com.seb.phone.store.persistence.entity.Model;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ProductManagedBean implements Serializable {

    @EJB
    private ProductService productService;

    @Getter
    private List<Product> products;

    @Getter
    @Setter
    private Client client;

    @PostConstruct
    public void init() {
        this.client = new Client();
        this.client.setProductsSelected(0);
        this.client.setFullValue(0D);
        this.client.setProductsToPurchase(new ArrayList<>());

        this.products = this.productService.getInfo();
    }

    public void addToCart(Product product) {
        if (null != product) {
            this.client.setProductsSelected(this.client.getProductsSelected() + 1);
            this.client.getProductsToPurchase().add(product);
            this.client.setFullValue(this.productService.applyDiscount(this.client.getProductsToPurchase()));
        }
    }
}
