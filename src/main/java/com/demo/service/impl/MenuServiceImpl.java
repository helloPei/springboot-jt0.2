package com.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.exception.ServiceException;
import com.demo.common.util.ShiroUtils;
import com.demo.common.vo.Node;
import com.demo.mapper.MenuMapper;
import com.demo.mapper.RoleMenuMapper;
import com.demo.pojo.Menu;
import com.demo.pojo.vo.RoleMenus;
import com.demo.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	
	@Override
	public int saveObject(Menu menu) {
		menu.setCreatedUser(ShiroUtils.getPrincipal().getUsername());
		menu.setCreatedTime(new Date());
		//2.将参数持久化到数据库
		int rows = menuMapper.insert(menu);
//		int rows = menuMapper.insertObject(menu);
		if(rows != 1)throw new ServiceException("保存菜单失败");
		return rows;
	}
	
	@Override
	public int deleteObject(Integer id) {
		Menu menu = new Menu();
		menu.setId(id);
		int row = menuMapper.deleteByPrimaryKey(menu);
//		int row = menuMapper.deleteObject(id);
		if(row != 1)throw new ServiceException("删除菜单失败");
		//4.基于菜单id删除菜单与角色的关系数据
		RoleMenus roleMenus = new RoleMenus();
		roleMenus.setMenuId(id);
		roleMenuMapper.delete(roleMenus);
//		int row1 = roleMenuMapper.deleteObjectsByMenuId(id);
//		if(row1 != 1)throw new ServiceException("删除菜单与角色关系失败");
		return row;
	}
	
	@Override
	public int updateObject(Menu menu) {
		menu.setModifiedUser(ShiroUtils.getPrincipal().getUsername());
		menu.setModifiedTime(new Date());
		//2.将参数持久化到数据库
		int rows = menuMapper.updateByPrimaryKeySelective(menu);
//		int rows = menuMapper.updateObject(menu);
		if(rows != 1)throw new ServiceException("修改菜单失败");
		return rows;
	}
	
	@Override
	public int getChildCount(Integer id) {
		int rows = menuMapper.getChildCount(id);
		return rows;
	}
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> list = menuMapper.findObjects();
		if(list == null || list.size() == 0)throw new ServiceException("查询菜单失败");
		return list;
	}
	
	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> list = menuMapper.findZtreeMenuNodes();
		if(list == null || list.size() == 0)throw new ServiceException("查询菜单树节点失败");
		return list;
	}
	
}