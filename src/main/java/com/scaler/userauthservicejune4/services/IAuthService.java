package com.scaler.userauthservicejune4.services;

import com.scaler.userauthservicejune4.models.User;
import org.antlr.v4.runtime.misc.Pair;

public interface IAuthService {

    public User signUp(String name, String email, String password, String phoneNumber);
    public Pair<User,String> login(String email, String password);
}
