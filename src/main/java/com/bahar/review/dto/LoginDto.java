package com.bahar.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * transferring Data object for login
 */

@Getter
@AllArgsConstructor
public class LoginDto implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
