package com.test.service;



import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.SeriesPage;
import com.test.obj.Staff;

import java.util.List;

public interface StaffService {
    //常规增删改
    Staff search_id(Integer id);

    int delete(Integer id);

    int update(Staff staff);

    int insert(Staff staff);
    //罗列该店的员工信息
    ResultMap<List<Staff>>staff_list(Page page, String raccount);
    //在该店员工的基础上查找指定员工
    ResultMap<List<Staff>>staff_search(Page page, String raccount,String saccount);
    //通过部门查找员工
    ResultMap<List<Staff>> staff_depart(SeriesPage page);
}
