package com.aikhomu_okoedion.TheRide.Core.Dtos;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

@Data
public class MessageDecoder implements Decoder.Text<MessageDTO> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MessageDTO decode(String s) throws DecodeException {
        try {
            return objectMapper.readValue(s, MessageDTO.class);
        } catch (IOException e) {
            throw new DecodeException(s, "Unable to decode text to MessageDTO", e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
