package com.bahar.review.convertor.user;


import com.bahar.review.dto.UserDto;
import com.bahar.review.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DTOConvertToUser implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());

        // image.setProduct()


        return user;
    }
}
