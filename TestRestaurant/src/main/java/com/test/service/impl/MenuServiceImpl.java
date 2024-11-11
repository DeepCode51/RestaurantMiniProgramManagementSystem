package com.test.service.impl;

import com.test.dao.MenuMapper;
import com.test.obj.*;
import com.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public Menu search_id(Integer id) {
        return menuMapper.search_id(id);
    }

    @Override
    public int delete(Integer id) {
        return menuMapper.delete(id);
    }

    @Override
    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

    @Override
    public int insert(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public ResultMap<List<Menu>> search_name(Page page, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Menu> list = menuMapper.search_name(map);
        ResultMap<List<Menu>> jsonMap = new ResultMap<List<Menu>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Menu>> info_list(Page page) {
        List<Menu> list = menuMapper.info_list(page);
        ResultMap<List<Menu>> jsonMap = new ResultMap<List<Menu>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Menu>> menu_menutype(SeriesPage page) {
        List<Menu> list = menuMapper.menu_menutype(page);
        ResultMap<List<Menu>> jsonMap = new ResultMap<List<Menu>>(0, "success", list);
        return jsonMap;
    }

    @Override
    public String pic_url(String sno) {
        return "../img/mphoto/" + menuMapper.pic_url(sno);
    }

    @Override
    public ResultMap<List<Menu>> getall() {
        List<Menu> list = menuMapper.getall();
        ResultMap<List<Menu>> jsonMap = new ResultMap<List<Menu>>(0, "success", list);
        return jsonMap;
    }
}
