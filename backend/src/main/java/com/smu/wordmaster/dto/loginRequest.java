package com.smu.wordmaster.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class loginRequest {

    private String loginEmail;
    private String password;

}