package com.example.demo.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.code.entity.CommonCodeSub;

@Repository
public interface CommonCodeSubRepository extends JpaRepository<CommonCodeSub, Long> {

}
