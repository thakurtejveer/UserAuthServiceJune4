package com.scaler.userauthservicejune4.services;

import com.scaler.userauthservicejune4.exceptions.PasswordMismatchException;
import com.scaler.userauthservicejune4.exceptions.UserAlreadyExistException;
import com.scaler.userauthservicejune4.exceptions.UserNotFoundException;
import com.scaler.userauthservicejune4.models.User;
import com.scaler.userauthservicejune4.repo.UserRepo;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService{

    @Autowired
    UserRepo userRepo;

    public User signUp(String name, String email, String password, String phoneNumber) {
        Optional<User> user = userRepo.findByEmailEquals(email);
        if(user.isPresent()) {
            throw new UserAlreadyExistException("User already exists");
        }
        User userObj = new User();
        userObj.setName(name);
        userObj.setEmail(email);
        userObj.setPassword(password); // use Bscrypt here
        userObj.setPhoneNo(phoneNumber);
        return userRepo.save(userObj);
    }

    public Pair<User,String> login(String email, String password) {
        Optional<User> optionalUser = userRepo.findByEmailEquals(email);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User is not present, Please register first");
        }
        String storedPassword = optionalUser.get().getPassword();
        if(!password.equals(storedPassword)) {
            throw new PasswordMismatchException("Password does not match");
        }
        // Todo : generate JWT
        return new Pair<>(optionalUser.get(),"");
    }
}
