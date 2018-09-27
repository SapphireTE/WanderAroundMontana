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
    public String password;

    @Column(name="date_of_birth")
    public String dob;

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }



}
