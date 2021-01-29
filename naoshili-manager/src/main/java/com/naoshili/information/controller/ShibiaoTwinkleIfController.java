package com.naoshili.information.controller;

import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.ChartDO;
import com.naoshili.information.domain.ShibiaoDataDO;
import com.naoshili.information.domain.ShibiaoTwinkleIfDO;
import com.naoshili.information.service.ShibiaoDataService;
import com.naoshili.information.service.ShibiaoTwinkleIfService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-09-23 16:25:44
 */

@Controller
@RequestMapping("/information/shibiaoTwinkleIf")
public class ShibiaoTwinkleIfController {
    @Autowired
    private ShibiaoTwinkleIfService shibiaoTwinkleIfService;
    @Autowired
    private ShibiaoDataService shibiaoDataService;

    @GetMapping("/page/{id}")
    @RequiresPermissions("information:shibiaoTwinkleIf:shibiaoTwinkleIf")
    String ShibiaoTwinkleIf(@PathVariable("id") String id, Model model) {
        Map<String, Object> params = new HashMap<>();
        System.out.println("============dataId============" + id);
        params.put("dataId", id);

        List<ChartDO> chartDOList = new LinkedList<>();
        List<ShibiaoDataDO> shibiaoDataDOList = shibiaoDataService.detaillist(params);
        for (ShibiaoDataDO shibiaoDataDO : shibiaoDataDOList) {
            ChartDO chartDO = new ChartDO();
            chartDO.setX(shibiaoDataDO.getTime());
            chartDO.setY(shibiaoDataDO.getLocaltion());

            chartDOList.add(chartDO);
        }

        ShibiaoTwinkleIfDO shibiaoTwinkleIfDO = new ShibiaoTwinkleIfDO();
        //向ArrayList添加数据
        LinkedList<Double> lightx = new LinkedList<Double>();
        LinkedList<Integer> light2y = new LinkedList<Integer>();
        LinkedList<Integer> light1y = new LinkedList<Integer>();
        LinkedList<Integer> light3y = new LinkedList<Integer>();
        List<ShibiaoTwinkleIfDO> shibiaoTwinkleIfDOS = shibiaoTwinkleIfService.list(params);
        if (shibiaoTwinkleIfDOS.size() > 0) {
            shibiaoTwinkleIfDO = shibiaoTwinkleIfDOS.get(0);

            double xcount = 0.0;
            //一阶段 2号灯开始，
            //预采集
            lightx.add(0.0);
            light2y.add(shibiaoTwinkleIfDO.getLight2() + 20);

            //预采集十秒
            xcount += shibiaoTwinkleIfDO.getPreliminaryAcquisitionTime();
            lightx.add(xcount);
            light2y.add(shibiaoTwinkleIfDO.getLight2());
            //凝视
            xcount += shibiaoTwinkleIfDO.getGazeTime();
            lightx.add(xcount);
            light2y.add(shibiaoTwinkleIfDO.getLight2() + 20);
            //第一次休息
            xcount += shibiaoTwinkleIfDO.getFirstSleep();
            lightx.add(xcount);
            light2y.add(shibiaoTwinkleIfDO.getLight2() + 20);

            light3y.add(null);
            light3y.add(null);
            light3y.add(null);

            light1y.add(null);
            light1y.add(null);
            light1y.add(null);
            //二阶段 1号和3号灯开始 灭为2.4，亮为2秒


            for (int i = 1; i <= shibiaoTwinkleIfDO.getAlternateCount(); i++) {

                if (i == 1) {
                    xcount += 2;
                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3() + 20);
                    light1y.add(shibiaoTwinkleIfDO.getLight1());

                    xcount += 0.4;
                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3() + 20);
                    light1y.add(shibiaoTwinkleIfDO.getLight1() + 20);

                    xcount += 2;
                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3());
                    light1y.add(shibiaoTwinkleIfDO.getLight1() + 20);

                    BigDecimal bd1 = new BigDecimal(Double.toString(xcount));
                    BigDecimal bd2 = new BigDecimal(Double.toString(0.4));
                    xcount = bd1.add(bd2).doubleValue();

                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3() + 20);
                    light1y.add(shibiaoTwinkleIfDO.getLight1() + 20);
                } else {
                    xcount += 2;
                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3() + 20);
                    light1y.add(shibiaoTwinkleIfDO.getLight1());
                    xcount += 0.4;
                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3() + 20);
                    light1y.add(shibiaoTwinkleIfDO.getLight1() + 20);
                    xcount += 2;
                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3());
                    light1y.add(shibiaoTwinkleIfDO.getLight1() + 20);

                    BigDecimal bd1 = new BigDecimal(Double.toString(xcount));
                    BigDecimal bd2 = new BigDecimal(Double.toString(0.4));
                    xcount = bd1.add(bd2).doubleValue();
                    lightx.add(xcount);
                    light3y.add(shibiaoTwinkleIfDO.getLight3() + 20);
                    light1y.add(shibiaoTwinkleIfDO.getLight1() + 20);
                }

            }
            //最后休息
            xcount += shibiaoTwinkleIfDO.getSecondSleep();
            lightx.add(xcount);
            light3y.add(shibiaoTwinkleIfDO.getLight3() + 20);
            light1y.add(shibiaoTwinkleIfDO.getLight1() + 20);
        }


        model.addAttribute("lightx", lightx);
        model.addAttribute("light2y", light2y);
        model.addAttribute("light3y", light3y);
        model.addAttribute("light1y", light1y);
        model.addAttribute("chartDOListMove", chartDOList);
        model.addAttribute("experimentalMode", 3);

        model.addAttribute("id", id);
        return "information/shibiaoTwinkleIf/shibiaoTwinkleIf";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:shibiaoTwinkleIf:shibiaoTwinkleIf")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ShibiaoTwinkleIfDO> shibiaoTwinkleIfList = shibiaoTwinkleIfService.list(query);
        int total = shibiaoTwinkleIfService.count(query);
        PageUtils pageUtils = new PageUtils(shibiaoTwinkleIfList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:shibiaoTwinkleIf:add")
    String add() {
        return "information/shibiaoTwinkleIf/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:shibiaoTwinkleIf:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ShibiaoTwinkleIfDO shibiaoTwinkleIf = shibiaoTwinkleIfService.get(id);
        model.addAttribute("shibiaoTwinkleIf", shibiaoTwinkleIf);
        return "information/shibiaoTwinkleIf/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:shibiaoTwinkleIf:add")
    public R save(ShibiaoTwinkleIfDO shibiaoTwinkleIf) {
        if (shibiaoTwinkleIfService.save(shibiaoTwinkleIf) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:shibiaoTwinkleIf:edit")
    public R update(ShibiaoTwinkleIfDO shibiaoTwinkleIf) {
        shibiaoTwinkleIfService.update(shibiaoTwinkleIf);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:shibiaoTwinkleIf:remove")
    public R remove(Long id) {
        if (shibiaoTwinkleIfService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:shibiaoTwinkleIf:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        shibiaoTwinkleIfService.batchRemove(ids);
        return R.ok();
    }

}
