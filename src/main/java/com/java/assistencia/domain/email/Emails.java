package com.java.assistencia.domain.email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.assistencia.enums.email.EmailType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor
@Table(name = "email")
public class Emails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "email_type")
    @Enumerated(EnumType.STRING)
    private EmailType emailType;

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

}
