package com.test.service;

import com.test.obj.*;

import java.util.List;

public interface CustService {
    int insert(Order order);

    Double getmoney(customer customer);

    ResultMap<List<customer>> getinfo(SeriesPage page);

    ResultMap<List<Order>> getorderinfo(SeriesPage page);


    ResultMap<List<Foodtable>> table_list(Page page);

    Foodtable searchtable_id(Integer id);

    int update(Foodtable table);

    int update1(Foodtable table);

    ResultMap<List<Order>> search_order(Page page, String menutype);

    ResultMap<List<Order>> order_list(Page page);

    int updateorder(Order order);

    int delete(Integer id);

    customer searchmoney(customer customer);

    void updatecut(customer customer);
}
