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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "room_category")
public class RoomCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String description;
    
    private double price;
    
    private String area;
    
    @Column(name = "number_bed")
    private int numberBed;
    
    
    private int capacity;
    
    @Transient
    private List<MultipartFile> imageFile;
    
    @OneToMany(mappedBy = "roomCategory")
    private List<RoomEntity>room;
    
    @OneToMany(mappedBy = "roomCategory")
    private List<ImageEntity> image;
}
