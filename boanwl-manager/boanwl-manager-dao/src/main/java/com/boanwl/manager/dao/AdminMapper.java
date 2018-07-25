package com.boanwl.manager.dao;

import com.boanwl.manager.pojo.dto.PageParam;
import com.boanwl.manager.pojo.po.TbAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: volker
 * Date: 2018/7/23
 * Time: 23:27
 * Version:V1.0
 */
public interface AdminMapper {

    long countAdmin();

    List<TbAdmin> listAdmins(PageParam param);

    long countPageAdmin(@Param("searchName") String searchName);

    List<TbAdmin> listPageAdmins(@Param("param") PageParam param, @Param("searchName")String searchName);
}
