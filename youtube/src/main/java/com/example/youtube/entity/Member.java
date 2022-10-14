package com.example.youtube.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter @Setter
@Entity
@ToString
public class Member {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String memberId;
    private String memberName;
    private String memberPhone;
    private String memberAddress;

    /*public Member(String memberId, String memberName, String memberPhone, String memberAddress) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
    }*/
}
