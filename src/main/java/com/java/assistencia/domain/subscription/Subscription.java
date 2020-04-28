package com.java.assistencia.domain.subscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.assistencia.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subscription")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", updatable = false)
    private List<User> users;

    @Column(name = "qt_users", nullable = false, updatable = false)
    private Integer qtUsers;

    @Column(name = "active")
    private boolean active;

    @Getter(onMethod = @__({@JsonIgnore}))
    @Column(name = "date_created", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Getter(onMethod = @__({@JsonIgnore}))
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

}
