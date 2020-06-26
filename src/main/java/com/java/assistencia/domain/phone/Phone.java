package com.java.assistencia.domain.phone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.enums.phone.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@Entity
@AllArgsConstructor
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @JsonIgnoreProperties("phones")
    private User user;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", nullable = false, updatable = false)
    @JsonIgnoreProperties("phones")
    private Subscription subscription;

    @Getter(onMethod = @__({@JsonIgnore}))
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Getter(onMethod = @__({@JsonIgnore}))
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Getter(onMethod = @__({@JsonIgnore}))
    @Column(name = "date_deleted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;

    public Phone() {
        this.dateCreated = new Date();
    }

    public Phone update(Phone phone) {
        phone.lastUpdated = new Date();
        BeanUtils.copyProperties(phone, this, "id");
        return this;

    }
}
