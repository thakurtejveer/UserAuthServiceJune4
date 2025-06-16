package com.scaler.userauthservicejune4.dtos;

import com.scaler.userauthservicejune4.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String email;
    List<Role> roles;
}
