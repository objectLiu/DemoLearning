package com.play.videoWeb.controller;

import com.play.videoWeb.entity.Greeting;
import com.play.videoWeb.entity.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liujc
 * @ate 2020-01-07 15:40
 */
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting getGreeting(HelloMessage message) {
        //topic是以组播形式返回给所有此订阅频道的用户页面
        return new Greeting("Hello" + HtmlUtils.htmlEscape(message.getName()));
    }

    @RequestMapping("/getHtml")
    public String getHtml(HttpServletRequest request) {
        return "/webIndex";
    }
}
