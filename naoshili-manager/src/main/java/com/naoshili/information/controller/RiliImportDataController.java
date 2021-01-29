package com.naoshili.information.controller;

import com.naoshili.common.utils.*;
import com.naoshili.information.domain.RiliImportDataDO;
import com.naoshili.information.domain.RiliImportDataMesDO;
import com.naoshili.information.domain.UserBasicDO;
import com.naoshili.information.service.CollectionInfoService;
import com.naoshili.information.service.RiliImportDataMesService;
import com.naoshili.information.service.RiliImportDataService;
import com.naoshili.information.service.UserBasicService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-10-23 13:20:38
 */

@Controller
@RequestMapping("/information/riliImportData")
public class RiliImportDataController {
    @Autowired
    private RiliImportDataService riliImportDataService;
    @Autowired
    private CollectionInfoService collectionInfoService;

    @Autowired
    private UserBasicService userBasicService;
    @Autowired
    private RiliImportDataMesService riliImportDataMesService;

    @GetMapping("/riliImportData/{id}")
    @RequiresPermissions("information:riliImportData:riliImportData")
    String RiliImportData(@PathVariable("id") String dataid, Model model) {
        model.addAttribute("dataId", dataid);
        return "information/riliImportData/riliImportData";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:riliImportData:riliImportData")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RiliImportDataDO> riliImportDataList = riliImportDataService.list(query);
        int total = riliImportDataService.count(query);
        PageUtils pageUtils = new PageUtils(riliImportDataList, total);
        return pageUtils;
    }


