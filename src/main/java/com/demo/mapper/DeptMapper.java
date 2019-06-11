package com.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.springframework.data.repository.query.Param;

import com.demo.common.vo.Node;
import com.demo.pojo.Dept;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
	
//	/**添加部门*/
//	int insertObject(Dept dept);
	
//	/**修改部门*/
//	int updateObject(Dept dept);
	
//	/**删除部门*/
//	int deleteObject(Integer id);
	
	/**查询所有部门信息*/
	List<Map<String,Object>> findObjects();
	
	/**查询部门树节点*/
	@Select("select id, name, parentId from sys_depts")
	List<Node> findZTreeNodes();
	
	/**查询部门是否有子部门*/
	@Select("select count(*) from sys_depts where parentId = #{id}")
	int getChildCount(@Param("id")Integer id);
	
}