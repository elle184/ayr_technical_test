package com.seb.phone.store.business.vo;

import com.seb.phone.store.persistence.entity.Model;
import com.seb.phone.store.persistence.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Model model;

    private Stock stock;

    private Integer selected;
}
