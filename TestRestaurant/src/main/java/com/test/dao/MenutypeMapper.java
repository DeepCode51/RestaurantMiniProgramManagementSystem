package com.test.dao;

import com.test.obj.Depart;
import com.test.obj.Menutype;
import com.test.obj.Page;

import java.util.List;
import java.util.Map;

public interface MenutypeMapper {
    List<Menutype> getmenutype();

    Menutype search_id(Integer id);

    int delete(Integer id);

    int update(Menutype menutype);

    int insert(Menutype menutype);

    List<Menutype> search_name(Map<String, Object> map);

    List<Menutype> info_list(Page page);
}
