package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageAdapter implements IMessagePort {
    @Override
    public void send(Geolocation location) {

    }

    @Override
    public void listen() {

    }
}
