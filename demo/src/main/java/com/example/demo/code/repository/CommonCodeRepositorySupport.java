package com.example.demo.code.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.code.entity.CommonCode;
import com.example.demo.code.entity.QCommonCode;
import com.example.demo.code.entity.QCommonCodeSub;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class CommonCodeRepositorySupport extends QuerydslRepositorySupport{

	public CommonCodeRepositorySupport(Class<CommonCode> domainClass) {
		super(domainClass);
	}
	
	public List<CommonCode> findAll() {
        QCommonCode commonCode = QCommonCode.commonCode;
        QCommonCodeSub commonCodeSub = QCommonCodeSub.commonCodeSub;
        
        
        return null;
    }
	
	
}
