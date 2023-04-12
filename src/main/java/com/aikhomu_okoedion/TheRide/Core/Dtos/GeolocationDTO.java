package com.aikhomu_okoedion.TheRide.Core.Dtos;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;

@Data
public class GeolocationDTO {
    private int x;
    private int y;

    private Integer driverId;

    private Integer customerId;

    public GeolocationDTO() {

    }

    public GeolocationDTO(Geolocation geolocation) {
        this.x = geolocation.getX();
        this.y = geolocation.getY();
        this.customerId = geolocation.getCustomerId();
        this.driverId = geolocation.getDriverId();

    }



}
