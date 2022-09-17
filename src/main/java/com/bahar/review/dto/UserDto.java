package com.bahar.review.dto;


import com.bahar.review.model.Authority;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
public class UserDto {
    private String id;
    @NotNull
    private String username;
    // @Pattern(regexp = PASSWORD_PATTERN)
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    // @Pattern(regexp = PHONE_PATTERN)
    private String phone;
    private String avatar;
    private Authority authority;
    private LocalDateTime createDate;
}
