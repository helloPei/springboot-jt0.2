package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.common.vo.CheckBox;
import com.demo.pojo.Role;
import com.github.pagehelper.PageInfo;

public interface RoleService {

	/** 查询所有角色的id,name字段的值，每行记录封装一个checbox对象 */
	List<CheckBox> findObjects();

	/** 基于角色id查询自身信息以及关联的菜单id */
	Map<String, Object> findObjectById(Integer id);

	int updateObject(Role entity, Integer[] menuIds);

	int saveObject(Role entity, Integer[] menuIds);

	/** 基于id删除角色以及关系数据 */
	int deleteObject(Integer id);

	/** 分页查询角色信息 */
	PageInfo<Role> findPageObjects(String name, Integer pageCurrent);
}