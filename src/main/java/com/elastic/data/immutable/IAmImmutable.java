package com.elastic.data.immutable;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class IAmImmutable {
    private final Integer uid; //Immutable member variable
    private final List <Object> list;//mutable member variable
    private Address address;// consider this is third party class. which is not implemented clonable //mutable member variable
    private String fname;//Immutable member variable
    private Date publishedDate;//mutable member variable

    private final HashMap<String,String> testMap;//mutable member variable

    public IAmImmutable(Integer uid, List <Object> list, String fname, Address address, Date publishedDate, HashMap<String, String> testMap) {
        super();
        this.uid = uid;
        this.list = new ArrayList<>(list);
        this.fname = fname;
        this.address = new Address(address.getStreetName(), address.getCity(), address.getZipCode());
        this.publishedDate = publishedDate;
//      this.testMap=new HashMap<Integer, String>(testMap);
        // OR
        // It doesn't matter whether you make deep or shallow copy
        this.testMap = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            this.testMap.put((entry.getKey()), entry.getValue());
        }
    }
    public Integer getUId() {
        return this.uid;
    }
    public String getName() {
        return this.fname;
    }
    public List <Object> getList() {
        return new ArrayList<>(this.list); // defensive
    }

    public Address getAddress() {
        return new Address(this.address.getStreetName(), this.address.getCity(), this.address.getZipCode());
    }

    public Date getPublishedDate() {
        //return (Date) publishedDate.clone();
        return new Date(this.publishedDate.getTime());
    }

    // deep copy the map of testMap
    public Map<String, String> getTestMap() {
        //return (HashMap<Integer, String>) testMap.clone();
        return new HashMap<>(this.testMap);
    }


    public static void main(String[] args) {
        String clazzName = "ArrayList";
        String maskedCardNumber = StringUtils.overlay(clazzName, StringUtils.repeat("*", clazzName.length() - 4), 0, clazzName.length() - 4);
        System.out.println(clazzName);
        System.out.println(maskedCardNumber);
    }
}


//    public ImmutableReminder (Date remindingDate) {
//        if(remindingDate.getTime() < System.currentTimeMillis()){
//            throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);
//        }
//        this.remindingDate = new Date(remindingDate.getTime());
//    }

