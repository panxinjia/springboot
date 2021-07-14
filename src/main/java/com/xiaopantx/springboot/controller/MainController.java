package com.xiaopantx.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author panxj
 */
@RestController
@RequestMapping(value = "main")
public class MainController {

    @GetMapping(value = "hello")
    public String hello(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "ok" + session.getId();
    }

    @GetMapping(value = "hello2")
    public String hello2() {
        return "ok2";
    }
}
