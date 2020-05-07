package com.java.assistencia.domain.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.assistencia.domain.subscription.Subscription;
import com.java.assistencia.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter @Setter
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "uf")
    private String uf;

    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @JsonIgnoreProperties("adresses")
    private User user;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", nullable = false, updatable = false)
    @JsonIgnoreProperties("addresses")
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

    public Address() {
        this.dateCreated = new Date();
        this.lastUpdated = new Date();
    }
}
