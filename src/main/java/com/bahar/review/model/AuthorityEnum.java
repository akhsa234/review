package com.bahar.review.model;

import lombok.Getter;

public enum AuthorityEnum {//version1

    ROLE_ADMIN("Administrator"),
    ROLE_STOCK_MANAGER("Stock manager"),
    ROLE_STORE_MANAGER("Store manager"),
    ROLE_USER("User");

    @Getter
    private String description;

    AuthorityEnum(final String description) {
        this.description = description;
    }
}
