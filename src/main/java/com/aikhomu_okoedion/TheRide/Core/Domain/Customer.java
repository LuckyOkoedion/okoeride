package com.aikhomu_okoedion.TheRide.Core.Domain;


import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;


@Data
@Table("customer")
public class Customer {
    @PrimaryKey
    private Integer id;

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

    @Autowired
    public Customer() {
        this.id = Instant.now().getNano();
    }

    public Customer(CustomerDTO cust) {
        this.id = Instant.now().getNano();
        this.name = cust.getName();


    }


}
