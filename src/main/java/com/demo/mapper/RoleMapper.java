package com.demo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.common.vo.CheckBox;
import com.demo.pojo.Role;

import tk.mybatis.mapper.common.BaseMapper;
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	/**查询所有角色的id,name字段的值，每行记录封装一个checbox对象*/
	List<CheckBox> findObjects();
	/**修改角色自身信息*/
	int updateObject(Role role);
	/**基于角色id查询关系表中角色id对应菜单id*/
	Role findObjectById(Integer id);                                                                                                                                                                 
	//SysRoleMenuResult findObjectById(Integer id);
	/**保存角色自身信息*/
	int insertObject(Role role);
	/** 基于角色id删除角色自身信息*/
	int deleteObject(Integer id); 
}