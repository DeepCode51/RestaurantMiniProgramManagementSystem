package com.test.service.impl;

import com.test.dao.CustMapper;
import com.test.obj.*;
import com.test.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CustServiceImpl implements CustService {
    @Autowired
    CustMapper custMapper;
    @Override
    public int insert(Order order) {
        return custMapper.insert(order);
    }

    @Override
    public Double getmoney(customer customer) {
        return custMapper.getmoney(customer);
    }

    @Override
    public ResultMap<List<customer>> getinfo(SeriesPage page) {
        List<customer> list = custMapper.getinfo(page);
        ResultMap<List<customer>> jsonMap = new ResultMap<List<customer>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Order>> getorderinfo(SeriesPage page) {
        List<Order> list = custMapper.getorderinfo(page);
        ResultMap<List<Order>> jsonMap = new ResultMap<List<Order>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Foodtable>> table_list(Page page) {
        List<Foodtable> list =custMapper.table_list(page);
        ResultMap<List<Foodtable>> jsonMap = new ResultMap<List<Foodtable>>(0, "success", list);
        return  jsonMap;
    }

    @Override
    public Foodtable searchtable_id(Integer id)
        {
            return custMapper.searchtable_id(id);
    }

    @Override
    public int update(Foodtable table) {
        return custMapper.update(table);
    }

    @Override
    public int update1(Foodtable table) {
        return custMapper.update1(table);
    }

    @Override
    public ResultMap<List<Order>> search_order(Page page, String menutype) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", menutype);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Order> list =custMapper.search_order(map);
        ResultMap<List<Order>> jsonMap = new ResultMap<List<Order>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Order>> order_list(Page page) {
        List<Order> list =custMapper.order_list(page);
        ResultMap<List<Order>> jsonMap = new ResultMap<List<Order>>(0, "success", list);
        return  jsonMap;
    }

    @Override
    public int updateorder(Order order) {
        return custMapper.updateorder(order);
    }

    @Override
    public int delete(Integer id) {
        return custMapper.delete(id);
    }

    @Override
    public customer searchmoney(customer customer) {
        return custMapper.searchmoney(customer);
    }

    @Override
    public void updatecut(customer customer) {
        custMapper.updatecut(customer);
    }
}
