package com.demo.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

//import com.demo.common.vo.PageObject;
import com.demo.common.exception.ServiceException;
import com.demo.mapper.LogMapper;
import com.demo.pojo.Log;
import com.demo.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("sysLogService")
public class LogServiceImpl implements LogService {
	
	@Autowired
	private LogMapper logMapper;
	
	@Override
	public PageInfo<Log> findPageObjects(String username, Integer pageCurrent) {
		Log log = new Log();
		log.setUsername(username);
        //1.验证参数合法性
		if(pageCurrent == null || pageCurrent < 1)
			throw new ServiceException("参数不合法");
		//2.查询总记录数
		int rowCount = logMapper.selectCount(log);
//		int rowCount = logMapper.getRowCount(username);
		if(rowCount == 0)throw new ServiceException("没有记录");
		//3.查询当前页数据
		List<Log> logList = null;
		if(StringUtils.isEmpty(username)) {
			PageHelper.startPage(pageCurrent, 8, "createdTime desc");
			logList = logMapper.selectAll();
		} else {
			logList = logMapper.select(log);
		}
		return new PageInfo<Log>(logList);
//	    //2.查询当前页记录
//		//2.1定义页面大小(每页最多现实多少条记录)
//		int pageSize = 5;
//		//2.2计算当前页位置
//		int startIndex = (pageCurrent - 1) * pageSize;
//		//2.3查询当前数据
//		List<Log> list = logMapper.findPageObjects(username, startIndex, pageSize);
//		//3.封装数据
//		PageObject<Log> pageObject = new PageObject<>();
//		pageObject.setRecords(list);
//		pageObject.setRowCount(rowCount);
//		pageObject.setPageSize(pageSize);
//		pageObject.setPageCurrent(pageCurrent);
//		return pageObject;
	}
	
}