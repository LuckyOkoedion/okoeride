package com.aikhomu_okoedion.TheRide.Core.Domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Table
public class Driver {
    @PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @Column
    private Integer locationX;

    @Column
    private  Integer locationY;

    @Column
    private Integer customerId;
    @Column
    private Integer rideId;

    public Driver() {

    }

    public Driver(Ride theRide) {
        this.rideId = theRide.getId();
        this.customerId = theRide.getCustomerId();

    }

    public Driver(Geolocation loc) {
        this.locationX = loc.getX();
        this.locationY = loc.getY();
    }




}
