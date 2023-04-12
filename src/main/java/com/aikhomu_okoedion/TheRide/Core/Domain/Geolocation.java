package com.aikhomu_okoedion.TheRide.Core.Domain;



import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Data
@Table("geolocation")
public class Geolocation {

    @PrimaryKey
    private Integer id;
    @Column
    private Integer x;
    @Column
    private Integer y;
    @Column
    private Integer driverId;
    @Column
    private Integer customerId;

    @Autowired
    public Geolocation() {

        this.id = Instant.now().getNano();

    }

    public Geolocation(GeolocationDTO dto) {
        this.id = Instant.now().getNano();
        this.x = dto.getX();
        this.y = dto.getY();
        this.customerId = dto.getCustomerId();
        this.driverId = dto.getCustomerId();

    }

    public Geolocation(MessageDTO theMessage) {
        this.id = Instant.now().getNano();
        this.x = theMessage.getLocationX();
        this.y = theMessage.getLocationY();
        this.driverId = theMessage.getDriverId();
        this.customerId = theMessage.getCustomerId();
    }

}
