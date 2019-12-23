package com.example.websocket_client.service;

import com.example.websocket_client.config.MyWebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketClient;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class ClientService {

    @Autowired
    private MyWebSocketClient webSocketClient ;

    @PostConstruct
    public void  init() throws IOException {
        webSocketClient.connected();
        webSocketClient.sendMessage();
    }


}
