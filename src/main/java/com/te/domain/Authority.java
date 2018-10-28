//package com.te.domain;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.*;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//@Entity
//@Table(name="authorities")
//public class Authority implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue(strategy = SEQUENCE, generator ="authorities_id_seq")
//    @SequenceGenerator(name ="authorities_id_seq", sequenceName ="authorities_id_seq",allocationSize = 1)
//    private long Id;
//
//    private String authority;
//
//    @JoinColumn(name="user_Id")
//    private User user;
//
//
//}
