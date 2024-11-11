package com.test.service;

import com.test.obj.*;

import java.util.List;

public interface MenuService {

    //常规增删改
    Menu search_id(Integer id);

    int delete(Integer id);

    int update(Menu menu);

    int insert(Menu menu);

    ResultMap<List<Menu>> search_name(Page page, String name);

    ResultMap<List<Menu>> info_list(Page page);

    ResultMap<List<Menu>> menu_menutype(SeriesPage page);

    String pic_url(String sno);

    ResultMap<List<Menu>> getall();
}
