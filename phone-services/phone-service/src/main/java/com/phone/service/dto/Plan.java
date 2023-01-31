package com.phone.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    private Long id;

    private Company company;

    private String name;

    private Double price;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;
}
