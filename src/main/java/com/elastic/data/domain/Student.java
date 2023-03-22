package com.elastic.data.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Document(indexName = "#{@getIndexName}", createIndex = true)
@Setting(shards = 1, replicas = 0, refreshInterval = "1ms")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "first_name",analyzer = "ik_max_word")
    //@Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String firstName;

    @Field(type = FieldType.Text, name = "sur_name",analyzer = "ik_max_word")
    private String surName;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Date,format={DateFormat.basic_date, DateFormat.year_month_day})
    private LocalDate joinDate;

//    @Field(type = FieldType.Date, format = DateFormat.date)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private LocalDate joinDate;

    @Field(type = FieldType.Object)
    private Address address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field(type = FieldType.Nested, includeInParent = true,name = "subjects")
    private List<Subject> subjects;

//    private Map<String, String> userSettings = new HashMap<>();

    @Field ( type = FieldType.Keyword , name = "gender" )
    private String gender;
    public enum Sex { MALE, FEMALE, OTHER; }
//  https://juejin.cn/post/7084951356569714724   Map<String, Property> documentMap = new HashMap<>();
//  Lengthy text fields like product descriptions or user comments are what text fields are typically used for. This is because these are fields that the user should be able to find by searching a single word in that field.
//  Strings for keyword on the other hand are used for string fields that are searched for by the entire string.
//  email

    @Field(type=FieldType.Boolean, name = "active" )
    private Boolean active = null;

//    @Field(type = FieldType.Keyword , name = "roles")
//    private List<String> roles;

    @Field(type = FieldType.Keyword, name = "roles")
    private Set<String> languages;

    @Field(index = false, type = FieldType.Keyword)
    private String photo;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String about;

//    @Field(type= FieldType.String, index = FieldIndex.not_analyzed)
//    private List<String> skills;

//    @Field ( type = FieldType.Date , name = "birth" )
//    private Date birthDate;

//   @Field(type = FieldType.Text, name = "description")
//   private String description;

//    @Field(type = FieldType.Double)
//    private BigDecimal price;

//    @Field(type = FieldType.Date, format = DateFormat.date_time)
//    private Instant createdDate = null;
//
//    @Field(type = FieldType.Date, name = "create_time", pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;

//    @Field(value = "operation_time", type = FieldType.Date, format = {}, pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
//    private LocalDateTime operationTime;
}
