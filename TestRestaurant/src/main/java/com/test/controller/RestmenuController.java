package com.test.controller;

import com.test.obj.*;
import com.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//商家管理/菜品
@Controller
@RequestMapping("/menu")
public class RestmenuController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/menu_info")
    public String infoindex(){
        return "rest_menu_info";
    }

    //
    @RequestMapping("/menu_list")
    @ResponseBody
    public ResultMap<List<Menu>> list_rest(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "") String menu){
        page.setRows(limit);
        infoindex();
        if (menu.length()>0){
            return menuService.search_name(page,menu);
        }else {
            return menuService.info_list(page);
        }

    }

    @RequestMapping("/menu_delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return menuService.delete(id);
    }
    @RequestMapping("/menu_edit")
    public String edit_h(@RequestParam("id") Integer id, Model model){
        Menu res = menuService.search_id(id);
        model.addAttribute("menu", res);
        return "rest_menu_edit";
    }
    @RequestMapping("/menu_edit.do")
    @ResponseBody
    public int edit(Menu menu){
        return menuService.update(menu);
    }
    @RequestMapping("/menu_insert.do")
    @ResponseBody
    public int insert(Menu menu){
//        System.out.println(menu.toString());
        return menuService.insert(menu);
    }

    @RequestMapping("/menu_insert")
    private String insert_h(){
        return "rest_menu_add";
    }

    //通过部门名称查找员工，虽是员工业务的操作但是用到了部门的操作
    @RequestMapping("/bymenutype")
    @ResponseBody
    public ResultMap<List<Menu>> bydepart(@RequestParam(value="classify", defaultValue = "") String classyfyId){
        if(classyfyId.length()==0){
            return menuService.getall();
        }else{
            SeriesPage page = new SeriesPage();
            page.setClassify(classyfyId);
            return menuService.menu_menutype(page);
        }

    }
    @RequestMapping("/qcert")
    @ResponseBody
    public String qcert_Url (@RequestParam("sno")String sno){
        System.out.println(menuService.pic_url(sno));
        return menuService.pic_url(sno);
    }

}
