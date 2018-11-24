package com.te.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="users")
public class User implements UserDetails {

    @Id //tell id is a primary key
    @GeneratedValue(strategy = SEQUENCE, generator ="users_id_seq")
    @SequenceGenerator(name ="users_id_seq", sequenceName ="users_id_seq",allocationSize = 1)
    private Long id;

    @Column(name="username",unique = true)
    private String username;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="date_of_birth")
    private Instant dateOfBirth;

    //constructor
    //public User(){}

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public Long getId(){
        return this.id;
    }
//    public void setId(Long id){
//        this.id=id;
//    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
