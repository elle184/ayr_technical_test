package com.phone.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    private Long id;

    private String fullName;

    private String securityCode;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;
}
