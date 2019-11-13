package com.qatix.droolsdemo.controller;

import com.qatix.droolsdemo.entity.Message;
import com.qatix.droolsdemo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/simple")
public class SimpleController {
    @Autowired
    private SimpleService simpleService;

    @GetMapping("/test1")
    public String showRults() {
        return simpleService.fireRule();
    }

    //http://localhost:8080/simple/message?message=hello&status=0
    @GetMapping("/message")
    public String showRults(@RequestParam(name = "message") String message, @RequestParam(name = "status") int status) {

        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setStatus(status);

        return simpleService.fireRuleWithMessage(newMessage);
    }


}