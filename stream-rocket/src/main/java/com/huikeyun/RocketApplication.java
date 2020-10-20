package com.huikeyun;

import com.huikeyun.stream.ReceiveChannel;
import com.huikeyun.stream.SendChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding(value = {SendChannel.class, ReceiveChannel.class})
@SpringBootApplication
public class RocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketApplication.class, args);
    }
}

