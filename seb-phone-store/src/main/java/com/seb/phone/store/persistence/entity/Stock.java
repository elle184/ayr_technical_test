package com.seb.phone.store.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Stock {

    private Long id;

    private Model model;

    private Double price;

    private Integer inStock;

    private Integer rating;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
