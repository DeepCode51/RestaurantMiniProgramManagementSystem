package com.test.dao;

import com.test.obj.*;

import java.util.List;
import java.util.Map;

public interface CustMapper {

    int insert(Order order);

    List<customer> getinfo(SeriesPage page);

    List<Order> getorderinfo(SeriesPage page);

    List<Foodtable> table_list(Page page);

    Foodtable searchtable_id(Integer id);

    int update(Foodtable table);

    int update1(Foodtable table);

    List<Order> search_order(Map<String, Object> map);

    List<Order> order_list(Page page);

    int updateorder(Order order);

    int delete(Integer id);

    customer searchmoney(customer customer);

    int updatecut(customer customer);

    Double getmoney(customer customer);
}
