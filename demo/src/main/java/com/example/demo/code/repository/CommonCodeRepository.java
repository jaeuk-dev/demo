package com.example.demo.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.code.entity.CommonCode;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCode, Long>{

	List<CommonCode> findByCodeNameAndCodeValue(String codeName, String codeValue);
	
	List<CommonCode> findByCodeNumber(String codeNumber);
}
