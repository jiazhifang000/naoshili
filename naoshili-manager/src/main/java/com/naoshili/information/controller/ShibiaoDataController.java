package com.naoshili.information.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.ShibiaoDataDO;
import com.naoshili.information.service.ShibiaoDataService;

/**
 * 视标数据表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/shibiaoData")
public class ShibiaoDataController {
	@Autowired
	private ShibiaoDataService shibiaoDataService;

	@GetMapping()
	@RequiresPermissions("information:shibiaoData:shibiaoData")
	String ShibiaoData() {
		return "information/shibiaoData/shibiaoData";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:shibiaoData:shibiaoData")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ShibiaoDataDO> shibiaoDataList = shibiaoDataService.list(query);
		int total = shibiaoDataService.count(query);
		PageUtils pageUtils = new PageUtils(shibiaoDataList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("information:shibiaoData:add")
	String add() {
		return "information/shibiaoData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:shibiaoData:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		ShibiaoDataDO shibiaoData = shibiaoDataService.get(id);
		model.addAttribute("shibiaoData", shibiaoData);
		return "information/shibiaoData/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:shibiaoData:add")
	public R save(ShibiaoDataDO shibiaoData) {
		if (shibiaoDataService.save(shibiaoData) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:shibiaoData:edit")
	public R update(ShibiaoDataDO shibiaoData) {
		shibiaoDataService.update(shibiaoData);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("information:shibiaoData:remove")
	public R remove(Long id) {
		if (shibiaoDataService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:shibiaoData:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		shibiaoDataService.batchRemove(ids);
		return R.ok();
	}

}
