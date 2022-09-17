package com.bahar.review.convertor.user;


import com.bahar.review.dto.UserDto;
import com.bahar.review.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConvertToDTO implements Converter<User, UserDto> {


    @Override
    public UserDto convert(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto= new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());

        return userDto;
    }
}
