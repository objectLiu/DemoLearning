package com.play.videoWeb.common;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * websocket启用代理模式进行访问
 * @author liujc
 * @ate 2020-01-07 15:50
 */
@Configurable
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //配置客户端去socket的地址，使socket js能够以匹配最好的模式。因为有一些浏览器是不支持websocket协议的。
        //传输方式可能有websocket，xhr-streaming，xhr-polling。socket会选择最好的
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //配置访问web controller的全局前缀，，用以客户端访问服务端
        registry.setApplicationDestinationPrefixes("/app");
        //配置订阅统一前缀，用以服务端发送消息到客户端
        registry.enableSimpleBroker("topic");
    }
}
