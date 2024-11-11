package com.test.dao;

import com.test.obj.Admin;
import com.test.obj.Page;
import com.test.obj.Rest;

import java.util.List;
import java.util.Map;

public interface AdminRestMapper {
    Rest login(Rest rest);
    Rest search_id(Integer id);
    int delete(int id);
    int update(Rest rest);
    int insert(Rest rest);
    List<Rest> search_rname(Map<String, Object> map);
    List<Rest> admin_rest_list(Page page);

    String pic_url(String sno);
}
