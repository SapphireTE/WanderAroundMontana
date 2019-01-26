package com.te.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator ="authorities_id_seq")
    @SequenceGenerator(name ="authorities_id_seq", sequenceName ="authorities_id_seq", allocationSize = 1)
    private Long Id;

    @NotNull //can never be null
    private String authority;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public Authority(){}

    public Authority(User user, String authority){
        this.user=user;
        this.authority=authority;
    }

    public Long getId() {
        return Id;
    }

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
