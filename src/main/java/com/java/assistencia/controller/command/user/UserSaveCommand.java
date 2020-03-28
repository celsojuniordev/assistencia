package com.java.assistencia.controller.command.user;

import com.java.assistencia.domain.user.User;
import com.java.assistencia.enums.user.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
public class UserSaveCommand {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "Username é obrigatório")
    private String username;

    @Size(min = 5, max = 20, message = "Senha deve possuir entre 5 a 20 caracteres")
    private String password;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private Role role;

    private boolean active = true;
    private Date dateCreated = new Date();
    private Date lastUpdated = new Date();

    public User transformToUser() {
        return new User(null, this.name, this.username, this.password, this.role, this.active, this.dateCreated, this.lastUpdated);
    }

}
