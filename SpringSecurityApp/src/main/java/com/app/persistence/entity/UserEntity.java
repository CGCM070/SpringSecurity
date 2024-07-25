package com.app.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (unique = true)
    private String ussername;
    private String password;


    @Column (name = "is_Enable")
    private boolean isEnable;

    @Column (name = "account_No_Expired")
    private boolean accountNoExpired;

    @Column (name = "account_No_Locked")
    private boolean accountNoLocked;

    @Column (name = "credential_No_Expired")
    private boolean credentialNoExpired;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (name =" user_roles" , joinColumns = @JoinColumn (name = "user_id" ), inverseJoinColumns =  @JoinColumn (name = "role_id") )
    private Set<RoleEntity>roles = new HashSet<>();


}
