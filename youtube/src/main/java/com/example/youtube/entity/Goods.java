package com.example.youtube.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
@ToString
public class Goods {
    @Id
    private int goodsId;
    private String goodsName;
    private int goodsStock;
}
