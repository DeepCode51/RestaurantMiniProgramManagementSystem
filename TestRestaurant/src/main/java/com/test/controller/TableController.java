package com.test.controller;

import com.test.obj.Foodtable;
import com.test.obj.Menutype;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/table")
public class TableController {
    @Autowired
    CustService custService;
    @RequestMapping("/table_info")
    public String infoindex(){
        return "rest_table_info";
    }

    @RequestMapping("/table_list")
    @ResponseBody
    public ResultMap<List<Foodtable>> list_rest(Page page, @RequestParam("limit") int limit){
        page.setRows(limit);
        infoindex();
        return custService.table_list(page);
    }
    @RequestMapping("/table_edit")
    public String edit_h(@RequestParam("id") Integer id, Model model){
        Foodtable res = custService.searchtable_id(id);
        model.addAttribute("admin", res);
        return "rest_table_edit";
    }
    @RequestMapping("/table_edit.do")
    @ResponseBody
    public int edit(Foodtable table){//记得加当前时间

        Date date = new Date();
        // TODO 自动生成的方法存根
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        table.setCreatetime(formatter.format(date));
        return custService.update(table);
    }
    @RequestMapping("/table_edit1.do")
    @ResponseBody
    public int edit1(@RequestParam("id") int id,@RequestParam("speci") int speci){//记得加当前时间
        Foodtable table = new Foodtable();
        table.setId(id);
        table.setSpeci(speci);
        table.setNowspeci(0);
        table.setStat("空闲");
        table.setCreatetime("");
        return custService.update1(table);
    }
}
