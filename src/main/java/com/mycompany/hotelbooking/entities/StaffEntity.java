/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import com.mycompany.hotelbooking.enums.Gender;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class StaffEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @OneToOne(mappedBy = "staff")
    private AccountEntity account;
}
