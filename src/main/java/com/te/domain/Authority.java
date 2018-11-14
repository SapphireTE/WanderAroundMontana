package com.te.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator ="authorities_id_seq")
    @SequenceGenerator(name ="authorities_id_seq", sequenceName ="authorities_id_seq",allocationSize = 1)
    private Long Id;

    private String authority;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @Override
    public String getAuthority() {
        return this.authority;
    }
    public void setAuthority(String authority){
        this.authority=authority;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
