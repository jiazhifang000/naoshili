package com.naoshili.information.controller;

import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.UserEyeDataDO;
import com.naoshili.information.service.UserBasicService;
import com.naoshili.information.service.UserEyeDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户眼部数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/userEyeData")
public class UserEyeDataController {
    @Autowired
    private UserEyeDataService userEyeDataService;

    @Autowired
    private UserBasicService userBasicService;

    @GetMapping("/eyelist/{id}")
    @RequiresPermissions("information:userEyeData:userEyeData")
    String UserEyeData(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "information/userEyeData/userEyeData";
    }

    @ResponseBody
    @GetMapping("/list")

    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<UserEyeDataDO> userEyeDataList = userEyeDataService.list(query);
        for (UserEyeDataDO userEyeDataDO : userEyeDataList) {
            userEyeDataDO.setUname(userBasicService.getUserId(userEyeDataDO.getUid()).getName());
        }
        int total = userEyeDataService.count(query);
        PageUtils pageUtils = new PageUtils(userEyeDataList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:userEyeData:add")
    String add() {
        return "information/userEyeData/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:userEyeData:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        UserEyeDataDO userEyeData = userEyeDataService.get(id);
        userEyeData.setUname(userBasicService.getUserId(userEyeData.getUid()).getName());
        model.addAttribute("userEyeData", userEyeData);
        return "information/userEyeData/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:userEyeData:add")
    public R save(UserEyeDataDO userEyeData) {
        if (userEyeDataService.save(userEyeData) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:userEyeData:edit")
    public R update(UserEyeDataDO userEyeData) {
        userEyeDataService.update(userEyeData);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:userEyeData:remove")
    public R remove(Long id) {
        if (userEyeDataService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:userEyeData:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        userEyeDataService.batchRemove(ids);
        return R.ok();
    }

}
