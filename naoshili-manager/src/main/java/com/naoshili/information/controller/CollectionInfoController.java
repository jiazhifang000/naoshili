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
import com.naoshili.information.domain.CollectionInfoDO;
import com.naoshili.information.service.CollectionInfoService;

/**
 * 采集数据基本信息
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/collectionInfo")
public class CollectionInfoController {
	@Autowired
	private CollectionInfoService collectionInfoService;

	@GetMapping()
	@RequiresPermissions("information:collectionInfo:collectionInfo")
	String CollectionInfo() {
		return "information/collectionInfo/collectionInfo";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:collectionInfo:collectionInfo")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<CollectionInfoDO> collectionInfoList = collectionInfoService.list(query);
		int total = collectionInfoService.count(query);
		PageUtils pageUtils = new PageUtils(collectionInfoList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("information:collectionInfo:add")
	String add() {
		return "information/collectionInfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:collectionInfo:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		CollectionInfoDO collectionInfo = collectionInfoService.get(id);
		model.addAttribute("collectionInfo", collectionInfo);
		return "information/collectionInfo/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:collectionInfo:add")
	public R save(CollectionInfoDO collectionInfo) {
		if (collectionInfoService.save(collectionInfo) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:collectionInfo:edit")
	public R update(CollectionInfoDO collectionInfo) {
		collectionInfoService.update(collectionInfo);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("information:collectionInfo:remove")
	public R remove(Long id) {
		if (collectionInfoService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:collectionInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		collectionInfoService.batchRemove(ids);
		return R.ok();
	}

}
