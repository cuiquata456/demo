/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import com.mycompany.hotelbooking.enums.UserStatus;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String email;
    
    private String password;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"))
    private Set<RoleEntity> userRoles;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;
}
