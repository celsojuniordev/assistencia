package com.java.assistencia.controller.command.subscription;

import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.enums.user.Role;
import com.java.assistencia.utils.HashUtil;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@Getter @Setter
public class SubscriptionSaveCommand {

    @NotBlank(message = "Nome da empresa é obrigatório.")
    private String nameSubscription;

    @NotBlank(message = "Nome do usuário é obrigatório.")
    private String nameUser;

    @Email
    private String username;

    @Size(min = 7, max = 99, message = "Senha deve possuir mais do que 7 caracteres.")
    private String password;

    @NotNull(message = "Tipo de usuário é obrigatório.")
    private Role role;
    private Integer qtUsers;

    public Subscription transformToSubscription() {

        //Dados do usuário responsável pela subscription
        User user = new User();
        user.setName(this.nameUser);
        user.setPassword(HashUtil.getSecureHash(this.password));
        user.setDateCreated(new Date());
        user.setLastUpdated(new Date());
        user.setRole(this.role);
        user.setUsername(this.username);
        user.setActive(true);

        //Dados da subscription
        Subscription subscription = new Subscription();
        subscription.setName(this.nameSubscription);
        subscription.setQtUsers(1);
        subscription.setActive(true);
        subscription.setLastUpdated(new Date());
        subscription.setDateCreated(new Date());
        subscription.setUsers(new ArrayList<>());
        subscription.getUsers().add(user);
        return subscription;
    }
}
