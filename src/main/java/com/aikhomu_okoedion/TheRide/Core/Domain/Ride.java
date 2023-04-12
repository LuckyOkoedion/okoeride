package com.aikhomu_okoedion.TheRide.Core.Domain;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Data
@Table("ride")
public class Ride {
    @PrimaryKey
    private Integer id;

    @Column
    private Integer customerId;

    @Column
    private Integer driverId;

    @Column
    private Integer driverXLocation;

    @Column
    private Integer driverYLocation;

    @Column
    private  String destination;

    @Column
    private  boolean driverAccepted;

    @Autowired
    public Ride() {
        this.id = Instant.now().getNano();
    }
}
