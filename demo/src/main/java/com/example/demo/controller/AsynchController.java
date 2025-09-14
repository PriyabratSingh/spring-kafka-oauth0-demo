package com.example.demo.controller;


import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynchController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/testEmail")
    public String testWithoutAsynch() {
        notificationService.sendEmailWithout("test@example.com"); // normal method
        return "Done!";
    }

    @GetMapping("/testEmailAsynch")
    public String testWithAysnch() {
        notificationService.sendEmail("test@example.com"); // normal method
        return "Done!";
    }


}
