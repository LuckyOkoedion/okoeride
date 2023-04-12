package com.aikhomu_okoedion.TheRide.Core.Domain;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


import java.time.Instant;

@Data
@Table("driver")
public class Driver {
    @PrimaryKey
    private Integer id;
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

    @Autowired
    public Driver() {

        this.id = Instant.now().getNano();

    }

    public Driver(Ride theRide) {
        this.id = Instant.now().getNano();
        this.rideId = theRide.getId();
        this.customerId = theRide.getCustomerId();

    }

    public Driver(Geolocation loc) {
        this.id = Instant.now().getNano();
        this.locationX = loc.getX();
        this.locationY = loc.getY();
    }




}
