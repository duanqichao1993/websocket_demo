package com.example.websocket_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Component
@EnableWebSocket
public class WebScoketConfig implements WebSocketConfigurer {

    /**
     *  register  message handler and  webSocket Uri path
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebScoketHandler(),"/test/websocket").setAllowedOrigins("*");
    }

    /**
     * register MyWebSocketHandler to Spring container
     * @return  MyWebSocketHandler
     */
    @Bean
    public MyWebScoketHandler myWebScoketHandler(){
        return  new MyWebScoketHandler();
    }


}
