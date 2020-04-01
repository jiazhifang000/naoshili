package com.naoshili.information.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 采集数据基本信息
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/DataReport")
public class DataReportController {


	@GetMapping("/list")
	@RequiresPermissions("information:DataReport:DataReport")
	public String datareportlist() {

		return "/information/dataReport/dataReport";
	}

	@GetMapping("/report")
	@RequiresPermissions("information:DataReport:DataReport")
	public String report() {

		return "/information/dataReport/report";
	}
}
