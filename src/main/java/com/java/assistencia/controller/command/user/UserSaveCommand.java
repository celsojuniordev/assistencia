package com.java.assistencia.controller.command.user;

import com.java.assistencia.domain.phone.Phone;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.enums.phone.PhoneType;
import com.java.assistencia.enums.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveCommand {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email
    private String username;

    @Size(min = 5, max = 20, message = "Senha deve possuir entre 5 a 20 caracteres")
    private String password;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private Role role;

    @NotBlank(message = "Telefone é obrigatório")
    private String number;

    @NotNull(message = "Tipo do telefone é obrigatório.")
    private PhoneType phoneType;

    @NotNull
    private Subscription subscription;

    private boolean active = true;
    private Date dateCreated = new Date();
    private Date lastUpdated = new Date();

    public User transformToUser() {

        Phone phone = new Phone();
        phone.setNumber(this.number);
        phone.setType(this.phoneType);
        phone.setDateCreated(new Date());
        phone.setLastUpdated(new Date());

        User user = new User();
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRole(this.role);
        user.setActive(true);
        user.setSubscription(this.subscription);
        user.getPhones().add(phone);
        user.setDateCreated(new Date());
        user.setLastUpdated(new Date());

        return user;
    }

}
