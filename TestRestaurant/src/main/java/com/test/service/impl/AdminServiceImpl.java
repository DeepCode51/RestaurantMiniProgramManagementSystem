package com.test.service.impl;

import com.test.dao.AdminMapper;
import com.test.obj.Admin;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public boolean login(Admin admin) {
        Admin admin_search = adminMapper.login(admin);
        if (admin_search == null){
            return false;
        }
        return admin.getPassword().equals(admin_search.getPassword());
    }
    @Override
    public int delete(Integer id) {
        return adminMapper.delete(id);
    }

    @Override
    public Admin search_id(Integer id) {
        return adminMapper.search_id(id);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.update(admin);
    }

    @Override
    public int insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public ResultMap<List<Admin>> search_sname(Page page, String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("account", account);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Admin> list = adminMapper.search_sname(map);
        ResultMap<List<Admin>> jsonMap = new ResultMap<List<Admin>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Admin>> admin_list(Page page) {
        List<Admin> list = adminMapper.admin_list(page);
        ResultMap<List<Admin>> jsonMap = new ResultMap<List<Admin>>(0, "success", list);
        return  jsonMap;
    }

}
