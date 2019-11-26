package com.example.demo.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.member.QAdminUserInfo;
import com.example.demo.member.QUserInfo;
import com.example.demo.member.UserInfo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserInfoRepositorySupport  extends QuerydslRepositorySupport {

	private final JPAQueryFactory queryFactory;
	QUserInfo userInfo = QUserInfo.userInfo;
	QAdminUserInfo adminUserInfo = QAdminUserInfo.adminUserInfo;
	
	public UserInfoRepositorySupport(JPAQueryFactory queryFactory) {
		super(UserInfo.class);
		this.queryFactory = queryFactory;
	}
	
	public List<UserInfo> findByDynamicQueryUserInfo(UserInfo user){
		
		return queryFactory.selectFrom(userInfo).where(eqUserName(user.getUserName()), eqName(user.getName()), eqPhoneNumber(user.getPhoneNumber())).fetch();
		
	}
	
	public BooleanExpression eqUserName(String userName) {
		if(org.springframework.util.StringUtils.isEmpty(userName)) {
			return null;
		}
	
		return userInfo.userName.eq(userName); 
	}
	
	public BooleanExpression eqName(String name) {
		if(org.springframework.util.StringUtils.isEmpty(name)) {
			return null;
		}
	
		return userInfo.name.eq(name); 
	}
	
	public BooleanExpression eqPhoneNumber(String phoneNumber) {
		if(org.springframework.util.StringUtils.isEmpty(phoneNumber)) {
			return null;
		}
	
		return userInfo.phoneNumber.eq(phoneNumber); 
	}
}
