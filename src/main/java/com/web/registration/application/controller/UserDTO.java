package com.web.registration.application.controller;

import lombok.Data;

import javax.validation.Valid;

@Data
@Valid
public class UserDTO {

    String username;

    String password;

    String firstName;

    String lastName;

    String middleName;

    String gender;

    String dateOfBirth;
}
