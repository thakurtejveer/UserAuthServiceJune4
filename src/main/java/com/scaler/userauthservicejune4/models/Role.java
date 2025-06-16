package com.scaler.userauthservicejune4.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role extends BaseModel{
    private String name;
    // if needed we can added permissions also

}
