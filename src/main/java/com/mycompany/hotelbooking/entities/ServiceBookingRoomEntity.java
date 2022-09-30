/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "service_booking_room")
public class ServiceBookingRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private double price;
    
    @Column(name = "use_date")
    @Temporal(TemporalType.DATE)
    private Date useDate;
    
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "booking_detail_id")
    private BookingDetailEntity bookingDetail;
    
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
}
