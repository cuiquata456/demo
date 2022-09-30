/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "check_in")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkIn;
    
    @Column(name = "check_out")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOut;
    
    @Column(name = "booking_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingDate;
    
    private double price;
    
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "full_name")
    private String fullName;
    
    private String address;
    
    private String note;
    
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private PromotionEntity promotion;
    
    @OneToMany(mappedBy = "booking")
    private List<BookingDetailEntity>bookingDetail;
}
