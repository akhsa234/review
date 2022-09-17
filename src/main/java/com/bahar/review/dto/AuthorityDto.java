package com.bahar.review.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorityDto {

    @NotNull
    private String id;

    @NotNull
    private String name;
}
