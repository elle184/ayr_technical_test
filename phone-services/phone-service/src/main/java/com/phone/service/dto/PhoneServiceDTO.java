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
public class PhoneServiceDTO {

    private Long id;

    private Client client;

    private Plan plan;

    private Integer phoneNumber;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;
}