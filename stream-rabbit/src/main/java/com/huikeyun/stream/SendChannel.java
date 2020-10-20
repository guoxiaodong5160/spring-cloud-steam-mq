package com.huikeyun.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义发送通道
 */
public interface SendChannel {
    String OUTPUT = "myOutput";
    String OUTPUT_STEP_2 = "output-step-2";

    @Output(OUTPUT)
    MessageChannel message();

    @Output(OUTPUT_STEP_2)
    MessageChannel message2();

}
