package com.example.stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    @MessageMapping("/index")
    public String testStomp() {
        return "hello";
    }

}
