package com.test.service;

import com.test.obj.Depart;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Staff;

import java.util.List;

public interface RestdepartService {

    List<Depart> getdepart();

    //常规增删改
    Depart search_id(Integer id);

    int delete(Integer id);

    int update(Depart depart);

    int insert(Depart depart);

    ResultMap<List<Depart>> search_name(Page page, String sdepart);

    ResultMap<List<Depart>> info_list(Page page);
}
