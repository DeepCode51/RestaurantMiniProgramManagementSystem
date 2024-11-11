package com.test.controller;

import com.test.obj.Admin;
import com.test.obj.Page;
import com.test.obj.Rest;
import com.test.obj.ResultMap;
import com.test.service.AdminRestService;
import com.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/rest")
public class AdminrestController {
    @Autowired
    private AdminRestService adminrestService;

    @RequestMapping("")
    public String rest_index(){
        return "admin_rest_info";
    }

    @RequestMapping("/admin_rest_list")
    @ResponseBody
    public ResultMap<List<Rest>> list_rest(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "") String rname){
        page.setRows(limit);
        rest_index();
        if (rname.length()>0){
            return adminrestService.search_rname(page, rname);
        }else {
            return adminrestService.admin_rest_list(page);
        }

    }

    @RequestMapping("/admin_rest_delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return adminrestService.delete(id);
    }

    @RequestMapping("/admin_rest_insert.do")
    @ResponseBody
    public int insert(Rest rest){
        return adminrestService.insert(rest);
    }

    @RequestMapping("/admin_rest_insert")
    private String insert_h(){
        return "admin_rest_add";
    }

    @RequestMapping("/admin_rest_edit")
    public String admin_rest_edit_h(@RequestParam("id") Integer id, Model model){
        Rest res = adminrestService.search_id(id);
        model.addAttribute("rest", res);
        return "admin_rest_edit";
    }
    @RequestMapping("/admin_rest_edit.do")
    @ResponseBody
    public int series_edit(Rest rest){
        return adminrestService.update(rest);
    }

    @RequestMapping("/qcert")
    @ResponseBody
    public String qcert_Url (@RequestParam("sno")String sno){
        System.out.println(adminrestService.pic_url(sno));
        return adminrestService.pic_url(sno);
    }
}
