package com.seb.phone.store.business.impl;

import com.seb.phone.store.business.ModelService;
import com.seb.phone.store.business.ProductService;
import com.seb.phone.store.business.vo.Product;
import com.seb.phone.store.persistence.dao.ModelDAO;
import com.seb.phone.store.persistence.dao.StockDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@Stateless
public class ProductServiceImpl implements ProductService {

    @EJB
    private ModelService modelService;

    private StockDAO stockDao = new StockDAO();

    @Override
    public List<Product> getInfo() {
        List<Product> products = new ArrayList<>();

        this.modelService.getAll().forEach((model) -> {
            products.add(Product.builder()
                .model(model)
                .stock(this.stockDao.findByModel(model))
                .build());
        });

        return products;
    }

    @Override
    public Double applyDiscount(List<Product> products) {
        Double fullValue = 0D;
        Product minValueProduct = null;

        if (null != products && !products.isEmpty()) {
            for (Product product : products) {
                fullValue += product.getStock().getPrice();
            };

            if (products.size() >= 9) {
                for (Product product : products) {
                    minValueProduct = products.get(0);

                    if (product.getStock().getPrice() < minValueProduct.getStock().getPrice()) {
                        minValueProduct = product;
                    }
                };

                fullValue -= minValueProduct.getStock().getPrice();
            } else if (products.size() >= 6) {
                fullValue -= (fullValue * 0.15);
            } else if (products.size() >= 3) {
                fullValue -= (fullValue * 0.10);
            }
        }

        return fullValue;
    }
}
