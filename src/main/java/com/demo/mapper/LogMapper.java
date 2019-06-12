package com.demo.mapper;

//import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;

import com.demo.pojo.Log;

import tk.mybatis.mapper.common.BaseMapper;
@Mapper
public interface LogMapper extends BaseMapper<Log> {
	
//	int getRowCount(@Param("username")String username);
	
//    List<Log> findPageObjects(
//    		@Param("username")String username,
//    		@Param("startIndex")Integer startIndex,
//    		@Param("pageSize")Integer pageSize
//    );
	
//	int insertObject(Log entity);
	
}