package com.java.assistencia.controller.command.subscription;

import com.java.assistencia.domain.subscription.Subscription;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter
public class SubscriptionUpdateCommand {


    @NotBlank(message = "Nome da empresa é obrigatório.")
    private String name;

    @NotNull(message = "Ativo é obrigatório")
    private boolean active;

    public Subscription transformToSubscription() {

        Subscription subscription = new Subscription();
        subscription.setName(this.name);
        subscription.setActive(this.active);
        subscription.setLastUpdated(new Date());
        return subscription;
    }
}
