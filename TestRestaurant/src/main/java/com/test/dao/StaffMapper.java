package com.test.dao;

import com.test.obj.Rest;
import com.test.obj.SeriesPage;
import com.test.obj.Staff;

import java.util.List;
import java.util.Map;

public interface StaffMapper {
    Staff search_id(Integer id);
    int delete(int id);
    int update(Staff staff);
    int insert(Staff staff);
    List<Staff> staff_list(Map<String, Object> map);
    List<Staff> staff_search(Map<String, Object> map);
    List<Staff> search_depart(SeriesPage page);
}
