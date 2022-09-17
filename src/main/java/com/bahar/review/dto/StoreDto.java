package com.bahar.review.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StoreDto {

    private String id;

    @NotNull
    private String name;

    @Size(max = 500)
    private String details;
    private String address;

 //   @Pattern(regexp = PHONE_PATTERN)
    private String phone;
    private String skype;
    private boolean discounts;

   // @Pattern(regexp = MAIL_PATTERN)
    private String mail;
    private String logo;
}
