package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDemoBoard is a Querydsl query type for DemoBoard
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDemoBoard extends EntityPathBase<DemoBoard> {

    private static final long serialVersionUID = -860674606L;

    public static final QDemoBoard demoBoard = new QDemoBoard("demoBoard");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    public final StringPath name = createString("name");

    public QDemoBoard(String variable) {
        super(DemoBoard.class, forVariable(variable));
    }

    public QDemoBoard(Path<? extends DemoBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDemoBoard(PathMetadata metadata) {
        super(DemoBoard.class, metadata);
    }

}

