package com.test.controller;

import com.test.obj.*;
import com.test.service.RestdepartService;
import com.test.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//商家管理/部门
@Controller
@RequestMapping("/depart")
public class RestdepartController {
    @Autowired
    RestdepartService restdepartService;
    //页面初加载
    @RequestMapping("/depart_info")
    public String infoindex(){
        return "rest_depart_info";
    }

    //
    @RequestMapping("/depart_list")
    @ResponseBody
    public ResultMap<List<Depart>> list_rest(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "") String sdepart){
        page.setRows(limit);
        infoindex();
        if (sdepart.length()>0){
            return restdepartService.search_name(page,sdepart);
        }else {
            return restdepartService.info_list(page);
        }

    }

    @RequestMapping("/depart_delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return restdepartService.delete(id);
    }
    @RequestMapping("/depart_edit")
    public String edit_h(@RequestParam("id") Integer id, Model model){
       Depart res = restdepartService.search_id(id);
        model.addAttribute("admin", res);
        return "rest_depart_edit";
    }
    @RequestMapping("/depart_edit.do")
    @ResponseBody
    public int edit(Depart depart){
        return restdepartService.update(depart);
    }
    @RequestMapping("/depart_insert.do")
    @ResponseBody
    public int insert(Depart depart){
        return restdepartService.insert(depart);
    }

    @RequestMapping("/depart_insert")
    private String insert_h(){
        return "rest_depart_add";
    }






    //简单的罗列所有的部门，不做分页处理
    @RequestMapping("/getdepart")
    @ResponseBody
    public List<Depart> getdepart(){
        return restdepartService.getdepart();
    }

}
