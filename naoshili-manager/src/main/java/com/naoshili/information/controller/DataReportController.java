package com.naoshili.information.controller;


import com.naoshili.information.domain.ChartDO;
import com.naoshili.information.domain.CollectionInfoDO;
import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.domain.ZhiHouDO;
import com.naoshili.information.service.CollectionInfoService;
import com.naoshili.information.service.JinggongDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private JinggongDataService jinggongDataService;
    @Autowired
    private CollectionInfoService collectionInfoService;


    @GetMapping("/list/{id}")
    @RequiresPermissions("information:DataReport:DataReport")
    public String datareportlist(@PathVariable("id") Long id, Model model) {
        Map<String, Object> params = new HashMap<>();
        Double diopterL = 0.0;
        Double diopterR = 0.0;

        Double tiaojieL = 0.0;
        Double tiaojieR = 0.0;
        params.put("dataId", id);

        //左眼屈光度（左眼屈光度相加/条数）
        params.put("eye", "L");
        List<JinggongDataDO> jinggongDataDOListL = jinggongDataService.list(params);
        for (JinggongDataDO jinggongDataDO : jinggongDataDOListL) {
            diopterL += jinggongDataDO.getDiopter();
        }
        if (jinggongDataDOListL.size() > 0) {
            diopterL = diopterL / jinggongDataDOListL.size();
        }

        model.addAttribute("diopterL", diopterL);

        //右眼屈光度（右眼屈光度相加/条数）
        params.remove("eye");
        params.put("eye", "R");
        List<JinggongDataDO> jinggongDataDOListR = jinggongDataService.list(params);
        for (JinggongDataDO jinggongDataDO : jinggongDataDOListR) {
            diopterR += jinggongDataDO.getDiopter();
        }
        if (jinggongDataDOListR.size() > 0) {
            diopterR = diopterR / jinggongDataDOListR.size();
        }

        model.addAttribute("diopterR", diopterR);

        //左眼调节微波动 ∑（实时屈光度-屈光度平均值）²   / 屈光度数量    开平方
        //左眼调节微波动画图  x=时间 y=实时屈光度值—屈光度平均值
        Double fenziL = 0.0;
        Integer quguangCountL = 0;
        List<ChartDO> chartDOListBodongL = new LinkedList<>();
        for (JinggongDataDO jinggongDataDO : jinggongDataDOListL) {
            //画图
            ChartDO chartDO = new ChartDO();
            chartDO.setX(jinggongDataDO.getSamplingTime());
            chartDO.setY(jinggongDataDO.getDiopter());

            chartDOListBodongL.add(chartDO);
            if (jinggongDataDO.getDiopter() != null) {
                quguangCountL++;
            }
            fenziL += Math.pow((jinggongDataDO.getDiopter() - diopterL), 2);//平方
        }
        if (quguangCountL > 0) {
            tiaojieL = Math.sqrt(fenziL / quguangCountL);//开方
        }

        model.addAttribute("tiaojieL", tiaojieL);
        model.addAttribute("chartDOListBodongL", chartDOListBodongL);

        //右眼调节微波动 ∑（实时屈光度-屈光度平均值）²   / 屈光度数量    开平方
        Double fenziR = 0.0;
        Integer quguangCountR = 0;
        List<ChartDO> chartDOListBodongR = new LinkedList<>();
        for (JinggongDataDO jinggongDataDO : jinggongDataDOListR) {
            //画图
            ChartDO chartDO = new ChartDO();
            chartDO.setX(jinggongDataDO.getSamplingTime());
            chartDO.setY(jinggongDataDO.getDiopter());

            chartDOListBodongR.add(chartDO);
            if (jinggongDataDO.getDiopter() != null) {
                quguangCountR++;
            }
            fenziR += Math.pow((jinggongDataDO.getDiopter() - diopterR), 2);
        }
        if (quguangCountR > 0) {
            tiaojieR = Math.sqrt(fenziR / quguangCountR);
        }
        model.addAttribute("tiaojieR", tiaojieR);
        model.addAttribute("chartDOListBodongR", chartDOListBodongR);


        //左眼调节滞后量， 右眼调节滞后量
        //不戴镜调节滞后量=  精工实时屈光度 — 1/视标位置  （需要对比时间取最近时间的屈光度）
        // 戴镜调节滞后量=   -（（精工总屈光度R+镜片度数F） /（1-0.014*（R+F））） + （（精工总屈光度R+镜片度数F）/ （1-（视标位置-0.014）*(R+F)） ）
        //x轴 y轴
        //查询用户

        //左眼滞后量图表
        List<ChartDO> chartDOListL = new LinkedList<>();
        //右眼滞后量图表
        List<ChartDO> chartDOListR = new LinkedList<>();

        CollectionInfoDO collectionInfoDO = collectionInfoService.get(id);
        model.addAttribute("experimentalMode", collectionInfoDO.getExperimentalMode());

        int experimentalModeL = 0;
        int experimentalModeR = 0;
        int type = 0;
        Double diopterSumL = 0.0;
        Double diopterSumR = 0.0;
        if (collectionInfoDO.getlGlassesVision() != null && collectionInfoDO.getlGlassesVision() != null &&
                collectionInfoDO.getlGlassesVision() > 0 && collectionInfoDO.getlGlassesVision() > 0) {
            type = 1;
            //计算戴镜的
            //左眼
            if (jinggongDataDOListL.size() > 0) {
                //预计较慢，待优化
                for (JinggongDataDO jinggongDataDO : jinggongDataDOListL) {
                    diopterSumL += jinggongDataDO.getDiopter();
                }
            }
            //右眼
            if (jinggongDataDOListR.size() > 0) {
                //预计较慢，待优化
                for (JinggongDataDO jinggongDataDO : jinggongDataDOListR) {
                    diopterSumR += jinggongDataDO.getDiopter();
                }
            }


        } else {
            type = 2;
            //计算不戴镜的
            List<ZhiHouDO> zhiHouDOSL = new LinkedList<>();
            List<ZhiHouDO> zhiHouDOSR = new LinkedList<>();
            //左眼
            if (jinggongDataDOListL.size() > 0) {
                //预计较慢，待优化
                for (JinggongDataDO jinggongDataDO : jinggongDataDOListL) {
                    ZhiHouDO zhihoulistL = jinggongDataService.getLocation(jinggongDataDO.getSamplingTime(), id);
                    zhiHouDOSL.add(zhihoulistL);
                }
                experimentalModeL = jinggongDataDOListL.get(0).getExperimentalMode();
            }

            if (zhiHouDOSL.size() > 0) {
                for (ZhiHouDO zhiHouDO : zhiHouDOSL) {
                    ChartDO chartDOL = new ChartDO();
                    if (experimentalModeL == 1 || experimentalModeL == 3) {
                        if (zhiHouDO != null && zhiHouDO.getLocaltion() != null && zhiHouDO.getDiopter() != null) {
                            chartDOL.setX(zhiHouDO.getLocaltion().toString());
                            chartDOL.setY(zhiHouDO.getDiopter() - 1 / zhiHouDO.getLocaltion());
                        }

                    } else if (experimentalModeL == 2) {
                        if (zhiHouDO != null && zhiHouDO.getLocaltion1() != null && zhiHouDO.getDiopter() != null) {
                            chartDOL.setX(zhiHouDO.getLocaltion().toString());
                            chartDOL.setY(zhiHouDO.getDiopter() - 1 / zhiHouDO.getLocaltion1());
                        }

                    }
                    chartDOListL.add(chartDOL);
                }
                System.out.println("=============zhiHouDOSL===================" + zhiHouDOSL);
                System.out.println("=============chartDOListL===================" + chartDOListL);

            }

            //右眼
            if (jinggongDataDOListR.size() > 0) {
                for (JinggongDataDO jinggongDataDO : jinggongDataDOListR) {
                    ZhiHouDO zhihoulistR = jinggongDataService.getLocation(jinggongDataDO.getSamplingTime(), id);
                    zhiHouDOSR.add(zhihoulistR);
                }
                experimentalModeR = jinggongDataDOListR.get(0).getExperimentalMode();
            }


            if (zhiHouDOSR.size() > 0) {
                for (ZhiHouDO zhiHouDO : zhiHouDOSR) {
                    ChartDO chartDOR = new ChartDO();
                    if (experimentalModeR == 1 || experimentalModeR == 3) {
                        if (zhiHouDO != null && zhiHouDO.getLocaltion() != null && zhiHouDO.getDiopter() != null) {
                            chartDOR.setX(zhiHouDO.getLocaltion().toString());
                            chartDOR.setY(zhiHouDO.getDiopter() - 1 / zhiHouDO.getLocaltion());
                        }

                    } else if (experimentalModeR == 2) {

                        if (zhiHouDO != null && zhiHouDO.getLocaltion1() != null && zhiHouDO.getDiopter() != null) {
                            chartDOR.setX(zhiHouDO.getLocaltion().toString());
                            chartDOR.setY(zhiHouDO.getDiopter() - 1 / zhiHouDO.getLocaltion1());
                        }

                    }
                    chartDOListR.add(chartDOR);
                }
                System.out.println("=============zhiHouDOSR===================" + zhiHouDOSR);
                System.out.println("=============chartDOListR===================" + chartDOListR);
            }
        }
        //不带镜滞后量
        model.addAttribute("chartDOListL", chartDOListL);
        model.addAttribute("chartDOListR", chartDOListR);

        //戴镜类型 1=戴镜，2=不带镜
        model.addAttribute("type", type);


        return "/information/dataReport/dataReport";
    }

    @GetMapping("/report")
    @RequiresPermissions("information:DataReport:DataReport")
    public String report() {


        return "/information/dataReport/report";
    }
}
