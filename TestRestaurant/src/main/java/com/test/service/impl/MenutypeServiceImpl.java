package com.test.service.impl;

import com.test.dao.MenuMapper;
import com.test.dao.MenutypeMapper;
import com.test.dao.RestdepartMapper;
import com.test.obj.*;
import com.test.service.MenuService;
import com.test.service.MenutypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MenutypeServiceImpl implements MenutypeService {
    @Autowired
    MenutypeMapper menutypeMapper;

    @Override
    public List<Menutype> getmenutype() {
        return menutypeMapper.getmenutype();
    }

    @Override
    public Menutype search_id(Integer id) {
        return menutypeMapper.search_id(id);
    }

    @Override
    public int delete(Integer id) {
        return menutypeMapper.delete(id);
    }

    @Override
    public int update(Menutype menutype) {
        return menutypeMapper.update(menutype);
    }

    @Override
    public int insert(Menutype menutype) {
        return menutypeMapper.insert(menutype);
    }

    @Override
    public ResultMap<List<Menutype>> search_name(Page page, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("menutype", name);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Menutype> list =menutypeMapper.search_name(map);
        ResultMap<List<Menutype>> jsonMap = new ResultMap<List<Menutype>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Menutype>> info_list(Page page) {
        List<Menutype> list =menutypeMapper.info_list(page);
        ResultMap<List<Menutype>> jsonMap = new ResultMap<List<Menutype>>(0, "success", list);
        return  jsonMap;
    }
}
