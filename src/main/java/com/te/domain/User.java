package com.te.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")


public class User {

    @Id
    public Long id;

    @Column(name="username",unique = true)
    public String username;

    @Column(name="email", unique = true)
    public String email;

    @Column(name="password")
    public int password;

    @Column(name="stats")
    public int stats;

    @Column(name="date_of_birth")
    public String dob;



}
