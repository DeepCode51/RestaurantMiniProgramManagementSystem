package com.test.service.impl;

import com.test.dao.AdminRestMapper;
import com.test.obj.Admin;
import com.test.obj.Page;
import com.test.obj.Rest;
import com.test.obj.ResultMap;
import com.test.service.AdminRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class AdminRestServiceImpl implements AdminRestService {
    @Autowired
    AdminRestMapper adminRestMapper;
    @Override
    public ResultMap<List<Rest>> search_rname(Page page, String rname) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rname", rname);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
            List<Rest> list = adminRestMapper.search_rname(map);
        ResultMap<List<Rest>> jsonMap = new ResultMap<List<Rest>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Rest>> admin_rest_list(Page page) {
        List<Rest> list = adminRestMapper.admin_rest_list(page);
        ResultMap<List<Rest>> jsonMap = new ResultMap<List<Rest>>(0, "success", list);
        return  jsonMap;
    }

    @Override
    public int delete(Integer id) {
        return adminRestMapper.delete(id);
    }

    @Override
    public int insert(Rest rest) {
        return adminRestMapper.insert(rest);
    }

    @Override
    public Rest search_id(Integer id) {
        return adminRestMapper.search_id(id);
    }

    @Override
    public boolean login(Rest rest) {
        Rest admin_search = adminRestMapper.login(rest);
        if (admin_search == null){
            return false;
        }
        return rest.getRpassword().equals(admin_search.getRpassword());
    }

    @Override
    public int update(Rest rest) {
        return adminRestMapper.update(rest);
    }

    @Override
    public String pic_url(String sno) {
        return "../img/rphoto/" +adminRestMapper.pic_url(sno);
    }
}
