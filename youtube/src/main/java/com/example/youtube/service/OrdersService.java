package com.example.youtube.service;

import com.example.youtube.entity.Orders;
import com.example.youtube.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    GoodsService goodsService;

    public void order(Orders orders) {
        ordersRepository.save(orders);
        goodsService.sellGoods(orders.getGoodsId(), orders.getOrderAmount());
    }

    public Orders setOrdersInfo(String memberId, int goodsId, int amount, String date){
        Orders orders = new Orders();
        orders.setMemberId(memberId);
        orders.setGoodsId(goodsId);
        orders.setOrderAmount(amount);
        orders.setOrderDate(date);
        return orders;
    }

    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public Optional<Orders> findById(int id){
        return ordersRepository.findById(id);
    }

    public void orderCancel(int id) {
        Optional<Orders> orders = ordersRepository.findById(id);
        orders.ifPresent(value -> ordersRepository.delete(value));
        goodsService.storeGoods(orders.get().getGoodsId(), orders.get().getOrderAmount());
    }
}
