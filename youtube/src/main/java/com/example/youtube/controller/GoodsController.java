package com.example.youtube.controller;

import com.example.youtube.entity.Goods;
import com.example.youtube.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/goods/register")
    public void goodsRegistration(@RequestParam("name") String name, @RequestParam("stock") int stock) {
        Goods goods = goodsService.setGoodsInfo(0, name, stock);
        goodsService.register(goods);
    }

    @GetMapping("/goods/search/all")
    public List<Goods> findAll(){
        return goodsService.findAll();
    }

    @PutMapping("/goods/update/{id}")
    public void updateInfo(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("stock") int stock) {
        Optional<Goods> goods = goodsService.findById(id);
        if (goods.isPresent()) {
            goods = Optional.ofNullable(goodsService.setGoodsInfo(id, name, stock));
            goodsService.register(goods.get());
        }
        else{
            System.out.println("'"+id+"' 아이디를 가진 상품이 존재하지 않습니다.");
        }
    }
}