    @ResponseBody
    @GetMapping("/meslist")
    @RequiresPermissions("information:riliImportData:riliImportData")
    public PageUtils meslist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RiliImportDataMesDO> riliImportDataList = riliImportDataMesService.list(query);
        int total = riliImportDataService.count(query);
        PageUtils pageUtils = new PageUtils(riliImportDataList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/getImport")
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
        List<Integer> indexs = new ArrayList<>();

        boolean isMark = false;//是否为标记数据
        int i = 0;
        params.put("type", type);
        List<RiliImportDataDO> riliImportDataDOS = riliImportDataService.list(params);

        for (RiliImportDataDO riliDataDO : riliImportDataDOS) {
            if (riliDataDO.getMark() != null && !riliDataDO.getMark().equals("") && !riliDataDO.getMark().equals("0")) {
                if (!isMark) {
                    indexs.add(i);
                }
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

        result.put("index", indexs);
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
    @GetMapping("/getMes")
    R getMes(String type, Long id) {
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

        LinkedList<Double> ch1_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch2_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch3_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch4_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch5_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch6_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch7_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch8_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch9_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch10_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch11_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch12_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch13_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch14_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch15_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch16_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch17_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch18_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch19_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch20_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch21_1oxy = new LinkedList<Double>();
        LinkedList<Double> ch22_1oxy = new LinkedList<Double>();


        //有氧
        List<Integer> indexs = new ArrayList<>();

        boolean isMark = false;//是否为标记数据
        int i = 0;
        params.put("type", type);
        List<RiliImportDataMesDO> riliImportDataDOS = riliImportDataMesService.list(params);

        for (RiliImportDataMesDO riliDataDO : riliImportDataDOS) {
            if (riliDataDO.getMark() != null && !riliDataDO.getMark().equals("") && !riliDataDO.getMark().equals("0")) {
                if (!isMark) {
                    indexs.add(i);
                }
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

            ch1_1oxy.add(riliDataDO.getCh1_1());
            ch2_1oxy.add(riliDataDO.getCh2_1());
            ch3_1oxy.add(riliDataDO.getCh3_1());
            ch4_1oxy.add(riliDataDO.getCh4_1());
            ch5_1oxy.add(riliDataDO.getCh5_1());
            ch6_1oxy.add(riliDataDO.getCh6_1());
            ch7_1oxy.add(riliDataDO.getCh7_1());
            ch8_1oxy.add(riliDataDO.getCh8_1());
            ch9_1oxy.add(riliDataDO.getCh9_1());
            ch10_1oxy.add(riliDataDO.getCh10_1());
            ch11_1oxy.add(riliDataDO.getCh11_1());

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

            ch12_1oxy.add(riliDataDO.getCh12_1());
            ch13_1oxy.add(riliDataDO.getCh13_1());
            ch14_1oxy.add(riliDataDO.getCh14_1());
            ch15_1oxy.add(riliDataDO.getCh15_1());
            ch16_1oxy.add(riliDataDO.getCh16_1());
            ch17_1oxy.add(riliDataDO.getCh17_1());
            ch18_1oxy.add(riliDataDO.getCh18_1());
            ch19_1oxy.add(riliDataDO.getCh19_1());
            ch20_1oxy.add(riliDataDO.getCh20_1());
            ch21_1oxy.add(riliDataDO.getCh21_1());
            ch22_1oxy.add(riliDataDO.getCh22_1());
            i++;
        }

        result.put("index", indexs);
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

        result.put("ch1_1oxy", ch1_1oxy);

        result.put("ch2_1oxy", ch2_1oxy);
        result.put("ch3_1oxy", ch3_1oxy);
        result.put("ch4_1oxy", ch4_1oxy);
        result.put("ch5_1oxy", ch5_1oxy);
        result.put("ch6_1oxy", ch6_1oxy);
        result.put("ch7_1oxy", ch7_1oxy);
        result.put("ch8_1oxy", ch8_1oxy);
        result.put("ch9_1oxy", ch9_1oxy);
        result.put("ch10_1oxy", ch10_1oxy);
        result.put("ch11_1oxy", ch11_1oxy);


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

        result.put("ch12_1oxy", ch12_1oxy);
        result.put("ch13_1oxy", ch13_1oxy);
        result.put("ch14_1oxy", ch14_1oxy);
        result.put("ch15_1oxy", ch15_1oxy);
        result.put("ch16_1oxy", ch16_1oxy);
        result.put("ch17_1oxy", ch17_1oxy);
        result.put("ch18_1oxy", ch18_1oxy);
        result.put("ch19_1oxy", ch19_1oxy);
        result.put("ch20_1oxy", ch20_1oxy);
        result.put("ch21_1oxy", ch21_1oxy);
        result.put("ch22_1oxy", ch22_1oxy);

        data.put("data", result);
        return R.ok(data);
    }

    @GetMapping("/add")
    @RequiresPermissions("information:riliImportData:add")
    String add() {
        return "information/riliImportData/add";
    }

    @GetMapping("/importCsv/{id}")
    String importCsv(@PathVariable("id") String dataId, Model model) {
        model.addAttribute("id", dataId);
        return "information/riliImportData/import";
    }

    @PostMapping("/ajaxImport")
    @ResponseBody
    R ajaxImport(RiliImportDataDO riliImportDataDO11) {

        //第一步，读数据
        List<String> strings = null;
        try {
            strings = importCsv(MultipartFileToFile.multipartFileToFile(riliImportDataDO11.getFile()));
            if (strings != null && !strings.isEmpty()) {
                List<String> list = new ArrayList<>();
                List<String[]> newlist = new ArrayList<>();
                List<String[]> nextlist = new ArrayList<>();
                List<RiliImportDataDO> riliImportDataDOS = new ArrayList<>();
                List<RiliImportDataMesDO> riliImportDataMesDOList = new ArrayList<>();

                //第二步，截取41行之后的数据
                for (int i = 41; i < strings.size(); i++) {
                    list.add(strings.get(i));
                }

                //截取list里每一项的1-24
                for (String s : list) {
                    String[] string = s.split(",");
                    newlist.add(string);
                }

                if (riliImportDataDO11.getType() == 4) {
                    for (String[] strings1 : newlist) {
                        String[] strings2 = (String[]) ArrayUtils.subarray(strings1, 1, 47);
                        nextlist.add(strings2);
                    }
                    for (int i = 0; i < nextlist.size(); i++) {
                        RiliImportDataMesDO riliImportDataMesDO = new RiliImportDataMesDO();

                        riliImportDataMesDO.setCh1(Double.parseDouble(nextlist.get(i)[0]));
                        riliImportDataMesDO.setCh1_1(Double.parseDouble(nextlist.get(i)[1]));
                        riliImportDataMesDO.setCh2(Double.parseDouble(nextlist.get(i)[2]));
                        riliImportDataMesDO.setCh2_1(Double.parseDouble(nextlist.get(i)[3]));
                        riliImportDataMesDO.setCh3(Double.parseDouble(nextlist.get(i)[4]));
                        riliImportDataMesDO.setCh3_1(Double.parseDouble(nextlist.get(i)[5]));
                        riliImportDataMesDO.setCh4(Double.parseDouble(nextlist.get(i)[6]));
                        riliImportDataMesDO.setCh4_1(Double.parseDouble(nextlist.get(i)[7]));
                        riliImportDataMesDO.setCh5(Double.parseDouble(nextlist.get(i)[8]));
                        riliImportDataMesDO.setCh5_1(Double.parseDouble(nextlist.get(i)[9]));
                        riliImportDataMesDO.setCh6(Double.parseDouble(nextlist.get(i)[10]));
                        riliImportDataMesDO.setCh6_1(Double.parseDouble(nextlist.get(i)[11]));
                        riliImportDataMesDO.setCh7(Double.parseDouble(nextlist.get(i)[12]));
                        riliImportDataMesDO.setCh7_1(Double.parseDouble(nextlist.get(i)[13]));
                        riliImportDataMesDO.setCh8(Double.parseDouble(nextlist.get(i)[14]));
                        riliImportDataMesDO.setCh8_1(Double.parseDouble(nextlist.get(i)[15]));
                        riliImportDataMesDO.setCh9(Double.parseDouble(nextlist.get(i)[16]));
                        riliImportDataMesDO.setCh9_1(Double.parseDouble(nextlist.get(i)[17]));
                        riliImportDataMesDO.setCh10(Double.parseDouble(nextlist.get(i)[18]));
                        riliImportDataMesDO.setCh10_1(Double.parseDouble(nextlist.get(i)[19]));
                        riliImportDataMesDO.setCh11(Double.parseDouble(nextlist.get(i)[20]));
                        riliImportDataMesDO.setCh11_1(Double.parseDouble(nextlist.get(i)[21]));

                        riliImportDataMesDO.setCh12(Double.parseDouble(nextlist.get(i)[22]));
                        riliImportDataMesDO.setCh12_1(Double.parseDouble(nextlist.get(i)[23]));
                        riliImportDataMesDO.setCh13(Double.parseDouble(nextlist.get(i)[24]));
                        riliImportDataMesDO.setCh13_1(Double.parseDouble(nextlist.get(i)[25]));
                        riliImportDataMesDO.setCh14(Double.parseDouble(nextlist.get(i)[26]));
                        riliImportDataMesDO.setCh14_1(Double.parseDouble(nextlist.get(i)[27]));
                        riliImportDataMesDO.setCh15(Double.parseDouble(nextlist.get(i)[28]));
                        riliImportDataMesDO.setCh15_1(Double.parseDouble(nextlist.get(i)[29]));
                        riliImportDataMesDO.setCh16(Double.parseDouble(nextlist.get(i)[30]));
                        riliImportDataMesDO.setCh16_1(Double.parseDouble(nextlist.get(i)[31]));
                        riliImportDataMesDO.setCh17(Double.parseDouble(nextlist.get(i)[32]));
                        riliImportDataMesDO.setCh17_1(Double.parseDouble(nextlist.get(i)[33]));
                        riliImportDataMesDO.setCh18(Double.parseDouble(nextlist.get(i)[34]));
                        riliImportDataMesDO.setCh18_1(Double.parseDouble(nextlist.get(i)[35]));
                        riliImportDataMesDO.setCh19(Double.parseDouble(nextlist.get(i)[36]));
                        riliImportDataMesDO.setCh19_1(Double.parseDouble(nextlist.get(i)[37]));
                        riliImportDataMesDO.setCh20(Double.parseDouble(nextlist.get(i)[38]));
                        riliImportDataMesDO.setCh20_1(Double.parseDouble(nextlist.get(i)[39]));
                        riliImportDataMesDO.setCh21(Double.parseDouble(nextlist.get(i)[40]));
                        riliImportDataMesDO.setCh21_1(Double.parseDouble(nextlist.get(i)[41]));
                        riliImportDataMesDO.setCh22(Double.parseDouble(nextlist.get(i)[42]));
                        riliImportDataMesDO.setCh22_1(Double.parseDouble(nextlist.get(i)[43]));

                        riliImportDataMesDO.setMark(nextlist.get(i)[44]);
                        riliImportDataMesDO.setTime(nextlist.get(i)[45]);
                        riliImportDataMesDO.setType(riliImportDataDO11.getType());
                        riliImportDataMesDO.setDataId(riliImportDataDO11.getDataId());

                        riliImportDataMesDOList.add(riliImportDataMesDO);
                    }
                    int result = riliImportDataMesService.saveList(riliImportDataMesDOList);

                } else {


                    for (String[] strings1 : newlist) {
                        String[] strings2 = (String[]) ArrayUtils.subarray(strings1, 1, 25);
                        nextlist.add(strings2);
                    }

                    for (int i = 0; i < nextlist.size(); i++) {
                        RiliImportDataDO riliImportDataDO = new RiliImportDataDO();
                        riliImportDataDO.setCh1(Double.parseDouble(nextlist.get(i)[0]));
                        riliImportDataDO.setCh2(Double.parseDouble(nextlist.get(i)[1]));
                        riliImportDataDO.setCh3(Double.parseDouble(nextlist.get(i)[2]));
                        riliImportDataDO.setCh4(Double.parseDouble(nextlist.get(i)[3]));
                        riliImportDataDO.setCh5(Double.parseDouble(nextlist.get(i)[4]));
                        riliImportDataDO.setCh6(Double.parseDouble(nextlist.get(i)[5]));
                        riliImportDataDO.setCh7(Double.parseDouble(nextlist.get(i)[6]));
                        riliImportDataDO.setCh8(Double.parseDouble(nextlist.get(i)[7]));
                        riliImportDataDO.setCh9(Double.parseDouble(nextlist.get(i)[8]));
                        riliImportDataDO.setCh10(Double.parseDouble(nextlist.get(i)[9]));
                        riliImportDataDO.setCh11(Double.parseDouble(nextlist.get(i)[10]));
                        riliImportDataDO.setCh12(Double.parseDouble(nextlist.get(i)[11]));
                        riliImportDataDO.setCh13(Double.parseDouble(nextlist.get(i)[12]));
                        riliImportDataDO.setCh14(Double.parseDouble(nextlist.get(i)[13]));
                        riliImportDataDO.setCh15(Double.parseDouble(nextlist.get(i)[14]));
                        riliImportDataDO.setCh16(Double.parseDouble(nextlist.get(i)[15]));
                        riliImportDataDO.setCh17(Double.parseDouble(nextlist.get(i)[16]));
                        riliImportDataDO.setCh18(Double.parseDouble(nextlist.get(i)[17]));
                        riliImportDataDO.setCh19(Double.parseDouble(nextlist.get(i)[18]));
                        riliImportDataDO.setCh20(Double.parseDouble(nextlist.get(i)[19]));
                        riliImportDataDO.setCh21(Double.parseDouble(nextlist.get(i)[20]));
                        riliImportDataDO.setCh22(Double.parseDouble(nextlist.get(i)[21]));

                        riliImportDataDO.setMark(nextlist.get(i)[22]);
                        riliImportDataDO.setTime(nextlist.get(i)[23]);
                        riliImportDataDO.setType(riliImportDataDO11.getType());
                        riliImportDataDO.setDataId(riliImportDataDO11.getDataId());

                        riliImportDataDOS.add(riliImportDataDO);
                    }


                    int result = riliImportDataService.saveList(riliImportDataDOS);

                }
            }
        } catch (Exception e) {
            return R.error(e.toString());
        }
        return R.ok();
    }


    @GetMapping("/export")
    @ResponseBody
    void export(String dataId, Integer type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> bb = new ArrayList<Map<String, Object>>();
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        params.put("dataId", dataId);
        params.put("type", type);


        if (type == 4) {
            //MES类型格式文件特殊，每个通道有两条数据

            List<RiliImportDataMesDO> riliImportDataMesDOList = riliImportDataMesService.list(params);
            Long userid = 0L;
            if (riliImportDataMesDOList.size() > 0) {
                userid = collectionInfoService.get(Long.parseLong(riliImportDataMesDOList.get(0).getDataId())).getUserId();
            }
            map.put("userId", userid);
            UserBasicDO userBasicDO = new UserBasicDO();
            if (userBasicService.list(map).size() > 0) {
                userBasicDO = userBasicService.list(map).get(0);
            }
            if (riliImportDataMesDOList.size() > 0) {
                for (RiliImportDataMesDO ujl : riliImportDataMesDOList) {
                    Map<String, Object> mapp = new LinkedHashMap<>();
                    mapp.put("用户id", userid);
                    mapp.put("用户名", userBasicDO.getName());
                    mapp.put("采样时间", ujl.getTime());
                    mapp.put("标记", ujl.getMark());
                    mapp.put("类型", ujl.getType());
                    mapp.put("CH1", ujl.getCh1());
                    mapp.put("CH1_1", ujl.getCh1_1());
                    mapp.put("Ch2", ujl.getCh2());
                    mapp.put("Ch2_1", ujl.getCh2_1());
                    mapp.put("CH3", ujl.getCh3());
                    mapp.put("CH3_1", ujl.getCh3_1());
                    mapp.put("Ch4", ujl.getCh4());
                    mapp.put("Ch4_1", ujl.getCh4_1());
                    mapp.put("CH5", ujl.getCh5());
                    mapp.put("CH5_1", ujl.getCh5_1());
                    mapp.put("Ch6", ujl.getCh6());
                    mapp.put("Ch6_1", ujl.getCh6_1());
                    mapp.put("CH7", ujl.getCh7());
                    mapp.put("CH7_1", ujl.getCh7_1());
                    mapp.put("Ch8", ujl.getCh8());
                    mapp.put("Ch8_1", ujl.getCh8_1());
                    mapp.put("CH9", ujl.getCh9());
                    mapp.put("CH9_1", ujl.getCh9_1());
                    mapp.put("Ch10", ujl.getCh10());
                    mapp.put("Ch10_1", ujl.getCh10_1());
                    mapp.put("CH11", ujl.getCh11());
                    mapp.put("CH11_1", ujl.getCh11_1());
                    mapp.put("Ch12", ujl.getCh12());
                    mapp.put("Ch12_1", ujl.getCh12_1());
                    mapp.put("CH13", ujl.getCh13());
                    mapp.put("CH13_1", ujl.getCh13_1());
                    mapp.put("Ch14", ujl.getCh14());
                    mapp.put("Ch14_1", ujl.getCh14_1());
                    mapp.put("CH15", ujl.getCh15());
                    mapp.put("CH15_1", ujl.getCh15_1());
                    mapp.put("Ch16", ujl.getCh16());
                    mapp.put("Ch16_1", ujl.getCh16_1());
                    mapp.put("CH17", ujl.getCh17());
                    mapp.put("CH17_1", ujl.getCh17_1());
                    mapp.put("Ch18", ujl.getCh18());
                    mapp.put("Ch18_1", ujl.getCh18_1());
                    mapp.put("CH19", ujl.getCh19());
                    mapp.put("CH19_1", ujl.getCh19_1());
                    mapp.put("Ch20", ujl.getCh20());
                    mapp.put("Ch20_1", ujl.getCh20_1());
                    mapp.put("Ch21", ujl.getCh21());
                    mapp.put("Ch21_1", ujl.getCh21_1());
                    mapp.put("Ch22", ujl.getCh22());
                    mapp.put("Ch22_1", ujl.getCh22_1());

                    bb.add(mapp);
                }
            } else {
                Map<String, Object> mapP = new HashMap<String, Object>();
                mapP.put("信息", "暂无数据！！！");
                bb.add(mapP);
            }

        } else {
            List<RiliImportDataDO> riliImportDataDOList = riliImportDataService.list(params);
            Long userid = 0L;
            if (riliImportDataDOList.size() > 0) {
                userid = collectionInfoService.get(Long.parseLong(riliImportDataDOList.get(0).getDataId())).getUserId();
            }
            map.put("userId", userid);
            UserBasicDO userBasicDO = new UserBasicDO();
            if (userBasicService.list(map).size() > 0) {
                userBasicDO = userBasicService.list(map).get(0);
            }

            if (riliImportDataDOList.size() > 0) {
                for (RiliImportDataDO ujl : riliImportDataDOList) {
                    Map<String, Object> mapp = new LinkedHashMap<>();

                    mapp.put("用户id", userid);
                    mapp.put("用户名", userBasicDO.getName());
                    mapp.put("采样时间", ujl.getTime());
                    mapp.put("标记", ujl.getMark());
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

        }

        String filename = "";
        if (type == 1) {
            filename = dataId + "_oxy" + ".xls";
        } else if (type == 2) {
            filename = dataId + "_deoxy" + ".xls";
        } else if (type == 3) {
            filename = dataId + "_total" + ".xls";
        } else {
            filename = dataId + "_MES" + ".xls";
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

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:riliImportData:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        RiliImportDataDO riliImportData = riliImportDataService.get(id);
        model.addAttribute("riliImportData", riliImportData);
        return "information/riliImportData/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:riliImportData:add")
    public R save(RiliImportDataDO riliImportData) {
        if (riliImportDataService.save(riliImportData) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:riliImportData:edit")
    public R update(RiliImportDataDO riliImportData) {
        riliImportDataService.update(riliImportData);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:riliImportData:remove")
    public R remove(Integer id) {
        if (riliImportDataService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:riliImportData:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        riliImportDataService.batchRemove(ids);
        return R.ok();
    }


    /**
     * 导入csv文件方法
     */
    public static List<String> importCsv(File file) {

        List<String> dataList = new ArrayList<String>();//数据
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));//为文件流赋数据
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                dataList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    bufferedReader = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataList;
    }
}
