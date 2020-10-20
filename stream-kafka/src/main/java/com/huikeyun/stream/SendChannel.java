package com.huikeyun.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface SendChannel {
    String OUTPUT = "myOutput";

    @Output(OUTPUT)
    MessageChannel sendMessage();


}
