package com.example.demo.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.member.AdminUserInfo;
import com.example.demo.member.QAdminUserInfo;
import com.example.demo.member.QUserInfo;
import com.example.demo.member.UserInfo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class AdminUserInfoRepositorySupport  extends QuerydslRepositorySupport {

	private final JPAQueryFactory queryFactory;
	
	public AdminUserInfoRepositorySupport(JPAQueryFactory queryFactory) {
		super(AdminUserInfo.class);
		this.queryFactory = queryFactory;
	}
	
	public List<UserInfo> findByNotAdminUserInfo(){
		
		QUserInfo userInfo = QUserInfo.userInfo;
		QAdminUserInfo adminUserInfo = QAdminUserInfo.adminUserInfo;
		
		return queryFactory.select(Projections.fields(UserInfo.class, userInfo.userName.as("id"))).from(userInfo).innerJoin(adminUserInfo).on(userInfo.userName.ne(adminUserInfo.userName)).fetch();
		
	}

}
