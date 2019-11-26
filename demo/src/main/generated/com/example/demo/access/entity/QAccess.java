package com.example.demo.access.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccess is a Querydsl query type for Access
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccess extends EntityPathBase<Access> {

    private static final long serialVersionUID = 297404767L;

    public static final QAccess access = new QAccess("access");

    public final DatePath<java.time.LocalDate> accessDate = createDate("accessDate", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> accessTime = createDateTime("accessTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> cnt = createNumber("cnt", Integer.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath ip = createString("ip");

    public final StringPath requestUri = createString("requestUri");

    public final StringPath sessionId = createString("sessionId");

    public final StringPath user = createString("user");

    public QAccess(String variable) {
        super(Access.class, forVariable(variable));
    }

    public QAccess(Path<? extends Access> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccess(PathMetadata metadata) {
        super(Access.class, metadata);
    }

}

