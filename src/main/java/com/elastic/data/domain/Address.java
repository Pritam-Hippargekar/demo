package com.elastic.data.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;
@Data
@RequiredArgsConstructor
public class Address {
    @Field(type = FieldType.Long, name = "id")
    private Long id;

    @Field(type = FieldType.Text, name = "street", analyzer = "ik_max_word")
    private String street;

    @Field(type = FieldType.Integer)
    private Integer houseNumber;

    @Field(type = FieldType.Keyword)
    private String state;

    @Field(type = FieldType.Keyword)
    private String city;

    @Field(type = FieldType.Keyword)
    private String district;

    @Field(type = FieldType.Text, name = "zip_code")
    private String zipCode;

    @GeoPointField
    @Field(type = FieldType.Object,name = "location")
    private Location location;

//    @GeoPointField
//    @Field(name = "location")
//    private GeoPoint location;
}
