package com.aikhomu_okoedion.TheRide.Core.Dtos;

import lombok.Data;

@Data
public class RideDTO {
    private int customerId;
    private int driverId;
    private  String destination;
}
