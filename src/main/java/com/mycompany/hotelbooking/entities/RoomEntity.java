/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

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

@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "room_number")
    private String roomNumber;
    
    private String status;
    
    @OneToMany(mappedBy = "room")
    private List<BookingDetailEntity>bookingDetail;
    
    @ManyToOne
    @JoinColumn(name = "room_category_id")
    private RoomCategoryEntity roomCategory;
    
}
