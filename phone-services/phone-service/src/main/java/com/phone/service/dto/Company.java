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
public class Company {

    private Long id;

    private String name;

    private String address;

    private Integer phoneNumber;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;
}
