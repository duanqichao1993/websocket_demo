package com.example.websocket_client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;

@Component
public class MyWebSocketClient  {

    @Autowired
    private MyWebSocketHandler myWebSocketHandler ;
    private WebSocketSession webSocketSession;
    private boolean isConnected  = false ;

    public void connected(){
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
        ListenableFuture<WebSocketSession> future = webSocketClient.doHandshake(myWebSocketHandler, headers, URI.create("ws://localhost:8080/test/websocket"));
        try {
            webSocketSession = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        isConnected = true ;

    }

    public void sendMessage() throws IOException {
        int id =  0 ;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {


            }
            webSocketSession.sendMessage(new TextMessage("消息序列：id = " + id));
            id++ ;
        }
    }
}

