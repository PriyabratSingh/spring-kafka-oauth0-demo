package com.example.demo.controller;


import com.example.demo.model.UserRegister;

import com.example.demo.service.UserRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class UserRegisterController {
    private Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

    @Autowired
    private UserRegisterService userRegisterService;

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("user", principal.getAttributes());
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegister register){
        logger.debug(register.toString());

        userRegisterService.registerUser(register);
        return ResponseEntity.ok("User has Register Successfull");
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<com.example.demo.entity.UserRegister>> getAllUser(
            @RequestParam(required = false, defaultValue = "0") Long cursor, @RequestParam(defaultValue = "3") int limit){
        List<com.example.demo.entity.UserRegister> userList = userRegisterService.getAllUser(cursor,limit);
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    @GetMapping("/private")
    public String privateEndpoint(@AuthenticationPrincipal OidcUser user) {
        return "Hello " + user.getFullName() + ", this is a private endpoint";
    }


}
