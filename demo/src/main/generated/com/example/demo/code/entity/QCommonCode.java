package com.example.demo.code.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommonCode is a Querydsl query type for CommonCode
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommonCode extends EntityPathBase<CommonCode> {

    private static final long serialVersionUID = -727671876L;

    public static final QCommonCode commonCode = new QCommonCode("commonCode");

    public final StringPath codeBigo = createString("codeBigo");

    public final StringPath codeName = createString("codeName");

    public final StringPath codeNumber = createString("codeNumber");

    public final StringPath codeValue = createString("codeValue");

    public final CollectionPath<CommonCodeSub, QCommonCodeSub> commonCodeSub = this.<CommonCodeSub, QCommonCodeSub>createCollection("commonCodeSub", CommonCodeSub.class, QCommonCodeSub.class, PathInits.DIRECT2);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public QCommonCode(String variable) {
        super(CommonCode.class, forVariable(variable));
    }

    public QCommonCode(Path<? extends CommonCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonCode(PathMetadata metadata) {
        super(CommonCode.class, metadata);
    }

}

