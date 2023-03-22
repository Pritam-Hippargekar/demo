package com.elastic.data.domain;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;
@Data
@RequiredArgsConstructor
public class Subject {
    @Field(type = FieldType.Long, name = "id")
    private Long id;

    @Field(type = FieldType.Keyword, name = "name")
    private String name;

    @Field(type = FieldType.Integer, name = "mark")
    private Integer mark;
}
