package com.test.controller;

import com.test.obj.Admin;

import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login_index(){
        return "login";
    }
    @RequestMapping("/signout")
    public String login_index1(){
        return "redirect:/admin/login";
    }

    @RequestMapping("/login.do")
    public String login(String adminname, String password){
        Admin admin = new Admin();
        admin.setAccount(adminname);
        admin.setPassword(password);
        if(adminService.login(admin)){
            return "admin_index";
        }else {
            return "redirect:/admin/login";
        }
    }
    @RequestMapping("/admininfo")
    public String adminindex(){
        return "admin_info";
    }
    @RequestMapping("/admin_list")
    @ResponseBody
//    public List<Admin> getadmin() {
//        return adminService.getlist();
//    }

    public ResultMap<List<Admin>> list_admin(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "") String account){
        page.setRows(limit);
        adminindex();
        if (account.length()>0){
            return adminService.search_sname(page, account);
        }else {
            return adminService.admin_list(page);
        }

    }

    @RequestMapping("/admin_delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return adminService.delete(id);
    }
    @RequestMapping("/admin_edit")
    public String admin_edit_h(@RequestParam("id") Integer id, Model model){
        Admin res = adminService.search_id(id);
        model.addAttribute("admin", res);
        return "admin_edit";
    }
    @RequestMapping("/admin_edit.do")
    @ResponseBody
    public int series_edit(Admin admin){
        return adminService.update(admin);
    }
    @RequestMapping("/admin_insert.do")
    @ResponseBody
    public int insert(Admin admin){
        return adminService.insert(admin);
    }

    @RequestMapping("/admin_insert")
    private String insert_h(){
        return "admin_add";
    }

}
