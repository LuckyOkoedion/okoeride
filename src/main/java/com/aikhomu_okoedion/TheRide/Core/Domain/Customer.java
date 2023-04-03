package com.aikhomu_okoedion.TheRide.Core.Domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Integer locationX;

    @Column
    private Integer locationY;

    @Column
    private Integer rideId;

    @Column
    private Integer driverId;


}
