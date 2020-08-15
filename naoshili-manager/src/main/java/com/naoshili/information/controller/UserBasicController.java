package com.naoshili.information.controller;

import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.*;
import com.naoshili.information.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户基本数据表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/userBasic")
public class UserBasicController {
	@Autowired
	private UserBasicService userBasicService;
	@Autowired
	private UserEyeDataService userEyeDataService;
	@Autowired
	private JinggongDataService jinggongDataService;
	@Autowired
	private RiliDataService riliDataService;
	@Autowired
	private ShibiaoDataService shibiaoDataService;
	@Autowired
	private CollectionInfoService collectionInfoService;
	@Autowired
	HttpSession session;

	@GetMapping()
	@RequiresPermissions("information:userBasic:userBasic")
	String UserBasic() {
		return "information/userBasic/userBasic";
	}

	@GetMapping("/AllUser")
	@RequiresPermissions("information:userBasic:AllUser")
	String AllUser() {
		return "information/userBasic/AllUser";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:userBasic:userBasic")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<UserBasicDO> userBasicList = userBasicService.list(query);

		int total = userBasicService.count(query);
		PageUtils pageUtils = new PageUtils(userBasicList, total);
		return pageUtils;
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !userBasicService.exit(params);
	}

	@GetMapping("/add")
	@RequiresPermissions("information:userBasic:add")
	String add() {
		return "information/userBasic/add";
	}

	@GetMapping("/importtemplate")
	String importtemplate() {
		return "information/userBasic/importtemplate";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:userBasic:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		UserBasicDO userBasic = userBasicService.get(id);
		model.addAttribute("userBasic", userBasic);
		return "information/userBasic/edit";
	}



	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:userBasic:add")
	public R save(UserBasicDO userBasic) {
		UserBasicDO userBasicDO = userBasicService.getUserId(userBasic.getUserId());
		if(userBasicDO!=null){
			return R.error("userId已存在");
		}
		System.out.println("====userBasic=============" + userBasic);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		UserEyeDataDO userEyeDataDO = new UserEyeDataDO();
		// 15位需要补年份
		if (userBasic.getIdCard().length() == 15) {
			userBasic.setBirthday(substringBir("19" + userBasic.getIdCard().substring(6, 12)));
			userBasic.setAge(Integer.parseInt(sdf.format(new Date()))
					- (substringAge("19" + userBasic.getIdCard().substring(6, 12))));
			// 18位直接截取7到14位
		} else if (userBasic.getIdCard().length() == 18) {
			userBasic.setBirthday(substringBir(userBasic.getIdCard().substring(6, 14)));
			userBasic.setAge(
					Integer.parseInt(sdf.format(new Date())) - (substringAge(userBasic.getIdCard().substring(6, 14))));
		}

		if (userBasicService.save(userBasic) > 0) {
			userEyeDataDO.setUid(userBasic.getUserId());
			userEyeDataDO.setGlassToCornea(userBasic.getGlassToCornea1());
			userEyeDataDO.setGlassDiopter(userBasic.getGlassDiopter1());
			userEyeDataDO.setLEyeballDiameter(userBasic.getlEyeballDiameter1());
			userEyeDataDO.setREyeballDiameter(userBasic.getrEyeballDiameter1());
			userEyeDataDO.setLEyepillarDiameter(userBasic.getlEyepillarDiameter1());
			userEyeDataDO.setREyepillarDiameter(userBasic.getrEyepillarDiameter1());
			userEyeDataDO.setLEyeAxis(userBasic.getlEyeAxis1());
			userEyeDataDO.setREyeAxis(userBasic.getlEyeAxis1());
			userEyeDataDO.setLEyeOptometry(userBasic.getlEyeOptometry1());
			userEyeDataDO.setREyeOptometry(userBasic.getrEyeOptometry1());
			userEyeDataDO.setLEyeNakedVision(userBasic.getlEyeNakedVision1());
			userEyeDataDO.setREyeNakedVision(userBasic.getrEyeNakedVision1());
			userEyeDataDO.setLEyeGlassesVision(userBasic.getlEyeGlassesVision1());
			userEyeDataDO.setREyeGlassesVision(userBasic.getrEyeGlassesVision1());

			if (userEyeDataService.save(userEyeDataDO) > 0) {
				return R.ok();
			}
		}
		return R.error();
	}

	public String substringBir(String day) {
		String yyyy = day.substring(0, 4);
		String mm = day.substring(4, 6);
		String dd = day.substring(6);
		return yyyy + '-' + mm + '-' + dd;
	}

	public Integer substringAge(String day) {
		Integer yyyy = Integer.parseInt(day.substring(0, 4));
		return yyyy;
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:userBasic:edit")
	public R update(UserBasicDO userBasic) {
		userBasicService.update(userBasic);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("information:userBasic:remove")
	public R remove(Long id) {
		if (userBasicService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:userBasic:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		userBasicService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 批量导入会员
	 * */
	@ResponseBody
	@PostMapping("/importMember")
	public R importUser(MultipartFile file){
		return userBasicService.importUser(file);
	}


	@GetMapping("/detail/{id}")
	String detail(@PathVariable("id") Long id, Model model) {
		UserBasicDO userBasic = userBasicService.getUserId(id);

		session.setAttribute("id",id);
		model.addAttribute("id", id);
		//model.addAttribute("idCard", userBasic.getIdCard());
		return "information/userBasic/detail";
	}

	@GetMapping("/allData/{id}")
	String allData(@PathVariable("id") Long id, Model model) {
		System.out.println("========id============="+id);
		Map<String,Object> params = new HashMap<>();
		UserBasicDO userBasic = userBasicService.getUserId(Long.parseLong(session.getAttribute("id").toString()));
		//UserBasicDO userBasic = userBasicService.get(60L);
		System.out.println("========userBasic============="+userBasic);
		params.put("uid",Long.parseLong(session.getAttribute("id").toString()));
		//params.put("userId",60);
		List<UserEyeDataDO> userEyeDataDOList = userEyeDataService.list(params);

		params.remove("uid");
		params.put("dataId",id);
		List<JinggongDataDO> jinggongDataDOList = jinggongDataService.list(params);
		List<RiliDataDO> riliDataDOList  = riliDataService.list(params);
		List<ShibiaoDataDO> shibiaoDataDOList = shibiaoDataService.list(params);

		model.addAttribute("dataId",id);
		model.addAttribute("userBasic",userBasic);
		model.addAttribute("userEyeDataDO",userEyeDataDOList.get(0));
		model.addAttribute("jinggongDataDOList",jinggongDataDOList);
		model.addAttribute("riliDataDOList",riliDataDOList);
		model.addAttribute("shibiaoDataDOList",shibiaoDataDOList);

		return "information/userBasic/allData";
	}


}
