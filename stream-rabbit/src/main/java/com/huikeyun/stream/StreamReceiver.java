package com.huikeyun.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class StreamReceiver {

    @StreamListener(value = ReceiveChannel.MY_INPUT_1, condition = "headers['version']=='1.0'")
    public void receiveOne(@Payload String message) {
        String msg = "StreamReceiver v1: " + message;
        log.info(msg);
    }

    @StreamListener(value = ReceiveChannel.MY_INPUT_1, condition = "headers['version']=='2.0'")
    public void receiveTwo(String message) {
        log.info("StreamReceiver v2: {}", message);
    }

    @StreamListener(ReceiveChannel.MY_INPUT_2)
    public void receiveFailed(String message) {
        throw new RuntimeException("error");
    }


    @StreamListener(value = ReceiveChannel.INPUT_STEP_1)
    @SendTo(SendChannel.OUTPUT_STEP_2)
    public String receiveStep_1(String message) {
        String msg = "receiveAndSend-step1:" + message;
        log.info(msg);
        return msg;
    }

    @StreamListener(ReceiveChannel.INPUT_STEP_2)
    public void receiveStep_2(String message) {
        log.info("StreamReceiver step2: {}", message);
    }
}