package com.bahar.review.service;

import com.bahar.review.convertor.user.DTOConvertToUser;
import com.bahar.review.convertor.user.UserConvertToDTO;
import com.bahar.review.dto.UserDto;
import com.bahar.review.exception.NotFoundException;
import com.bahar.review.model.User;
import com.bahar.review.repo.UserDbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    private final UserDbRepository userDbRepository;
    private final DTOConvertToUser dtoConvertToUser;
    private final UserConvertToDTO userConvertToDTO;


    public List<UserDto> getAllUsers() {
        return userDbRepository.findAll()
                .stream()
                .map(userConvertToDTO::convert)
                .collect(Collectors.toList());

    }

    public UserDto findById(Long id) throws NotFoundException {
        User user = userDbRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No user was found with id=" + id));
        return userConvertToDTO.convert(user);


    }

    public UserDto saveUser(UserDto userDto) {

        User user = dtoConvertToUser.convert(userDto);
        User userCreated = userDbRepository.save(user);

        return userConvertToDTO.convert(userCreated);

    }


    public UserDto findUserDtoById(UserDto userDtoDetails, Long id) {
        User user = userDbRepository.findById(id).get();

        if (user != null) {
            User updateSetInfo = dtoConvertToUser.convert(userDtoDetails);
            user.setFirstName(updateSetInfo.getFirstName());
            user.setLastName(updateSetInfo.getLastName());
            user.setEmail(updateSetInfo.getEmail());
            user.setPhone(updateSetInfo.getPhone());

            User updatedPaper = userDbRepository.save(user); // save in db

            return userConvertToDTO.convert(updatedPaper); // send productDto to view


        }
        return null;//todo throw exception
    }


    public void updateUserFirstName( String firstName, Long id) {

        User updateUserName = userDbRepository.findUserById(id);
        if (updateUserName != null) {
            updateUserName.setFirstName(firstName);
            userDbRepository.save(updateUserName);
        } else {
            new NotFoundException("There is no user with this " + id + " ");
        }
    }


    public void updateUserLastName( String lastName, Long id) {

        User updateUserSurname = userDbRepository.findUserById(id);
        if (updateUserSurname != null) {
            updateUserSurname.setFirstName(lastName);
            userDbRepository.save(updateUserSurname);
        } else {
            new NotFoundException("There is no user with this " + id + " ");
        }
    }

    public void updateUserEmail( String email, Long id) {

        User updateUserEmail = userDbRepository.findUserById(id);
        if (updateUserEmail != null) {
            updateUserEmail.setFirstName(email);
            userDbRepository.save(updateUserEmail);
        } else {
            new NotFoundException("There is no user with this " + id + " ");
        }
    }

    public void delete(Long id) {
        userDbRepository.deleteById(id);

    }
}
