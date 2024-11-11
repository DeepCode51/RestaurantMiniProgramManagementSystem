package com.test.dao;

import com.test.obj.Depart;
import com.test.obj.Page;
import com.test.obj.Staff;

import java.util.List;
import java.util.Map;

public interface RestdepartMapper {
    List<Depart> getdepart();

    Depart search_id(Integer id);

    int delete(Integer id);

    int update(Depart depart);

    int insert(Depart depart);

    List<Depart> search_name(Map<String, Object> map);

    List<Depart> info_list(Page page);
}
