package com.jcw.test.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity //객체가 엔티티 클래스임을 명 -> Repository를 통해 DB와 통신하는 주체가 된다.
public class Member {
    @Id //@Id를 명시해준 변수는 DB에 들어갈 때 PK가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 값 생성
    private Long memberSn;
    private String memberId;
    private String password;
    private String memberName;
    private String role;

}
