package com.test.service;

import com.test.obj.Admin;
import com.test.obj.Page;
import com.test.obj.ResultMap;

import java.util.List;

public interface AdminService {
    boolean login(Admin admin);

    Admin search_id(Integer id);

    int delete(Integer id);

    int update(Admin admin);

    int insert(Admin admin);

    ResultMap<List<Admin>> search_sname(Page page, String account);

    ResultMap<List<Admin>> admin_list(Page page);
}
