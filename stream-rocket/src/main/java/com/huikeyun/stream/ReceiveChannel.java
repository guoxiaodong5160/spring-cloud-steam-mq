package com.huikeyun.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface ReceiveChannel {
    String INPUT = "myInput";

    @Input(INPUT)
    SubscribableChannel sub1();
}
