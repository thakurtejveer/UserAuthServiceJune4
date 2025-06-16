package com.scaler.userauthservicejune4.controllers;

import com.scaler.userauthservicejune4.dtos.LoginRequestDto;
import com.scaler.userauthservicejune4.dtos.SignupRequestDto;
import com.scaler.userauthservicejune4.dtos.UserDto;
import com.scaler.userauthservicejune4.models.User;
import com.scaler.userauthservicejune4.repo.UserRepo;
import com.scaler.userauthservicejune4.services.IAuthService;
import org.antlr.v4.runtime.misc.Pair;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IAuthService authService;
    @Autowired
    private UserRepo userRepo;

    // sign up
    // login
    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignupRequestDto signupRequestDto) {
        User user = authService.signUp(signupRequestDto.getName(), signupRequestDto.getEmail(),signupRequestDto.getPassword(), signupRequestDto.getPhoneNo());
        return from(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        Pair<User, String> loginPair = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        UserDto userDto = from(loginPair.a);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        if(user == null) {
            return userDto;
        }
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
