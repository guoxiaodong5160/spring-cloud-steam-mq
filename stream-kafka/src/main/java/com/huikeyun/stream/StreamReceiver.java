package com.huikeyun.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class StreamReceiver {

    @StreamListener(value = ReceiveChannel.INPUT)
    public void receiveSucceed_v1(@Payload String message) {
        String msg = "StreamReceiver1 v1: " + message;
        log.error(msg);
    }

}