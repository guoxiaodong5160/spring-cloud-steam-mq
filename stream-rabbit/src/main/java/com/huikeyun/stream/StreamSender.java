package com.huikeyun.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;


@RestController
public class StreamSender {

    @Autowired
    private SendChannel source;

    @Resource
    private BinderAwareChannelResolver resolver;

    /**
     * 测试发送消息
     * @return
     */
    @GetMapping("/send")
    public String send() {
        source.message().send(MessageBuilder.withPayload("Hello World..." + new Date()).build());
        return "Hello World" ;
    }

    /**
     * 消息分发
     * @return
     */
    @GetMapping("/distribution")
    public String distribution() {
        source.message().send(MessageBuilder.withPayload("Hello World..." + new Date())
                .setHeader("version", "2.0")
                .setHeader("x-delay", 5000)
                .build());
        return "Hello World ";
    }


    /**
     * 动态绑定渠道
     * @param body 内容
     * @param dest 通道
     * @param contentType 格式/类型
     * @return
     */
    @RequestMapping("/dynamicChannel")
    public String dynamicChannel(@RequestBody String body, String dest, @RequestHeader Object contentType) {
        resolver.resolveDestination(dest).send(MessageBuilder.createMessage(body,
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, contentType))));
        return "Hello World";
    }


}
