/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import com.mycompany.hotelbooking.enums.Gender;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    private String address;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @OneToMany(mappedBy = "user")
    private List<AccountEntity>accounts;
}
