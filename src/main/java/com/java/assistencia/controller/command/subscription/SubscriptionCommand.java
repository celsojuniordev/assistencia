package com.java.assistencia.controller.command.subscription;

import com.java.assistencia.domain.phone.Phone;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.utils.HashUtil;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

@Getter @Setter
public class SubscriptionCommand {

    @NotBlank(message = "Nome da assinatura é obrigatório.")
    private String name;

    @NotNull(message = "Usuário é obrigatório.")
    private List<User> users = new ArrayList<>();

    private Boolean active;

    private Integer qtUsers;

    public Subscription bindData(Subscription subscription) {

        users.forEach( user -> {
            if (isNull(user.getId())) {
                user.setPassword(HashUtil.getSecureHash(user.getPassword()));
                user.setDateCreated(new Date());
                user.setLastUpdated(new Date());
            }
        });

        subscription.setUsers(users);
        subscription.setName(this.name);
        subscription.setActive(this.active);
        subscription.setLastUpdated(new Date());
        subscription.setDateCreated(new Date());
        subscription.setQtUsers(1);
        return subscription;
    }
}
