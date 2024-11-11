package com.test.dao;

import com.test.obj.Admin;
import com.test.obj.Page;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    Admin login(Admin admin);
    int delete(int id);
    Admin search_id(Integer id);
    int update(Admin admin);
    int insert(Admin admin);

    List<Admin> search_sname(Map<String, Object> map);

    List<Admin> admin_list(Page page);
}
