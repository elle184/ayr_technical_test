package com.seb.phone.store.business.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class Client {

    private Integer productsSelected;

    private Double fullValue;

    private List<Product> productsToPurchase;
}
