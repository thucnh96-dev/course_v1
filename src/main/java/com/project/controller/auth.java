package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class auth {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/auth/login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        // String data = request.
        return "index";
    }
}
