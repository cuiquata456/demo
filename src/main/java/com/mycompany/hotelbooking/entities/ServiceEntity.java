/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbooking.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   
    private String name;
    
    private double price;
    
    private String location;
    
    @Temporal(TemporalType.TIME)
    private Date openTime;
    
    @Temporal(TemporalType.TIME)
    private Date closeTime;
    
    private String description;
    
    private String status;
    
    @Transient
    private List<MultipartFile> imageFile;
    
    @OneToMany(mappedBy = "service")
    private List<ImageEntity> image;
    
    @OneToMany(mappedBy = "service")
    private List<ServiceBookingRoomEntity>serviceBookingRoom;
}
