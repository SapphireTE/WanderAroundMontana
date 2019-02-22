package com.te.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="users")
public class User implements UserDetails, Comparable<User> {

    @Id //this annotation tells id is a primary key
    @GeneratedValue(strategy = SEQUENCE, generator ="users_id_seq") //indicate which table to generate value
    @SequenceGenerator(name ="users_id_seq", sequenceName ="users_id_seq",allocationSize = 1) //indicate sequence size
    private Long id;

    @Column(name="username",unique = true)
    @JsonView({JsView.User.class}) //display under what situation or role
    private String username;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", unique = true)
//    @JsonIgnore
    private String email;

    @Column(name="password")
    private String password;



//    @Column(name="confirm_Password")
//    @JsonIgnore
//    private String confirmPassword;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

//    @Column(name="is_delete")
//    private Boolean isDelete;

    //constructor
    //public User(){}
    @Transient //will not save in database
    private List<Authority> authorities;

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public Long getId(){
        return this.id;
    } //no needs to set Id, postgres would give an Id automatically
//    public void setId(Long id){
//        this.id=id;
//    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username=username;
    }


//    @Column
//    private String timezone;
//
//    @JsonIgnore
//    private Boolean enabled=true;
//
//    @JsonIgnore
//    private Boolean locked=false;
//
//    @JsonIgnore
//    private Boolean expired=false;

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    @Override
    @JsonIgnore
    public boolean isDelete(){return true;}

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    public void setAuthorities(List<Authority> authorities) {this.authorities=authorities;}

    @JsonIgnore
    public String getPassword(){
        return this.password;
    }
    @JsonProperty
    public void setPassword(String password){
        this.password=password;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
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

    public int compareTo(User user){
        return this.getUsername().compareTo(user.username);
    }

//    public List<User> compareTo(User username){
//
//
//    }


}

