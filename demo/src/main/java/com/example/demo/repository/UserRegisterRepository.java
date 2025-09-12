package com.example.demo.repository;


import com.example.demo.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepository extends  JpaRepository<UserRegister,Integer> {


    @Override
    <S extends UserRegister> S save(S entity);
}
