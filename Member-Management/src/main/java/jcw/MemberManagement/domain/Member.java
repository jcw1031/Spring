package jcw.MemberManagement.domain;

import javax.persistence.*;

@Entity //jpa가 관리하는 entity이다.
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //PK(DB가 알아서 생성)
    private Long id;

//    @Column(name = "userName") //DB에는 이름이 userName일 때 매핑
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
