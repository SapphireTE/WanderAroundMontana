package com.te.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name="users")
public class User {

    @Id
    public Long id;

    @Column(name="username",unique = true)
    public String username;

    @Column(name="first_name")
    public String firstName;

    @Column(name="last_name")
    public String lastName;

    @Column(name="email", unique = true)
    public String email;

    @Column(name="password")
    public String password;

    @Column(name="date_of_birth")
    public Instant dateOfBirth;

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public Instant getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(Instant dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
}
