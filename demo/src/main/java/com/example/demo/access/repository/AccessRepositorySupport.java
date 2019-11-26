package com.example.demo.access.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.access.entity.Access;
import com.example.demo.access.entity.QAccess;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository("accessRepositorySupport")
public class AccessRepositorySupport extends QuerydslRepositorySupport {
	
	private final JPAQueryFactory queryFactory;

	public AccessRepositorySupport(JPAQueryFactory queryFactory) {
		super(Access.class);
		this.queryFactory = queryFactory;
	}
	
	public long findByCountGroupbyIpAndSessionIdAndUser() {
		QAccess access = QAccess.access;
		return queryFactory.from(access).select(access.cnt.count()).groupBy(access.ip,access.sessionId,access.user).fetch().size();
	}

	
}
