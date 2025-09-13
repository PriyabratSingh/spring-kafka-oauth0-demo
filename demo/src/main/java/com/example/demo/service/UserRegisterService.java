package com.example.demo.service;

import com.example.demo.mapper.UserRegisterMapper;
import com.example.demo.model.UserRegister;
import com.example.demo.repository.UserRegisterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class UserRegisterService {
   Logger logger = LoggerFactory.getLogger(UserRegisterService.class);

   @Autowired
   private UserRegisterRepository repository;

   @Autowired
   private UserRegisterMapper mapper;

    public void registerUser(UserRegister register){
      logger.debug("User Register in Service class");
        repository.save(mapper.giveMeUserEntity(register));
        logger.debug("The user has been save successfully");
    }

    public List<com.example.demo.entity.UserRegister> getAllUser(Long cursor, int limit){
        return repository.findUserRegisters(cursor, PageRequest.of(0, limit));
    }



}
