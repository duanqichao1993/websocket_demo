package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import java.io.IOException;

@Service
@ClientEndpoint
public class MyClientEndPoint {


    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println ("WebSocketConfig opened: "+session.getId());
        System.out.println("服务端链接成功");
        try {
            this.sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public String onMessage(String txt) throws IOException, InterruptedException {
        System.out.println(txt);
        Thread.sleep(1000);
        return "客户端收到";
    }

    @OnClose
    public void onClose(CloseReason reason) {
        System.out.println ("Closing a WebSocketConfig due to "+reason.getReasonPhrase());
    }

    @OnError
    public void onError(Throwable throwable){
        System.out.println("连接已经关闭");
    }

    public void sendMessage() throws IOException {
        this.session.getBasicRemote().sendText("客户端发送");
    }


}
