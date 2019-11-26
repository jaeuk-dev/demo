package com.example.demo.code.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommonCodeSub is a Querydsl query type for CommonCodeSub
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommonCodeSub extends EntityPathBase<CommonCodeSub> {

    private static final long serialVersionUID = -1372831516L;

    public static final QCommonCodeSub commonCodeSub = new QCommonCodeSub("commonCodeSub");

    public final StringPath codeBigo = createString("codeBigo");

    public final StringPath codeName = createString("codeName");

    public final StringPath codeNumber = createString("codeNumber");

    public final StringPath codeValue1 = createString("codeValue1");

    public final StringPath codeValue2 = createString("codeValue2");

    public final StringPath codeValue3 = createString("codeValue3");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath parentCodeNumber = createString("parentCodeNumber");

    public QCommonCodeSub(String variable) {
        super(CommonCodeSub.class, forVariable(variable));
    }

    public QCommonCodeSub(Path<? extends CommonCodeSub> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonCodeSub(PathMetadata metadata) {
        super(CommonCodeSub.class, metadata);
    }

}

