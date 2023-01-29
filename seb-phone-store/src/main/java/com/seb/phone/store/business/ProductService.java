package com.seb.phone.store.business;

import com.seb.phone.store.business.vo.Product;

import javax.ejb.Local;
import java.util.List;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@Local
public interface ProductService {

    List<Product> getInfo();

    Double applyDiscount(List<Product> products);
}
