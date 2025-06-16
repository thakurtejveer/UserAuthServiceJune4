package com.scaler.userauthservicejune4.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles;
}
