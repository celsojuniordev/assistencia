package com.java.assistencia.domain.phone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.assistencia.domain.user.User;
import com.java.assistencia.enums.phone.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@Entity
@NoArgsConstructor
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
        this.lastUpdated = new Date();
    }
}
