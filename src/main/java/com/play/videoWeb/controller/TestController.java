package com.play.videoWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liujc
 * @ate 2020-01-07 13:45
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String getIndex(HttpServletRequest request) {
        request.setAttribute("key", "hello world");
        return "/index";
    }
}
