package com.test.controller;

import com.test.obj.*;
import com.test.service.AdminRestService;
import com.test.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//商家管理/员工
@Controller
@RequestMapping("/rest")
public class RestController {

    @Autowired
    private AdminRestService adminRestService;
    private StaffService staffService;

    public RestController(StaffService staffService) {
        this.staffService = staffService;
    }


    @RequestMapping("/login")
    public String login_index(){
        return "rest_login";
    }
    @RequestMapping("/signout")
    public String login_index1(){
        return "redirect:/rest/login";
    }

    @RequestMapping("/login.do")
    public String login(Rest rest, HttpServletRequest request){
        if(adminRestService.login(rest)){
            request.getSession().setAttribute("raccount", rest.getRaccount());
            return "rest_index";
        }else {
            return "redirect:/rest/login";

        }
    }
    @RequestMapping("/staff_info")
    public String infoindex(){
        return "rest_staff_info";
    }
    @RequestMapping("/staff_list")
    @ResponseBody
    public ResultMap<List<Staff>> list_admin(Page page, @RequestParam("limit")int limit,@RequestParam(value = "search", defaultValue = "")String saccount,HttpServletRequest request){
        page.setRows(limit);
        String raccount= (String) request.getSession().getAttribute("raccount");
        System.out.println(raccount);
        infoindex();
        if (saccount.length()>0){
            return staffService.staff_search(page,raccount,saccount);
        }else {
            return staffService.staff_list(page,raccount);
        }

    }

    @RequestMapping("/staff_delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return staffService.delete(id);
    }
    @RequestMapping("/staff_edit")
    public String edit_h(@RequestParam("id") Integer id, Model model){
        Staff res = staffService.search_id(id);
        model.addAttribute("staff", res);
        return "rest_staff_edit";
    }
    @RequestMapping("/staff_edit.do")
    @ResponseBody
    public int edit(Staff staff){
        return staffService.update(staff);
    }
    @RequestMapping("/staff_insert.do")
    @ResponseBody
    public int insert(Staff staff, HttpServletRequest request){
        String raccount= (String) request.getSession().getAttribute("raccount");
        staff.setRaccount(raccount);
        return staffService.insert(staff);
    }

    @RequestMapping("/staff_insert")
    private String insert_h(){
        return "rest_staff_add";
    }

    //通过部门名称查找员工，虽是员工业务的操作但是用到了部门的操作
    @RequestMapping("/bydepart")
    @ResponseBody
    public ResultMap<List<Staff>> bydepart(@RequestParam("classify") String classyfyId){
        SeriesPage page = new SeriesPage();
        page.setClassify(classyfyId);
        return staffService.staff_depart(page);
    }
}
