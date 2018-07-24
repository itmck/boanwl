package com.boanwl.manager.web;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbAdmin;
import com.boanwl.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: volker
 * Date: 2018/7/24
 * Time: 10:55
 * Version:V1.0
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 直接分页
     * @param param
     * @return
     */
    @GetMapping("/admin/list")
    @ResponseBody
    public ItemDTO<TbAdmin> listItems(PageParam param){
        ItemDTO<TbAdmin> item = adminService.listAdmins(param);
        return item;
    }

    /**
     * 搜索分页
     * @param param
     * @param searchName
     * @return
     */
    @GetMapping("/admin/listPage")
    @ResponseBody
    public ItemDTO<TbAdmin> listPageItems(PageParam param,String searchName){
        ItemDTO<TbAdmin> item = adminService.listPageAdmins(param,searchName);
        return item;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/admin/delete")
    @ResponseBody
    public ItemDTO<TbAdmin> delete(@RequestParam("ids[]") List<String> ids){
        ItemDTO<TbAdmin> item = adminService.deletelist(ids);
        return item;
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping("/admin/add")
    @ResponseBody
    public ItemDTO<TbAdmin> addAdmin(TbAdmin admin){
        ItemDTO<TbAdmin> item = adminService.addAdmin(admin);
        return item;
    }
    @RequestMapping("/admin/chpwd")
    @ResponseBody
    public ItemDTO<TbAdmin> chpwd(TbAdmin admin){
        ItemDTO<TbAdmin> item = adminService.updatepwd(admin);
        return item;
    }

}
