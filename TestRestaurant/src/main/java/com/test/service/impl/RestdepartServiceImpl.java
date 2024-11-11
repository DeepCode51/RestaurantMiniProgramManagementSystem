package com.test.service.impl;

import com.test.dao.RestdepartMapper;
import com.test.obj.*;
import com.test.service.RestdepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RestdepartServiceImpl implements RestdepartService {
    @Autowired
    RestdepartMapper restdepartMapper;
    @Override
    public List<Depart> getdepart() {
        return restdepartMapper.getdepart();
    }

    @Override
    public Depart search_id(Integer id) {
        return restdepartMapper.search_id(id);
    }

    @Override
    public int delete(Integer id) {
        return restdepartMapper.delete(id);
    }

    @Override
    public int update(Depart depart) {
        return restdepartMapper.update(depart);
    }

    @Override
    public int insert(Depart depart) {
        return restdepartMapper.insert(depart);
    }

    @Override
    public ResultMap<List<Depart>> search_name(Page page, String sdepart) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sdepart", sdepart);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Depart> list = restdepartMapper.search_name(map);
        ResultMap<List<Depart>> jsonMap = new ResultMap<List<Depart>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Depart>> info_list(Page page) {
        List<Depart> list = restdepartMapper.info_list(page);
        ResultMap<List<Depart>> jsonMap = new ResultMap<List<Depart>>(0, "success", list);
        return  jsonMap;
    }
}
