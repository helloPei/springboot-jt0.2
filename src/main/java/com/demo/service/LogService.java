package com.demo.service;

import com.demo.pojo.Log;
import com.github.pagehelper.PageInfo;

public interface LogService{
	
	PageInfo<Log> findPageObjects(String username, Integer pageCurrent);
	
}