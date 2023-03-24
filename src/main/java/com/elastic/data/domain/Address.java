package com.elastic.data.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Address {
    @Field(type = FieldType.Long, name = "id",store = true)
    private Long id;

    @Field(type = FieldType.Text, name = "address_line", analyzer = "ik_max_word",store = true)
    private String addressLine;

    @Field(type = FieldType.Keyword)
    private String country;

    @Field(type = FieldType.Keyword)
    private String state;

    @Field(type = FieldType.Keyword)
    private String district;

    @Field(type = FieldType.Keyword)
    private String townName;

    @Field(type = FieldType.Text, name = "street_name", analyzer = "ik_max_word")
    private String streetName;

    @Field(type = FieldType.Integer)
    private Integer buildingNumber;

    @Field(type = FieldType.Integer)
    private Integer houseNumber;

    @Field(type = FieldType.Text, name = "post_code")
    private String postCode;

    @GeoPointField
    @Field(type = FieldType.Object,name = "location")
    private Location location;

//    @GeoPointField
//    @Field(name = "location")
//    private GeoPoint location;
}
