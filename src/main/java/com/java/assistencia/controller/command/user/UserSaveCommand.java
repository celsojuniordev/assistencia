package com.java.assistencia.controller.command.user;

import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.enums.user.Role;
import com.java.assistencia.repository.subscription.SubscriptionRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
public class UserSaveCommand {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    private int qtUsers;

    private String username;

    @Size(min = 5, max = 20, message = "Senha deve possuir entre 5 a 20 caracteres")
    private String password;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private Role role;


    private boolean active = true;
    private Date dateCreated = new Date();
    private Date lastUpdated = new Date();

    public User transformToUser() {
        Subscription subscription = new Subscription();
        subscription.setActive(true);
        subscription.setQtUsers(this.qtUsers);
        subscription.setDateCreated(this.dateCreated);
        subscription.setLastUpdated(this.lastUpdated);
        subscriptionRepository.save(subscription);

        return new User(null, this.name, this.username, this.password, this.role, this.active, subscription, this.dateCreated, this.lastUpdated);
    }

}
