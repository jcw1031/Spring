package com.example.youtube.service;

import com.example.youtube.entity.Goods;
import com.example.youtube.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    GoodsRepository goodsRepository;

    public void register(Goods goods){
        goodsRepository.save(goods);
    }

    public Goods setGoodsInfo(int id, String name, int stock){
        Goods goods = new Goods();
        goods.setGoodsId(id);
        goods.setGoodsName(name);
        goods.setGoodsStock(stock);
        return goods;
    }

    public Optional<Goods> findById(int id){
        return goodsRepository.findById(id);
    }

    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    public void sellGoods(int id, int amount){
        Optional<Goods> goods = goodsRepository.findById(id);
        if (goods.isPresent()) {
            goods.get().setGoodsStock(goods.get().getGoodsStock()-amount);
            goodsRepository.save(goods.get());
        }
    }

    public void storeGoods(int id, int amount){
        Optional<Goods> goods = goodsRepository.findById(id);
        if (goods.isPresent()) {
            goods.get().setGoodsStock(goods.get().getGoodsStock()+amount);
            goodsRepository.save(goods.get());
        }
    }
}
