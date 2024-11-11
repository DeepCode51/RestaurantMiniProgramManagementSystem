package com.test.service.impl;

import com.test.dao.StaffMapper;
import com.test.obj.*;
import com.test.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;
    @Override
    public Staff search_id(Integer id) {
        return staffMapper.search_id(id);
    }

    @Override
    public int delete(Integer id) {
        return staffMapper.delete(id);
    }

    @Override
    public int update(Staff staff) {
        return staffMapper.update(staff);
    }

    @Override
    public int insert(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public ResultMap<List<Staff>> staff_list(Page page, String raccount) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("raccount", raccount);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Staff> list = staffMapper.staff_list(map);
        ResultMap<List<Staff>> jsonMap = new ResultMap<List<Staff>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Staff>> staff_search(Page page, String raccount, String saccount) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("raccount", raccount);
        map.put("saccount", saccount);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Staff> list = staffMapper.staff_search(map);
        ResultMap<List<Staff>> jsonMap = new ResultMap<List<Staff>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Staff>> staff_depart(SeriesPage page) {
        List<Staff> list = staffMapper.search_depart(page);
        ResultMap<List<Staff>> jsonMap = new ResultMap<List<Staff>>(0, "success", list);
        return  jsonMap;
    }
}
