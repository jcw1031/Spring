package com.example.youtube.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private String id;
    private String name;
    private String phone;
    private String address;

    public Member(String id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
