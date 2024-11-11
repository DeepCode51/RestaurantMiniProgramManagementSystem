package com.test.service;

import com.test.obj.Admin;
import com.test.obj.Page;
import com.test.obj.Rest;
import com.test.obj.ResultMap;

import java.util.List;

public interface AdminRestService {
    ResultMap<List<Rest>> search_rname(Page page, String rname);

    ResultMap<List<Rest>> admin_rest_list(Page page);

    int delete(Integer id);

    int insert(Rest rest);

    Rest search_id(Integer id);

    boolean login(Rest rest);
    int update(Rest rest);

    String pic_url(String sno);
}
