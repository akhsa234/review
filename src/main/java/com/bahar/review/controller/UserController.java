package com.bahar.review.controller;


import com.bahar.review.dto.UserDto;
import com.bahar.review.exception.NotFoundException;
import com.bahar.review.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {


    private final UserServiceImpl userService;

    //approved
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> loadAllProducts(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto LoadProduct(@PathVariable Long id) throws NotFoundException {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createProduct(@Valid @RequestBody UserDto user){

        return userService.saveUser(user);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<UserDto> updatedAllInfo(@Valid @RequestBody UserDto userDtoDetails,
                                                     @PathVariable Long id) {
        UserDto user= userService.findUserDtoById(userDtoDetails,id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Long id){
        userService.delete(id);
    }
}
