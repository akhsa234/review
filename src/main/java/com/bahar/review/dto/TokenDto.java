package com.bahar.review.dto;

import com.bahar.review.dto.UserDto;
import lombok.Data;

import java.io.Serializable;

import static org.apache.logging.log4j.util.Strings.EMPTY;

/**
 * Token Data Transfer Object class
 */
@Data
public class TokenDto implements Serializable {

    /**
     * {@link User}'s token
     */
    private String token;

    /**
     * Current logged {@link User}
     */
    private UserDto userDto;

    public TokenDto(final String token, final UserDto userDto) {
        this.token = token;
        this.userDto = userDto;
        this.userDto.setPassword(EMPTY);
    }
}
