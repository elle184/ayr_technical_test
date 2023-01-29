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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private Long id;

    private Brand brand;

    private String name;

    private String imageSource;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
