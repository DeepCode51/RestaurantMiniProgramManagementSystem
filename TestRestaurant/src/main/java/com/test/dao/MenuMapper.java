package com.test.dao;

import com.test.obj.*;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    Menu search_id(Integer id);

    int delete(Integer id);

    int update(Menu menu);

    int insert(Menu menu);

    List<Menu> search_name(Map<String, Object> map);

    List<Menu> info_list(Page page);

    List<Menu> menu_menutype(SeriesPage page);

    String pic_url(String sno);

    List<Menu>getall();
}
