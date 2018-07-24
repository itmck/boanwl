package com.boanwl.manager.service.impl;

import com.boan.comcom.utils.MD5Utils;
import com.boan.comcom.utils.UUIDutil;
import com.boanwl.common.dto.ItemDTO;
import com.boanwl.manager.dao.AdminMapper;
import com.boanwl.manager.dao.TbAdminMapper;
import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbAdmin;
import com.boanwl.manager.pojo.po.TbAdminExample;
import com.boanwl.manager.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: volker
 * Date: 2018/7/23
 * Time: 23:11
 * Version:V1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TbAdminMapper tbAdminMapper;
    @Override
    public ItemDTO<TbAdmin> listAdmins(PageParam param) {
        ItemDTO<TbAdmin> item = new ItemDTO<>();
        item.setCode(0);
        item.setMsg("成功!");
        try {
            item.setCount(adminMapper.countAdmin());
            item.setData(adminMapper.listAdmins(param));
        } catch (Exception e) {
            item.setCode(1);
            item.setMsg("失败!");
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return item;
    }

    @Override
    public ItemDTO<TbAdmin> listPageAdmins(PageParam param, String searchName) {
        ItemDTO<TbAdmin> item = new ItemDTO<>();
        item.setCode(0);
        item.setMsg("成功!");
        try {
            item.setCount(adminMapper.countPageAdmin(searchName));
            item.setData(adminMapper.listPageAdmins(param,searchName));
        } catch (Exception e) {
            item.setCode(1);
            item.setMsg("失败!");
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return item;
    }

    @Override
    public ItemDTO<TbAdmin> deletelist(List<String> ids) {
        ItemDTO<TbAdmin> item = new ItemDTO<>();
        item.setCode(0);
        item.setMsg("成功!");
        try {
            TbAdminExample example = new TbAdminExample();
            example.createCriteria().andIdIn(ids);
            TbAdmin admin = new TbAdmin();
            admin.setStatus(3);
            int result = tbAdminMapper.updateByExampleSelective(admin,example);
        } catch (Exception e) {
            item.setCode(1);
            item.setMsg("失败!");
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return item;
    }

    @Override
    public ItemDTO<TbAdmin> addAdmin(TbAdmin admin) {
        ItemDTO<TbAdmin> item = new ItemDTO<>();
        item.setCode(0);
        item.setMsg("成功!");
        try {

            admin.setId(UUIDutil.getUUID());
            admin.setPwd(MD5Utils.md5(admin.getPwd()));
            admin.setStatus(1);
            int result = tbAdminMapper.insert(admin);
        } catch (Exception e) {
            item.setCode(1);
            item.setMsg("失败!");
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public ItemDTO<TbAdmin> updatepwd(TbAdmin admin) {

        ItemDTO<TbAdmin> item = new ItemDTO<>();
        item.setCode(0);
        item.setMsg("成功!");
        try {

            admin.setPwd(MD5Utils.md5(admin.getPwd()));
            int result = tbAdminMapper.updateByPrimaryKeySelective(admin);
        } catch (Exception e) {
            item.setCode(1);
            item.setMsg("失败!");
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public ItemDTO<TbAdmin> selectById(String id) {
        ItemDTO<TbAdmin> item = new ItemDTO<>();
        item.setCode(0);
        item.setMsg("成功!");
        try {
            TbAdmin admin = tbAdminMapper.selectByPrimaryKey(id);
            List<TbAdmin> admins = new ArrayList<>();
            admins.add(admin);
            item.setData(admins);
        } catch (Exception e) {
            item.setCode(1);
            item.setMsg("失败!");
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return item;
    }

}
