package com.test.controller;

import com.test.obj.*;
import com.test.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustomerController {
    @Autowired
    CustService custService;

    @RequestMapping("/submit1")
    @ResponseBody
    public int submitorder(@RequestParam("openid") String openid,
                           @RequestParam("createtime") String createtime,
                           @RequestParam("totalprice") Double totalprice) {
        Order order = new Order();
        double temp=0;
        order.setOpenid(openid);
        order.setCreatetime(createtime);
        order.setTotalprice(totalprice);
        order.setStat("等待");
        order.setRaccount("400995387");
//        System.out.println(order.toString());

        customer customer = new customer();
        customer.setOpenid(openid);
        customer = custService.searchmoney(customer);
       temp=customer.getMoney();
       temp=temp-totalprice;
       customer.setMoney(temp);
        //查找当前用户的余额并看看相减钱是否足够
        if (temp>0){
            custService.updatecut(customer);
            return custService.insert(order);
        }else{
            return 0;
        }


    }

    @RequestMapping("/getinfo")
    @ResponseBody
    public Double bydepart(@RequestParam(value = "openid", defaultValue = "") String openid) {
        customer customer = new customer();
        customer.setOpenid(openid);
        return custService.getmoney(customer);
    }
    @RequestMapping("/getorderinfo")
    @ResponseBody
    public ResultMap<List<Order>> bydepart1(@RequestParam(value = "openid", defaultValue = "") String openid) {
        SeriesPage page = new SeriesPage();
        page.setClassify(openid);
        return custService.getorderinfo(page);
    }



}
