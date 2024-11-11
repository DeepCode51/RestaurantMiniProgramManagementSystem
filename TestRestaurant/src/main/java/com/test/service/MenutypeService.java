package com.test.service;

import com.test.obj.*;

import java.util.List;

public interface MenutypeService {
    List<Menutype> getmenutype();
    //常规增删改
    Menutype search_id(Integer id);

    int delete(Integer id);

    int update(Menutype menutype);

    int insert(Menutype menutype);

    ResultMap<List<Menutype>> search_name(Page page, String name);

    ResultMap<List<Menutype>> info_list(Page page);
}
