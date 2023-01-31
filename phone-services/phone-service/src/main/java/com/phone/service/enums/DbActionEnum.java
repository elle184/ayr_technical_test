package com.phone.service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DbActionEnum {
    CREATE("CREATE")
    , UPDATE("UPDATE");

    @Getter
    private final String action;
}
