package com.boanwl.manager.service;

import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbAdmin;

import java.util.List;

/**
 * User: volker
 * Date: 2018/7/24
 * Time: 10:52
 * Version:V1.0
 */
public interface AdminService {
    public ItemDTO<TbAdmin> listAdmins(PageParam param);

    ItemDTO<TbAdmin> listPageAdmins(PageParam param, String searchName);

    ItemDTO<TbAdmin> deletelist(List<String> ids);

    ItemDTO<TbAdmin> addAdmin(TbAdmin admin);

    ItemDTO<TbAdmin> updatepwd(TbAdmin admin);
}
