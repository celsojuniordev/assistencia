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
import java.util.List;

@Getter
@Setter
public class UserCommand {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email
    private String username;

    @Size(min = 5, max = 20, message = "Senha deve possuir entre 5 a 20 caracteres")
    private String password;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private Role role;

    private List<Phone> phones;

    @NotNull(message = "Empresa é obrigatório.")
    private Subscription subscription;

    private boolean active;
    private Date lastUpdated = new Date();

    public User bindData(User user) {

        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRole(this.role);
        user.setActive(this.active);
        user.setPhones(phones);
        user.setSubscription(this.subscription);

        user.setLastUpdated(new Date());

        if (user.getDateCreated() == null) {
            user.setDateCreated(new Date());
        }

        return user;
    }
}
