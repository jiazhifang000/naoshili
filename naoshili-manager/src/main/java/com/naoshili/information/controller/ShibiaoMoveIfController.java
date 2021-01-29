package com.naoshili.information.controller;

import com.alibaba.fastjson.JSON;
import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.CollectionInfoDO;
import com.naoshili.information.domain.ShibiaoLocaltionJsonDO;
import com.naoshili.information.domain.ShibiaoMoveIfDO;
import com.naoshili.information.service.CollectionInfoService;
import com.naoshili.information.service.ShibiaoMoveIfService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 移动视标实验条件表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-09-23 16:25:44
 */

@Controller
@RequestMapping("/information/shibiaoMoveIf")
public class ShibiaoMoveIfController {
    @Autowired
    private ShibiaoMoveIfService shibiaoMoveIfService;
    @Autowired
    private CollectionInfoService collectionInfoService;

    @GetMapping("/page/{id}")
    @RequiresPermissions("information:shibiaoMoveIf:shibiaoMoveIf")
    String ShibiaoMoveIf(@PathVariable("id") String id, Model model) {
        //获取实验方式
        CollectionInfoDO collectionInfoDO = collectionInfoService.get(Long.parseLong(id));
        //x轴
        List<Double> x = new LinkedList<Double>();
        Double xcount = 0.0;
        //y轴
        List<Integer> y = new LinkedList<Integer>();
        Map<String, Object> params = new HashMap<>();
        params.put("dataId", id);
        List<ShibiaoMoveIfDO> shibiaoMoveIfList = shibiaoMoveIfService.list(params);
        if (shibiaoMoveIfList.size() > 0) {
            for (ShibiaoMoveIfDO shibiaoMoveIfDO : shibiaoMoveIfList) {
                if (shibiaoMoveIfDO.getLocationInfo() != null) {
                    ShibiaoLocaltionJsonDO shibiaoLocaltionJsonDO = JSON.parseObject(shibiaoMoveIfDO.getLocationInfo(), ShibiaoLocaltionJsonDO.class);

                    shibiaoMoveIfDO.setPreliminaryAcquisitionTime(shibiaoLocaltionJsonDO.getPreliminaryAcquisitionTime());
                    shibiaoMoveIfDO.setLocationStart(shibiaoLocaltionJsonDO.getLocationStart());
                    shibiaoMoveIfDO.setCollectTimeStart(shibiaoLocaltionJsonDO.getCollectTimeStart());
                    shibiaoMoveIfDO.setSleepStart(shibiaoLocaltionJsonDO.getSleepStart());


                    shibiaoMoveIfDO.setLocation2(shibiaoLocaltionJsonDO.getLocation2());
                    shibiaoMoveIfDO.setCollectTime2(shibiaoLocaltionJsonDO.getCollectTime2());
                    shibiaoMoveIfDO.setSleep2(shibiaoLocaltionJsonDO.getSleep2());

                    shibiaoMoveIfDO.setLocation3(shibiaoLocaltionJsonDO.getLocation3());
                    shibiaoMoveIfDO.setCollectTime3(shibiaoLocaltionJsonDO.getCollectTime3());
                    shibiaoMoveIfDO.setSleep3(shibiaoLocaltionJsonDO.getSleep3());

                    shibiaoMoveIfDO.setLocation4(shibiaoLocaltionJsonDO.getLocation4());
                    shibiaoMoveIfDO.setCollectTime4(shibiaoLocaltionJsonDO.getCollectTime4());
                    shibiaoMoveIfDO.setSleep4(shibiaoLocaltionJsonDO.getSleep4());

                    shibiaoMoveIfDO.setLocationEnd(shibiaoLocaltionJsonDO.getLocationEnd());
                    shibiaoMoveIfDO.setCollectTimeEnd(shibiaoLocaltionJsonDO.getCollectTimeEnd());
                    shibiaoMoveIfDO.setSleepEnd(shibiaoLocaltionJsonDO.getSleepEnd());
                }
            }

            //多段视标实验
            if (collectionInfoDO.getExperimentalMode() == 1) {
                for (int i = 0; i < shibiaoMoveIfList.size(); i++) {
                    if (i == 0) {
                        //第一次时预采集开始
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //预采集时间
                        xcount += shibiaoMoveIfList.get(i).getPreliminaryAcquisitionTime();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //采集时间
                        xcount += shibiaoMoveIfList.get(i).getCollectTimeStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //休息时间
                        xcount += shibiaoMoveIfList.get(i).getSleepStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                    } else {
                        xcount += Math.abs(shibiaoMoveIfList.get(i - 1).getLocationEnd() - shibiaoMoveIfList.get(i).getLocationStart()) / shibiaoMoveIfList.get(i).getSpeed();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //采集时间
                        xcount += shibiaoMoveIfList.get(i).getCollectTimeStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //休息时间
                        xcount += shibiaoMoveIfList.get(i).getSleepStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());
                    }
                    //下一个位置
                    //计算时间
                    xcount += Math.abs(shibiaoMoveIfList.get(i).getLocationStart() - shibiaoMoveIfList.get(i).getLocation2()) / shibiaoMoveIfList.get(i).getSpeed();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation2());

                    //第二次采集
                    xcount += shibiaoMoveIfList.get(i).getCollectTime2();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation2());

                    //第二次休息
                    xcount += shibiaoMoveIfList.get(i).getSleep2();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation2());

