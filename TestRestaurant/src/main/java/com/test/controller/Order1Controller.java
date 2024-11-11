package com.test.controller;
import com.test.obj.*;
import com.test.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order1")
public class Order1Controller {
    @Autowired
    CustService custService;
    @RequestMapping("/order1_info")
    public String infoindex(){
        return "rest_order1_info";
    }

    @RequestMapping("/order1_list")
    @ResponseBody
    public ResultMap<List<Order>> list_rest(Page page, @RequestParam("limit") int limit, @RequestParam(value = "openid", defaultValue = "") String menutype){
        page.setRows(limit);
        infoindex();
        if (menutype.length()>0){
            return custService.search_order(page,menutype);
        }else {
            return custService.order_list(page);
        }

    }

    @RequestMapping("/order1_edit1.do")
    @ResponseBody
    public int edit(@RequestParam("id") int id){//记得加当前时间

        Order order = new Order();
        order.setId(id);
        order.setStat("结束");
        return custService.updateorder(order);
    }

       @RequestMapping("/order1_delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return custService.delete(id);
    }
}
