//package com.aikhomu_okoedion.TheRide;
//
//
//import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
//import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
//import com.aikhomu_okoedion.TheRide.Core.Service.Impl.WebsocketServiceImpl;
//import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.GeolocationDBTestAdapter;
//import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.junit.jupiter.api.Test;
//
//import org.mockito.Mockito;
//
//import static org.mockito.Mockito.times;
//
//
//public class TestWebsocketAdapterEndpoint {
//
//
//    @Test
//    void onMessage_shouldConvertToJSONAndCallWebsocketServicePublish() throws JsonProcessingException {
//
//        // given
//
//        KafkaTestAdapter kafkaTest = Mockito.spy(new KafkaTestAdapter());
//        GeolocationDBTestAdapter geo = new GeolocationDBTestAdapter();
//        WebsocketServiceImpl websocketService = new WebsocketServiceImpl(geo, kafkaTest);
//
//        MessageDTO theMessage = new MessageDTO();
//        theMessage.setCustomerId(1);
//        theMessage.setDriverId(2);
//        theMessage.setLocationX(20);
//        theMessage.setLocationY(32);
//
//       Geolocation res = websocketService.forwardLocationToKafka(theMessage);
//
//        Mockito.verify(kafkaTest, times(1)).sendLocationToPending(res);
//
//
//
//    }
//
//
//
//
//
//
//}
