package com.test.controller;

import com.test.obj.Menutype;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.service.MenutypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menutype")
public class RestmenutypeController {
    @Autowired
    MenutypeService menutypeService;
    //页面初加载
    @RequestMapping("/menutype_info")
    public String infoindex(){
        return "rest_menutype_info";
    }

    //
    @RequestMapping("/menutype_list")
    @ResponseBody
    public ResultMap<List<Menutype>> list_rest(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "") String menutype){
        page.setRows(limit);
        infoindex();
        if (menutype.length()>0){
            return menutypeService.search_name(page,menutype);
        }else {
            return menutypeService.info_list(page);
        }

    }

    @RequestMapping("/menutype_delete")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return menutypeService.delete(id);
    }
    @RequestMapping("/menutype_edit")
    public String edit_h(@RequestParam("id") Integer id, Model model){
        Menutype res = menutypeService.search_id(id);
        model.addAttribute("admin", res);
        return "rest_menutype_edit";
    }
    @RequestMapping("/menutype_edit.do")
    @ResponseBody
    public int edit(Menutype menutype){
        return menutypeService.update(menutype);
    }
    @RequestMapping("/menutype_insert.do")
    @ResponseBody
    public int insert(Menutype menutype){
        return menutypeService.insert(menutype);
    }

    @RequestMapping("/menutype_insert")
    private String insert_h(){
        return "rest_menutype_add";
    }






    //简单的罗列所有的部门，不做分页处理
    @RequestMapping("/getmenutype")
    @ResponseBody
    public List<Menutype> getmenutype(){
        return menutypeService.getmenutype();
    }
}
