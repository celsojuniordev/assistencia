package com.java.assistencia.controller.command.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter @Setter
public class UserPasswordCommand {

    @Size(min = 5, max = 20, message = "Senha deve possuir entre 5 a 20 caracteres")
    private String password;
}


