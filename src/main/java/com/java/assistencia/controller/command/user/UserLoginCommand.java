package com.java.assistencia.controller.command.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginCommand {

    @Email(message = "Username inválido")
    private String username;

    @NotBlank(message = "Senha inválida")
    private String password;
}
