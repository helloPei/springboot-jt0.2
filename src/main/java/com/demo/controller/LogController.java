package com.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.vo.JsonResult;
import com.demo.pojo.Log;
import com.demo.service.LogService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/log/")
@RequiresPermissions("log")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	/**日志页面*/
	@RequestMapping("doLogListUI")
	public String listUI() {
		return "sys/log_list";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent) {
		PageInfo<Log> logPage = logService.findPageObjects(username, pageCurrent);
		return new JsonResult(logPage);
	}
	
}