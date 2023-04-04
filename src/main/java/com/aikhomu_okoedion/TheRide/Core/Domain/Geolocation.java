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
public class Geolocation {

    @PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int x;
    @Column
    private int y;

}
