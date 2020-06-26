package com.java.assistencia.controller.command.user;

import com.java.assistencia.domain.address.Address;
import com.java.assistencia.domain.phone.Phone;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.enums.user.Role;
import com.java.assistencia.repository.phone.PhoneRepository;
import com.java.assistencia.utils.HashUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Getter
@Setter
public class UserCommand {

    @Autowired
    private PhoneRepository phoneRepository;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email
    private String username;

    @Size(min = 5, max = 20, message = "Senha deve possuir entre 5 a 20 caracteres")
    private String password;

    @NotNull(message = "Tipo de usuário é obrigatório")
    private Role role;

    private List<Phone> phones = new ArrayList<>();

    private List<Address> addresses = new ArrayList<>();

    private Subscription subscription;

    private boolean active;

    public User bindData(User user) {

        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(user.getPassword() == null ? HashUtil.getSecureHash(this.password) : user.getPassword());
        user.setRole(this.role);
        user.setActive(this.active);

        setSubscription(this.phones, user.getSubscription());
        setPhoneDeleted(this.phones, user.getPhones());
        setAddressDeleted(this.addresses, user.getAddresses());

        updatePhone(this.phones);

        user.setPhones(updatePhone(this.phones));
        user.setAddresses(this.addresses);
        user.setLastUpdated(new Date());

        return user;
    }

    private List<Phone> updatePhone(List<Phone> phones) {
        List<Phone> updatedPhones = new ArrayList<>();
        phones.forEach(getPhone -> {
            if (!isNull(getPhone.getId())) {
                Phone phone = new Phone();
                phone.update(getPhone);
                updatedPhones.add(phone);
            } else {
                updatedPhones.add(getPhone);
            }
        });

        return updatedPhones;
    }

    private void setPhoneDeleted(List<Phone> phones, List<Phone> userPhones) {
        userPhones.forEach(phone -> {
            if (!phones.contains(phone)) {
                phone.setDateDeleted(new Date());
            }
        });
    }

    private void setAddressDeleted(List<Address> addresses, List<Address> userAddresses) {
        userAddresses.forEach(address -> {
            if (!addresses.contains(address)) {
                address.setDateDeleted(new Date());
            }
        });
    }

    private void setSubscription(List<Phone> phones, Subscription subscription) {
        phones.forEach( phone -> {
            if (isNull(phone.getId())) {
                phone.setSubscription(subscription);
            }
        });
    }
}
