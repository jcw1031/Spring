package com.example.youtube.controller;

import com.example.youtube.entity.Orders;
import com.example.youtube.service.GoodsService;
import com.example.youtube.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;
    @Autowired
    GoodsService goodsService;

    @PostMapping("/orders/{id}")
    public void orderGoods(@PathVariable("id") String id, @RequestParam("goodsId") int goodsId, @RequestParam("amount") int amount) {
        LocalDateTime now = LocalDateTime.now();
        String date = String.valueOf(now);

        Orders orders = ordersService.setOrdersInfo(id, goodsId, amount, date);
        ordersService.order(orders);
    }

    @GetMapping("orders/search/all")
    public List<Orders> getOrdersInfoList(){
        return ordersService.findAll();
    }

    @DeleteMapping("/orders/cancel")
    public void orderCancel(@RequestParam("id") int id){
        ordersService.orderCancel(id);
    }
}
