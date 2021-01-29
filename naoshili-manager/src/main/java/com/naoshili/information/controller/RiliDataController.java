package com.naoshili.information.controller;

import com.naoshili.common.utils.ExcelExportUtil4DIY;
import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.RiliDataDO;
import com.naoshili.information.domain.UserBasicDO;
import com.naoshili.information.service.CollectionInfoService;
import com.naoshili.information.service.RiliDataService;
import com.naoshili.information.service.UserBasicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

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

    @Autowired
    private CollectionInfoService collectionInfoService;

    @Autowired
    private UserBasicService userBasicService;

    @GetMapping("/riliList")
    @RequiresPermissions("information:riliData:riliData")
    String jinggongList() {
        return "information/riliData/riliList";
    }

    @GetMapping("/riliListData")
    @RequiresPermissions("information:riliData:riliData")
    @ResponseBody
    public PageUtils jinggongListData(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<RiliDataDO> riliDataDOList = riliDataService.groupbyDataId(query);
        for (RiliDataDO riliDataDO : riliDataDOList) {
            riliDataDO.setUserid(collectionInfoService.get(Long.parseLong(riliDataDO.getDataId())).getUserId().toString());
        }

        int total = riliDataService.countGroupbyDataId(query);
        PageUtils pageUtils = new PageUtils(riliDataDOList, total);

        return pageUtils;
    }

    @GetMapping("/detail/{id}")
    @RequiresPermissions("information:riliData:riliData")
    String RiliData(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "information/riliData/riliData";
    }

    List getMax(List<RiliDataDO> riliDataDOList) {
        List<Double> maxList = new LinkedList<>();
        double maxch1 = Double.MIN_VALUE;
        double maxch2 = Double.MIN_VALUE;
        double maxch3 = Double.MIN_VALUE;
        double maxch4 = Double.MIN_VALUE;
        double maxch5 = Double.MIN_VALUE;
        double maxch6 = Double.MIN_VALUE;
        double maxch7 = Double.MIN_VALUE;
        double maxch8 = Double.MIN_VALUE;
        double maxch9 = Double.MIN_VALUE;
        double maxch10 = Double.MIN_VALUE;
        double maxch11 = Double.MIN_VALUE;
        double maxch12 = Double.MIN_VALUE;
        double maxch13 = Double.MIN_VALUE;
        double maxch14 = Double.MIN_VALUE;
        double maxch15 = Double.MIN_VALUE;
        double maxch16 = Double.MIN_VALUE;
        double maxch17 = Double.MIN_VALUE;
        double maxch18 = Double.MIN_VALUE;
        double maxch19 = Double.MIN_VALUE;
        double maxch20 = Double.MIN_VALUE;
        double maxch21 = Double.MIN_VALUE;
        double maxch22 = Double.MIN_VALUE;
        for (RiliDataDO riliDataDO : riliDataDOList) {
            if (riliDataDO.getCh1() > maxch1) {
                maxch1 = riliDataDO.getCh1();
            }
            if (riliDataDO.getCh2() > maxch2) {
                maxch2 = riliDataDO.getCh2();
            }
            if (riliDataDO.getCh3() > maxch3) {
                maxch3 = riliDataDO.getCh3();
            }
            if (riliDataDO.getCh4() > maxch4) {
                maxch4 = riliDataDO.getCh4();
            }
            if (riliDataDO.getCh5() > maxch5) {
                maxch5 = riliDataDO.getCh5();
            }
            if (riliDataDO.getCh6() > maxch6) {
                maxch6 = riliDataDO.getCh6();
            }
            if (riliDataDO.getCh7() > maxch7) {
                maxch7 = riliDataDO.getCh7();
            }
            if (riliDataDO.getCh8() > maxch8) {
                maxch8 = riliDataDO.getCh8();
            }
            if (riliDataDO.getCh9() > maxch9) {
                maxch9 = riliDataDO.getCh9();
            }
            if (riliDataDO.getCh10() > maxch10) {
                maxch10 = riliDataDO.getCh10();
            }
            if (riliDataDO.getCh11() > maxch11) {
                maxch11 = riliDataDO.getCh11();
            }
            if (riliDataDO.getCh12() > maxch12) {
                maxch12 = riliDataDO.getCh12();
            }
            if (riliDataDO.getCh13() > maxch13) {
                maxch13 = riliDataDO.getCh13();
            }
            if (riliDataDO.getCh14() > maxch14) {
                maxch14 = riliDataDO.getCh14();
            }
            if (riliDataDO.getCh15() > maxch15) {
                maxch15 = riliDataDO.getCh15();
            }
            if (riliDataDO.getCh16() > maxch16) {
                maxch16 = riliDataDO.getCh16();
            }
            if (riliDataDO.getCh17() > maxch17) {
                maxch17 = riliDataDO.getCh17();
            }
            if (riliDataDO.getCh18() > maxch18) {
                maxch18 = riliDataDO.getCh18();
            }
            if (riliDataDO.getCh19() > maxch19) {
                maxch19 = riliDataDO.getCh19();
            }
            if (riliDataDO.getCh20() > maxch20) {
                maxch20 = riliDataDO.getCh20();
            }
            if (riliDataDO.getCh21() > maxch21) {
                maxch21 = riliDataDO.getCh21();
            }
            if (riliDataDO.getCh22() > maxch22) {
                maxch22 = riliDataDO.getCh22();
            }
        }
        maxList.add(maxch1);
        maxList.add(maxch2);
        maxList.add(maxch3);
        maxList.add(maxch4);
        maxList.add(maxch5);
        maxList.add(maxch6);
        maxList.add(maxch7);
        maxList.add(maxch8);
        maxList.add(maxch9);
        maxList.add(maxch10);
        maxList.add(maxch11);
        maxList.add(maxch12);
        maxList.add(maxch13);
        maxList.add(maxch14);
        maxList.add(maxch15);
        maxList.add(maxch16);
        maxList.add(maxch17);
        maxList.add(maxch18);
        maxList.add(maxch19);
        maxList.add(maxch20);
        maxList.add(maxch21);
        maxList.add(maxch22);

        return maxList;
    }

    List getMin(List<RiliDataDO> riliDataDOList) {
        List<Double> minList = new LinkedList<>();
        double minch1 = Double.MIN_VALUE;
        double minch2 = Double.MIN_VALUE;
        double minch3 = Double.MIN_VALUE;
        double minch4 = Double.MIN_VALUE;
        double minch5 = Double.MIN_VALUE;
        double minch6 = Double.MIN_VALUE;
        double minch7 = Double.MIN_VALUE;
        double minch8 = Double.MIN_VALUE;
        double minch9 = Double.MIN_VALUE;
        double minch10 = Double.MIN_VALUE;
        double minch11 = Double.MIN_VALUE;
        double minch12 = Double.MIN_VALUE;
        double minch13 = Double.MIN_VALUE;
        double minch14 = Double.MIN_VALUE;
        double minch15 = Double.MIN_VALUE;
        double minch16 = Double.MIN_VALUE;
        double minch17 = Double.MIN_VALUE;
        double minch18 = Double.MIN_VALUE;
        double minch19 = Double.MIN_VALUE;
        double minch20 = Double.MIN_VALUE;
        double minch21 = Double.MIN_VALUE;
        double minch22 = Double.MIN_VALUE;
        for (RiliDataDO riliDataDO : riliDataDOList) {
            if (riliDataDO.getCh1() < minch1) {
                minch1 = riliDataDO.getCh1();
            }
            if (riliDataDO.getCh2() < minch2) {
                minch2 = riliDataDO.getCh2();
            }
            if (riliDataDO.getCh3() < minch3) {
                minch3 = riliDataDO.getCh3();
            }
            if (riliDataDO.getCh4() < minch4) {
                minch4 = riliDataDO.getCh4();
            }
            if (riliDataDO.getCh5() < minch5) {
                minch5 = riliDataDO.getCh5();
            }
            if (riliDataDO.getCh6() < minch6) {
                minch6 = riliDataDO.getCh6();
            }
            if (riliDataDO.getCh7() < minch7) {
                minch7 = riliDataDO.getCh7();
            }
            if (riliDataDO.getCh8() < minch8) {
                minch8 = riliDataDO.getCh8();
            }
            if (riliDataDO.getCh9() < minch9) {
                minch9 = riliDataDO.getCh9();
            }
            if (riliDataDO.getCh10() < minch10) {
                minch10 = riliDataDO.getCh10();
            }
            if (riliDataDO.getCh11() < minch11) {
                minch11 = riliDataDO.getCh11();
            }
            if (riliDataDO.getCh12() < minch12) {
                minch12 = riliDataDO.getCh12();
            }
            if (riliDataDO.getCh13() < minch13) {
                minch13 = riliDataDO.getCh13();
            }
            if (riliDataDO.getCh14() < minch14) {
                minch14 = riliDataDO.getCh14();
            }
            if (riliDataDO.getCh15() < minch15) {
                minch15 = riliDataDO.getCh15();
            }
            if (riliDataDO.getCh16() < minch16) {
                minch16 = riliDataDO.getCh16();
            }
            if (riliDataDO.getCh17() < minch17) {
                minch17 = riliDataDO.getCh17();
            }
            if (riliDataDO.getCh18() < minch18) {
                minch18 = riliDataDO.getCh18();
            }
            if (riliDataDO.getCh19() < minch19) {
                minch19 = riliDataDO.getCh19();
            }
            if (riliDataDO.getCh20() < minch20) {
                minch20 = riliDataDO.getCh20();
            }
            if (riliDataDO.getCh21() < minch21) {
                minch21 = riliDataDO.getCh21();
            }
            if (riliDataDO.getCh22() < minch22) {
                minch22 = riliDataDO.getCh22();
            }
        }
        minList.add(minch1);
        minList.add(minch2);
        minList.add(minch3);
        minList.add(minch4);
        minList.add(minch5);
        minList.add(minch6);
        minList.add(minch7);
        minList.add(minch8);
        minList.add(minch9);
        minList.add(minch10);
        minList.add(minch11);
        minList.add(minch12);
        minList.add(minch13);
        minList.add(minch14);
        minList.add(minch15);
        minList.add(minch16);
        minList.add(minch17);
        minList.add(minch18);
        minList.add(minch19);
        minList.add(minch20);
        minList.add(minch21);
        minList.add(minch22);

        return minList;
    }

    @ResponseBody
    @GetMapping("/getRili")
    R getRili(String type, Long id) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        params.put("dataId", id);

        //向ArrayList添加数据
        LinkedList<String> xoxy = new LinkedList<String>();
        LinkedList<Double> ch1oxy = new LinkedList<Double>();
        LinkedList<Double> ch2oxy = new LinkedList<Double>();
        LinkedList<Double> ch3oxy = new LinkedList<Double>();
        LinkedList<Double> ch4oxy = new LinkedList<Double>();
        LinkedList<Double> ch5oxy = new LinkedList<Double>();
        LinkedList<Double> ch6oxy = new LinkedList<Double>();
        LinkedList<Double> ch7oxy = new LinkedList<Double>();
        LinkedList<Double> ch8oxy = new LinkedList<Double>();
        LinkedList<Double> ch9oxy = new LinkedList<Double>();
        LinkedList<Double> ch10oxy = new LinkedList<Double>();
        LinkedList<Double> ch11oxy = new LinkedList<Double>();
        LinkedList<Double> ch12oxy = new LinkedList<Double>();
        LinkedList<Double> ch13oxy = new LinkedList<Double>();
        LinkedList<Double> ch14oxy = new LinkedList<Double>();
        LinkedList<Double> ch15oxy = new LinkedList<Double>();
        LinkedList<Double> ch16oxy = new LinkedList<Double>();
        LinkedList<Double> ch17oxy = new LinkedList<Double>();
        LinkedList<Double> ch18oxy = new LinkedList<Double>();
        LinkedList<Double> ch19oxy = new LinkedList<Double>();
        LinkedList<Double> ch20oxy = new LinkedList<Double>();
        LinkedList<Double> ch21oxy = new LinkedList<Double>();
        LinkedList<Double> ch22oxy = new LinkedList<Double>();


        //有氧
        params.put("type", type);

        //算出每一组的最大值最小值，第一组：整体加最小值的绝对值，第二组：整体加第一组的最大值+最小值的绝对值相加，
        // 第三组：整体加第一组和第二组的 最大最小值相加
        List<RiliDataDO> riliDataDOList = riliDataService.list(params);
        /*if (riliDataDOList.size() > 0) {
            List<Double> max = getMax(riliDataDOList);
            List<Double> min = getMin(riliDataDOList);

            Double last = 0.0;
            Double last11 = 0.0;

            last = Math.abs(min.get(0));
            Double last1 = last + Math.abs(max.get(0)) + Math.abs(min.get(1));
            Double last2 = last1 + Math.abs(max.get(1)) + Math.abs(min.get(2));
            Double last3 = last2 + Math.abs(max.get(2)) + Math.abs(min.get(3));
            Double last4 = last3 + Math.abs(max.get(3)) + Math.abs(min.get(4));
            Double last5 = last4 + Math.abs(max.get(4)) + Math.abs(min.get(5));
            Double last6 = last5 + Math.abs(max.get(5)) + Math.abs(min.get(6));
            Double last7 = last6 + Math.abs(max.get(6)) + Math.abs(min.get(7));
            Double last8 = last7 + Math.abs(max.get(7)) + Math.abs(min.get(8));
            Double last9 = last8 + Math.abs(max.get(8)) + Math.abs(min.get(9));
            Double last10 = last9 + Math.abs(max.get(9)) + Math.abs(min.get(10));

            last11 = Math.abs(min.get(11));
            Double last12 = last11 + Math.abs(max.get(11)) + Math.abs(min.get(12));
            Double last13 = last12 + Math.abs(max.get(12)) + Math.abs(min.get(13));
            Double last14 = last13 + Math.abs(max.get(13)) + Math.abs(min.get(14));
            Double last15 = last14 + Math.abs(max.get(14)) + Math.abs(min.get(15));
            Double last16 = last15 + Math.abs(max.get(15)) + Math.abs(min.get(16));
            Double last17 = last16 + Math.abs(max.get(16)) + Math.abs(min.get(17));
            Double last18 = last17 + Math.abs(max.get(17)) + Math.abs(min.get(18));
            Double last19 = last18 + Math.abs(max.get(18)) + Math.abs(min.get(19));
            Double last20 = last19 + Math.abs(max.get(19)) + Math.abs(min.get(20));
            Double last21 = last20 + Math.abs(max.get(20)) + Math.abs(min.get(21));




        }*/
        LinkedList<Integer> Alist = new LinkedList<>();

        List<Integer> indexs = new ArrayList<>();

        boolean isMark = false;//是否为标记数据
        int i = 0;
        for (RiliDataDO riliDataDO : riliDataDOList) {


            if (riliDataDO.getExternalTriggerMark() != null && !riliDataDO.getExternalTriggerMark().equals("") && !riliDataDO.getExternalTriggerMark().equals("null")) {
                if (!isMark) {
                    indexs.add(i);
                }
                isMark = true;
            } else {
                if (isMark) {
                    indexs.add(i - 1);
                }
                isMark = false;
            }

            xoxy.add(riliDataDO.getTime());
            ch1oxy.add(riliDataDO.getCh1());
            ch2oxy.add(riliDataDO.getCh2());
            ch3oxy.add(riliDataDO.getCh3());
            ch4oxy.add(riliDataDO.getCh4());
            ch5oxy.add(riliDataDO.getCh5());
            ch6oxy.add(riliDataDO.getCh6());
            ch7oxy.add(riliDataDO.getCh7());
            ch8oxy.add(riliDataDO.getCh8());
            ch9oxy.add(riliDataDO.getCh9());
            ch10oxy.add(riliDataDO.getCh10());
            ch11oxy.add(riliDataDO.getCh11());

            ch12oxy.add(riliDataDO.getCh12());
            ch13oxy.add(riliDataDO.getCh13());
            ch14oxy.add(riliDataDO.getCh14());
            ch15oxy.add(riliDataDO.getCh15());
            ch16oxy.add(riliDataDO.getCh16());
            ch17oxy.add(riliDataDO.getCh17());
            ch18oxy.add(riliDataDO.getCh18());
            ch19oxy.add(riliDataDO.getCh19());
            ch20oxy.add(riliDataDO.getCh20());
            ch21oxy.add(riliDataDO.getCh21());
            ch22oxy.add(riliDataDO.getCh22());

            i++;
        }

        result.put("indexs", indexs);

        result.put("xoxy", xoxy);
        result.put("ch1oxy", ch1oxy);

        result.put("ch2oxy", ch2oxy);
        result.put("ch3oxy", ch3oxy);
        result.put("ch4oxy", ch4oxy);
        result.put("ch5oxy", ch5oxy);
        result.put("ch6oxy", ch6oxy);
        result.put("ch7oxy", ch7oxy);
        result.put("ch8oxy", ch8oxy);
        result.put("ch9oxy", ch9oxy);
        result.put("ch10oxy", ch10oxy);
        result.put("ch11oxy", ch11oxy);


        result.put("ch12oxy", ch12oxy);
        result.put("ch13oxy", ch13oxy);
        result.put("ch14oxy", ch14oxy);
        result.put("ch15oxy", ch15oxy);
        result.put("ch16oxy", ch16oxy);
        result.put("ch17oxy", ch17oxy);
        result.put("ch18oxy", ch18oxy);
        result.put("ch19oxy", ch19oxy);
        result.put("ch20oxy", ch20oxy);
        result.put("ch21oxy", ch21oxy);
        result.put("ch22oxy", ch22oxy);

        data.put("data", result);
        return R.ok(data);
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

    //导出文件
    @GetMapping("/export")
    void exportR(Long id, String dataId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> bb = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        params.put("dataId", dataId);

        if (id == 2) {
            params.put("type", "oxy");
        } else if (id == 3) {
            params.put("type", "deoxy");
        }

        List<RiliDataDO> list = riliDataService.list(params);

        Long userid = 0L;
        if (list.size() > 0) {
            userid = collectionInfoService.get(Long.parseLong(list.get(0).getDataId())).getUserId();
        }
        map.put("userId", userid);
        UserBasicDO userBasicDO = new UserBasicDO();
        if (userBasicService.list(map).size() > 0) {
            userBasicDO = userBasicService.list(map).get(0);
        }
        if (list.size() > 0) {

            for (RiliDataDO ujl : list) {
                Map<String, Object> mapp = new LinkedHashMap<>();
                mapp.put("用户id", userid);
                mapp.put("用户名", userBasicDO.getName());

                mapp.put("实验序号", ujl.getDataId());
                if (ujl.getExperimentalMode() != null && ujl.getExperimentalMode() == 1) {
                    mapp.put("实验类型", "多段移动视标试验");
                } else if (ujl.getExperimentalMode() != null && ujl.getExperimentalMode() == 2) {
                    mapp.put("实验类型", "单段移动视标试验");
                } else if (ujl.getExperimentalMode() != null && ujl.getExperimentalMode() == 3) {
                    mapp.put("实验类型", "闪烁视标试验");
                } else {
                    mapp.put("实验类型", "");
                }
                mapp.put("外部触发标记", ujl.getExternalTriggerMark());
                mapp.put("采样时间", ujl.getTime());
                mapp.put("类型", ujl.getType());
                mapp.put("CH1", ujl.getCh1());
                mapp.put("Ch2", ujl.getCh2());
                mapp.put("CH3", ujl.getCh3());
                mapp.put("Ch4", ujl.getCh4());
                mapp.put("CH5", ujl.getCh5());
                mapp.put("Ch6", ujl.getCh6());
                mapp.put("CH7", ujl.getCh7());
                mapp.put("Ch8", ujl.getCh8());
                mapp.put("CH9", ujl.getCh9());
                mapp.put("Ch10", ujl.getCh10());
                mapp.put("CH11", ujl.getCh11());
                mapp.put("Ch12", ujl.getCh12());
                mapp.put("CH13", ujl.getCh13());
                mapp.put("Ch14", ujl.getCh14());
                mapp.put("CH15", ujl.getCh15());
                mapp.put("Ch16", ujl.getCh16());
                mapp.put("CH17", ujl.getCh17());
                mapp.put("Ch18", ujl.getCh18());
                mapp.put("CH19", ujl.getCh19());
                mapp.put("Ch20", ujl.getCh20());
                mapp.put("Ch21", ujl.getCh21());
                mapp.put("Ch22", ujl.getCh22());

                bb.add(mapp);
            }
        } else {
            Map<String, Object> mapP = new HashMap<String, Object>();
            mapP.put("信息", "暂无数据！！！");
            bb.add(mapP);
        }
        String filename = "";
        if (id == 2) {
            filename = dataId + "_oxy" + ".xls";
        } else if (id == 3) {
            filename = dataId + "_deoxy" + ".xls";
        } else {
            filename = dataId + "_all" + ".xls";
        }

        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes(), "iso-8859-1"));

        Cookie status = new Cookie("status", "success");
        status.setMaxAge(600);
        response.addCookie(status);
        OutputStream out = response.getOutputStream();

        try {
            ExcelExportUtil4DIY.exportToFile(bb, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }
}
