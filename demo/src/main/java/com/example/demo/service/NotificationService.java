package com.example.demo.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async
    public void sendEmail(String to) {
        System.out.println("Sending email to " + to + " on thread With Asynch: " + Thread.currentThread().getName());
        try {
            Thread.sleep(9000); // simulate delay
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Email sent to " + to);
    }


    public void sendEmailWithout(String to) {
        System.out.println("Sending email to " + to + " on thread without: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000); // simulate delay
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Email sent to " + to);
    }
}
