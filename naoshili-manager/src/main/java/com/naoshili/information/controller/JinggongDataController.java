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
import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.service.JinggongDataService;

/**
 * 精工5500数据表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/jinggongData")
public class JinggongDataController {
	@Autowired
	private JinggongDataService jinggongDataService;

	@GetMapping()
	@RequiresPermissions("information:jinggongData:jinggongData")
	String JinggongData() {
		return "information/jinggongData/jinggongData";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:jinggongData:jinggongData")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<JinggongDataDO> jinggongDataList = jinggongDataService.list(query);
		int total = jinggongDataService.count(query);
		PageUtils pageUtils = new PageUtils(jinggongDataList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("information:jinggongData:add")
	String add() {
		return "information/jinggongData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:jinggongData:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		JinggongDataDO jinggongData = jinggongDataService.get(id);
		model.addAttribute("jinggongData", jinggongData);
		return "information/jinggongData/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:jinggongData:add")
	public R save(JinggongDataDO jinggongData) {
		if (jinggongDataService.save(jinggongData) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:jinggongData:edit")
	public R update(JinggongDataDO jinggongData) {
		jinggongDataService.update(jinggongData);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("information:jinggongData:remove")
	public R remove(Long id) {
		if (jinggongDataService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:jinggongData:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		jinggongDataService.batchRemove(ids);
		return R.ok();
	}

}
