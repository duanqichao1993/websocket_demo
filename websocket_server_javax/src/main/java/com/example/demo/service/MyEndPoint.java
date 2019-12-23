package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Service
// 定义了服务端webSoket的访问地址
@ServerEndpoint("/test/websocket")
public class MyEndPoint {

    private Session session;

    @OnOpen
    public void myOnOpen (Session session) {
        this.session = session;
        System.out.println ("WebSocketConfig opened: "+session.getId());
        System.out.println("客户端已经链接");
    }

    @OnMessage
    public String myOnMessage (String txt) throws IOException {
        System.out.println(txt);

        return "服务端收到并返回";
    }

    @OnClose
    public void myOnClose (CloseReason reason) {
        System.out.println ("Closing a WebSocketConfig due to "+reason.getReasonPhrase());
    }

    @OnError
    public void onError(Throwable throwable){
        System.out.println("连接已经关闭");
    }


}
