package com.te.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Column(name="is_delete")
    private Boolean isDelete=Boolean.FALSE;

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

    @JsonIgnore
    public boolean isDelete(){return isDelete;}

//    @NotNull
//    @Column(name = "is_Deleted", columnDefinition = "boolean default true", nullable = false)
//    private boolean isDeleted = true;

}
