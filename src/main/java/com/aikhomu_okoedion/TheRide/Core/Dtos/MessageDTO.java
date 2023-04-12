package com.aikhomu_okoedion.TheRide.Core.Dtos;

import lombok.Data;

@Data
public class MessageDTO {
    private int locationX;
    private int locationY;
    private Integer driverId;
    private Integer customerId;
}
