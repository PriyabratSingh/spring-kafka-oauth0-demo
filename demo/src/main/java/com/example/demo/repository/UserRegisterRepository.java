package com.example.demo.repository;

import org.springframework.data.domain.Pageable;
import com.example.demo.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegisterRepository extends  JpaRepository<UserRegister,Integer> {


    @Override
    <S extends UserRegister> S save(S entity);


    @Query("SELECT u FROM UserRegister u WHERE u.id > :cursor ORDER BY u.id ASC")
    List<UserRegister> findUserRegisters(@Param("cursor") Long cursor, Pageable pageable);

}
