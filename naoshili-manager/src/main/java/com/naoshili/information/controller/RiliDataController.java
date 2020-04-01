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
import com.naoshili.information.domain.RiliDataDO;
import com.naoshili.information.service.RiliDataService;

/**
 * 日立4000数据
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/riliData")
public class RiliDataController {
	@Autowired
	private RiliDataService riliDataService;

	@GetMapping()
	@RequiresPermissions("information:riliData:riliData")
	String RiliData() {
		return "information/riliData/riliData";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:riliData:riliData")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<RiliDataDO> riliDataList = riliDataService.list(query);
		int total = riliDataService.count(query);
		PageUtils pageUtils = new PageUtils(riliDataList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("information:riliData:add")
	String add() {
		return "information/riliData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:riliData:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		RiliDataDO riliData = riliDataService.get(id);
		model.addAttribute("riliData", riliData);
		return "information/riliData/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:riliData:add")
	public R save(RiliDataDO riliData) {
		if (riliDataService.save(riliData) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:riliData:edit")
	public R update(RiliDataDO riliData) {
		riliDataService.update(riliData);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("information:riliData:remove")
	public R remove(Long id) {
		if (riliDataService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:riliData:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		riliDataService.batchRemove(ids);
		return R.ok();
	}

}
