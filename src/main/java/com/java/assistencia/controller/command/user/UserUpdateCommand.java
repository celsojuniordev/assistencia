package com.java.assistencia.controller.command.user;

import com.java.assistencia.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
public class UserUpdateCommand {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email
    private String username;

    @Size(min = 5, max = 20, message = "Senha deve possuir entre 5 a 20 caracteres")
    private String password;

    @NotNull(message = "Ativo é obrigatório")
    private Boolean active;

    public User transformToUser() {
        User user = new User();
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setActive(this.active);
        user.setLastUpdated(new Date());
        return user;
    }

}
