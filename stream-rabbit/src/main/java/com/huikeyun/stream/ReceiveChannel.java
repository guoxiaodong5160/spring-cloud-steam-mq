package com.huikeyun.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义接收通道
 */
public interface ReceiveChannel {
    String MY_INPUT_1 = "myInput-1";
    String MY_INPUT_2 = "myInput-2";

    String INPUT_STEP_1 = "input-step-1";
    String INPUT_STEP_2 = "input-step-2";

    @Input(MY_INPUT_1)
    SubscribableChannel subOne();

    @Input(MY_INPUT_2)
    SubscribableChannel subTwo();

    @Input(INPUT_STEP_1)
    SubscribableChannel subThree();

    @Input(INPUT_STEP_2)
    SubscribableChannel subFour();
}
