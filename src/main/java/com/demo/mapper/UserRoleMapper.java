package com.demo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.demo.pojo.vo.UserRoles;

import tk.mybatis.mapper.common.BaseMapper;

/**
 * 用户和角色关系对应的Mapper
 * @author Administrator
 *
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoles>{
	/**负责将用户与角色的关系数据写入到数据库*/
	int insertObject(@Param("userId")Integer userId, @Param("roleIds")Integer[] roleIds);
	/**根据用户id获取用户对应的角色id*/
	List<Integer> findRoleIdsByUserId(Integer id);
	/**根据角色id删除用户和角色关系数据*/
	int deleteObjectsByRoleId(Integer roleId);
	/**删除用户和角色关系数据*/
	int deleteObjectsByUserId(Integer userId);
}