                    //第三次时间
                    xcount += Math.abs(shibiaoMoveIfList.get(i).getLocation2() - shibiaoMoveIfList.get(i).getLocation3()) / shibiaoMoveIfList.get(i).getSpeed();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation3());

                    //第三次采集
                    xcount += shibiaoMoveIfList.get(i).getCollectTime3();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation3());

                    //第三次休息
                    xcount += shibiaoMoveIfList.get(i).getSleep3();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation3());

                    //第四次时间
                    xcount += Math.abs(shibiaoMoveIfList.get(i).getLocation3() - shibiaoMoveIfList.get(i).getLocation4()) / shibiaoMoveIfList.get(i).getSpeed();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation4());

                    //第四次采集
                    xcount += shibiaoMoveIfList.get(i).getCollectTime4();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation4());

                    //第四次休息
                    xcount += shibiaoMoveIfList.get(i).getSleep4();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocation4());

                    //第五次时间
                    xcount += Math.abs(shibiaoMoveIfList.get(i).getLocation4() - shibiaoMoveIfList.get(i).getLocationEnd()) / shibiaoMoveIfList.get(i).getSpeed();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocationEnd());

                    //第五次采集
                    xcount += shibiaoMoveIfList.get(i).getCollectTimeEnd();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocationEnd());

                    //第五次休息
                    xcount += shibiaoMoveIfList.get(i).getSleepEnd();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocationEnd());
                }
            } else {
                for (int i = 0; i < shibiaoMoveIfList.size(); i++) {
                    if (i == 0) {
                        //开始预采集开始
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //预采集时间
                        xcount += shibiaoMoveIfList.get(i).getPreliminaryAcquisitionTime();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //采集时间
                        xcount += shibiaoMoveIfList.get(i).getCollectTimeStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //休息时间
                        xcount += shibiaoMoveIfList.get(i).getSleepStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                    } else {
                        xcount += Math.abs(shibiaoMoveIfList.get(i - 1).getLocationEnd() - shibiaoMoveIfList.get(i).getLocationStart()) / shibiaoMoveIfList.get(i).getSpeed();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //采集时间
                        xcount += shibiaoMoveIfList.get(i).getCollectTimeStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());

                        //休息时间
                        xcount += shibiaoMoveIfList.get(i).getSleepStart();
                        x.add(xcount);
                        y.add(shibiaoMoveIfList.get(i).getLocationStart());
                    }


                    //结束时间
                    xcount += Math.abs(shibiaoMoveIfList.get(i).getLocationStart() - shibiaoMoveIfList.get(i).getLocationEnd()) / shibiaoMoveIfList.get(i).getSpeed();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocationEnd());

                    //结束采集
                    xcount += shibiaoMoveIfList.get(i).getCollectTimeEnd();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocationEnd());

                    //结束休息
                    xcount += shibiaoMoveIfList.get(i).getSleepEnd();
                    x.add(xcount);
                    y.add(shibiaoMoveIfList.get(i).getLocationEnd());
                }
            }
        }
        model.addAttribute("x", x);
        model.addAttribute("y", y);

        model.addAttribute("id", id);
        return "information/shibiaoMoveIf/shibiaoMoveIf";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:shibiaoMoveIf:shibiaoMoveIf")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ShibiaoMoveIfDO> shibiaoMoveIfList = shibiaoMoveIfService.list(query);
        for (ShibiaoMoveIfDO shibiaoMoveIfDO : shibiaoMoveIfList) {
            if (shibiaoMoveIfDO.getLocationInfo() != null) {
                ShibiaoLocaltionJsonDO shibiaoLocaltionJsonDO = JSON.parseObject(shibiaoMoveIfDO.getLocationInfo(), ShibiaoLocaltionJsonDO.class);

                shibiaoMoveIfDO.setPreliminaryAcquisitionTime(shibiaoLocaltionJsonDO.getPreliminaryAcquisitionTime());
                shibiaoMoveIfDO.setLocationStart(shibiaoLocaltionJsonDO.getLocationStart());
                shibiaoMoveIfDO.setCollectTimeStart(shibiaoLocaltionJsonDO.getCollectTimeStart());
                shibiaoMoveIfDO.setSleepStart(shibiaoLocaltionJsonDO.getSleepStart());


                shibiaoMoveIfDO.setLocation2(shibiaoLocaltionJsonDO.getLocation2());
                shibiaoMoveIfDO.setCollectTime2(shibiaoLocaltionJsonDO.getCollectTime2());
                shibiaoMoveIfDO.setSleep2(shibiaoLocaltionJsonDO.getSleep2());

                shibiaoMoveIfDO.setLocation3(shibiaoLocaltionJsonDO.getLocation3());
                shibiaoMoveIfDO.setCollectTime3(shibiaoLocaltionJsonDO.getCollectTime3());
                shibiaoMoveIfDO.setSleep3(shibiaoLocaltionJsonDO.getSleep3());

                shibiaoMoveIfDO.setLocation4(shibiaoLocaltionJsonDO.getLocation4());
                shibiaoMoveIfDO.setCollectTime4(shibiaoLocaltionJsonDO.getCollectTime4());
                shibiaoMoveIfDO.setSleep4(shibiaoLocaltionJsonDO.getSleep4());

                shibiaoMoveIfDO.setLocationEnd(shibiaoLocaltionJsonDO.getLocationEnd());
                shibiaoMoveIfDO.setCollectTimeEnd(shibiaoLocaltionJsonDO.getCollectTimeEnd());
                shibiaoMoveIfDO.setSleepEnd(shibiaoLocaltionJsonDO.getSleepEnd());
            }
        }
        int total = shibiaoMoveIfService.count(query);
        PageUtils pageUtils = new PageUtils(shibiaoMoveIfList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:shibiaoMoveIf:add")
    String add() {
        return "information/shibiaoMoveIf/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:shibiaoMoveIf:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        ShibiaoMoveIfDO shibiaoMoveIf = shibiaoMoveIfService.get(id);
        model.addAttribute("shibiaoMoveIf", shibiaoMoveIf);
        return "information/shibiaoMoveIf/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:shibiaoMoveIf:add")
    public R save(ShibiaoMoveIfDO shibiaoMoveIf) {
        if (shibiaoMoveIfService.save(shibiaoMoveIf) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:shibiaoMoveIf:edit")
    public R update(ShibiaoMoveIfDO shibiaoMoveIf) {
        shibiaoMoveIfService.update(shibiaoMoveIf);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:shibiaoMoveIf:remove")
    public R remove(Integer id) {
        if (shibiaoMoveIfService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:shibiaoMoveIf:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        shibiaoMoveIfService.batchRemove(ids);
        return R.ok();
    }

}
