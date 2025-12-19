package com.ecom.trends.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminCreateUserDTO {
    public String firstName;
    public String lastName;
    public String username;
    public String email;
    public String dob;
    public String mobile;
    public String password;
    public String role;
}
