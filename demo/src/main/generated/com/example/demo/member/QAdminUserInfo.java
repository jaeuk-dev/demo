package com.example.demo.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminUserInfo is a Querydsl query type for AdminUserInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdminUserInfo extends EntityPathBase<AdminUserInfo> {

    private static final long serialVersionUID = 367360398L;

    public static final QAdminUserInfo adminUserInfo = new QAdminUserInfo("adminUserInfo");

    public final StringPath authorityCode = createString("authorityCode");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath userName = createString("userName");

    public QAdminUserInfo(String variable) {
        super(AdminUserInfo.class, forVariable(variable));
    }

    public QAdminUserInfo(Path<? extends AdminUserInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminUserInfo(PathMetadata metadata) {
        super(AdminUserInfo.class, metadata);
    }

}

