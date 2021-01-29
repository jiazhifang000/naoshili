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
import java.util.*;

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
    private ShibiaoTwinkleIfService shibiaoTwinkleIfService;

    @Autowired
    private ShibiaoMoveIfService shibiaoMoveIfService;
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
       /* for (UserBasicDO userBasicDO : userBasicList) {
            Map<String, Object> params11 = new HashMap<>();
            params11.put("uid", userBasicDO.getUserId());

            List<UserEyeDataDO> userEyeDataDOList = userEyeDataService.list(params11);
            if (userEyeDataDOList.size() > 0) {
                userBasicDO.setEyeHealth(userEyeDataDOList.get(0).getEyeHealth());
            }
        }
*/
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

    @GetMapping("/environmentInfoedit/{id}")
    @RequiresPermissions("information:userBasic:edit")
    String environmentInfoedit(@PathVariable("id") Long id, Model model) {
        UserBasicDO userBasic = userBasicService.get(id);
        model.addAttribute("userBasic", userBasic);
        return "information/userBasic/environmentInfoedit";
    }


    @GetMapping("/environmentInfo/{id}")
    String environmentInfo(@PathVariable("id") Long id, Model model) {
        System.out.println("===============id=====================" + id);
        model.addAttribute("id", id);
        return "information/userBasic/environmentInfo";
    }


    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:userBasic:add")
    public R save(UserBasicDO userBasic) {
        UserBasicDO userBasicDO = userBasicService.getUserId(userBasic.getUserId());
        if (userBasicDO != null) {
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
            userEyeDataDO.setlEyeballDiameter(userBasic.getlEyeballDiameter1());
            userEyeDataDO.setrEyeballDiameter(userBasic.getrEyeballDiameter1());
            userEyeDataDO.setlEyepillarDiameter(userBasic.getlEyepillarDiameter1());
            userEyeDataDO.setrEyepillarDiameter(userBasic.getrEyepillarDiameter1());
            userEyeDataDO.setlEyeAxis(userBasic.getlEyeAxis1());
            userEyeDataDO.setrEyeAxis(userBasic.getlEyeAxis1());
            userEyeDataDO.setlEyeOptometry(userBasic.getlEyeOptometry1());
            userEyeDataDO.setrEyeOptometry(userBasic.getrEyeOptometry1());
            userEyeDataDO.setlEyeNakedVision(userBasic.getlEyeNakedVision1());
            userEyeDataDO.setrEyeNakedVision(userBasic.getrEyeNakedVision1());
            userEyeDataDO.setlEyeGlassesVision(userBasic.getlEyeGlassesVision1());
            userEyeDataDO.setrEyeGlassesVision(userBasic.getrEyeGlassesVision1());

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
        UserBasicDO userBasicDO = userBasicService.get(id);
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userBasicDO.getUserId());
        List<CollectionInfoDO> collectionInfoDOList = collectionInfoService.list(params);
        params.remove("userId");
        params.put("uid", userBasicDO.getUserId());
        List<UserEyeDataDO> userEyeDataDOList = userEyeDataService.list(params);
        if (userEyeDataDOList.size() > 0) {
            userEyeDataService.remove(userEyeDataDOList.get(0).getId());
        }
        if (collectionInfoDOList.size() > 0) {
            params.remove("userId");
            int result = 0;
            for (CollectionInfoDO collectionInfoDO : collectionInfoDOList) {
                collectionInfoService.remove(Long.parseLong(collectionInfoDO.getId()));

                result = jinggongDataService.deleteByDataid(Long.parseLong(collectionInfoDO.getId()));
                result = shibiaoDataService.deleteByDataid(Long.parseLong(collectionInfoDO.getId()));
                result = riliDataService.deleteByDataid(Long.parseLong(collectionInfoDO.getId()));
                result = shibiaoTwinkleIfService.deleteByDataid(Long.parseLong(collectionInfoDO.getId()));
                result = shibiaoMoveIfService.deleteByDataid(Long.parseLong(collectionInfoDO.getId()));
            }
        }
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
     */
    @ResponseBody
    @PostMapping("/importMember")
    public R importUser(MultipartFile file) {
        return userBasicService.importUser(file);
    }


    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        UserBasicDO userBasic = userBasicService.getUserId(id);
        System.out.println("=============userid=======================" + id);

        session.setAttribute("id", id);
        model.addAttribute("id", id);
        //model.addAttribute("idCard", userBasic.getIdCard());
        return "information/userBasic/detail";
    }

    @GetMapping("/allData/{id}")
    String allData(@PathVariable("id") String id, Model model) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        UserBasicDO userBasic = userBasicService.getUserId(Long.parseLong(session.getAttribute("id").toString()));
        //UserBasicDO userBasic = userBasicService.get(60L);
        params.put("uid", Long.parseLong(session.getAttribute("id").toString()));
        //params.put("userId",60);
        List<UserEyeDataDO> userEyeDataDOList = userEyeDataService.list(params);

        CollectionInfoDO collectionInfoDO = collectionInfoService.get(Long.parseLong(id));
        model.addAttribute("experimentalMode", collectionInfoDO.getExperimentalMode());
        model.addAttribute("id", id);
        model.addAttribute("userBasic", userBasic);
        model.addAttribute("userEyeDataDO", userEyeDataDOList.get(0));

        return "information/userBasic/allData";
    }

    /**
     * 精工 5500
     */
    @GetMapping("/getJinggong")
    @ResponseBody
    R getJinggong(String id) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        params.put("dataId", id);

        List<JinggongDataDO> jinggongDataDOList = jinggongDataService.list(params);
        /*右眼屈光度*/
        List<Integer> indexsr = new ArrayList<>();

        boolean isMark = false;//是否为标记数据
        params.put("eye", "R");
        List<JinggongDataDO> rJinggong = jinggongDataService.list(params);
        int i = 0;
        Double[] right = new Double[rJinggong.size()];
        String[] xr = new String[rJinggong.size()];
        for (JinggongDataDO elemeterInfo : rJinggong) {
            Double eleseq = elemeterInfo.getDiopter();
            right[i] = eleseq;
            xr[i] = elemeterInfo.getSamplingTime().split(" ")[1];

            if (elemeterInfo.getExternalTriggerMark() != null && !elemeterInfo.getExternalTriggerMark().equals("") && !elemeterInfo.getExternalTriggerMark().equals("null")) {
                if (!isMark) {
                    indexsr.add(i);
                }
                isMark = true;
            } else {
                if (isMark) {
                    indexsr.add(i - 1);
                }
                isMark = false;
            }
            i++;
        }
        int j = 0;
        /*左眼屈光度*/
        params.remove("eye");
        params.put("eye", "L");
        List<Integer> indexsl = new ArrayList<>();

        boolean isMarkl = false;//是否为标记数据
        List<JinggongDataDO> lJinggong = jinggongDataService.list(params);
        Double[] left = new Double[lJinggong.size()];
        String[] xl = new String[lJinggong.size()];
        for (JinggongDataDO elemeterInfo : lJinggong) {
            Double eleseq = elemeterInfo.getDiopter();
            left[j] = eleseq;
            xl[j] = elemeterInfo.getSamplingTime().split(" ")[1];

            if (elemeterInfo.getExternalTriggerMark() != null && !elemeterInfo.getExternalTriggerMark().equals("") && !elemeterInfo.getExternalTriggerMark().equals("null")) {
                if (!isMarkl) {
                    indexsl.add(j);
                }
                isMarkl = true;
            } else {
                if (isMarkl) {
                    indexsl.add(j - 1);
                }
                isMarkl = false;
            }
            j++;
        }
        result.put("jinggongDataDOList", jinggongDataDOList);
        result.put("rJinggong", right);
        result.put("lJinggong", left);

        result.put("xl", xl);
        result.put("xr", xr);
        result.put("indexl", indexsl);
        result.put("indexr", indexsr);
        if (jinggongDataDOList.size() > 0) {
            result.put("type", jinggongDataDOList.get(0).getExperimentalMode());
        } else {
            result.put("type", null);
        }
        data.put("data", result);
        return R.ok(data);
    }

    /**
     * 日立4000
     */
    @GetMapping("/getRili")
    @ResponseBody
    R getRili(Long id) {

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        params.put("dataId", id);
        List<RiliDataDO> riliDataDOList = riliDataService.list(params);
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

        LinkedList<String> xdeoxy = new LinkedList<String>();
        LinkedList<Double> ch1deoxy = new LinkedList<Double>();
        LinkedList<Double> ch2deoxy = new LinkedList<Double>();
        LinkedList<Double> ch3deoxy = new LinkedList<Double>();
        LinkedList<Double> ch4deoxy = new LinkedList<Double>();
        LinkedList<Double> ch5deoxy = new LinkedList<Double>();
        LinkedList<Double> ch6deoxy = new LinkedList<Double>();
        LinkedList<Double> ch7deoxy = new LinkedList<Double>();
        LinkedList<Double> ch8deoxy = new LinkedList<Double>();
        LinkedList<Double> ch9deoxy = new LinkedList<Double>();
        LinkedList<Double> ch10deoxy = new LinkedList<Double>();
        LinkedList<Double> ch11deoxy = new LinkedList<Double>();
        LinkedList<Double> ch12deoxy = new LinkedList<Double>();
        LinkedList<Double> ch13deoxy = new LinkedList<Double>();
        LinkedList<Double> ch14deoxy = new LinkedList<Double>();
        LinkedList<Double> ch15deoxy = new LinkedList<Double>();
        LinkedList<Double> ch16deoxy = new LinkedList<Double>();
        LinkedList<Double> ch17deoxy = new LinkedList<Double>();
        LinkedList<Double> ch18deoxy = new LinkedList<Double>();
        LinkedList<Double> ch19deoxy = new LinkedList<Double>();
        LinkedList<Double> ch20deoxy = new LinkedList<Double>();
        LinkedList<Double> ch21deoxy = new LinkedList<Double>();
        LinkedList<Double> ch22deoxy = new LinkedList<Double>();

        //有氧
        params.put("type", "oxy");

        //算出每一组的最大值最小值，第一组：整体加最小值的绝对值，第二组：整体加第一组的最大值+最小值的绝对值相加，
        // 第三组：整体加第一组和第二组的 最大最小值相加
        List<RiliDataDO> riliDataDOList1 = riliDataService.list(params);
        if (riliDataDOList1.size() > 0) {
            for (RiliDataDO riliDataDO : riliDataDOList1) {
                xoxy.add(riliDataDO.getTime());

                ch1oxy.add(riliDataDO.getCh1() + 0.2);
                ch2oxy.add(riliDataDO.getCh2() + 0.4);
                ch3oxy.add(riliDataDO.getCh3() + 0.6);
                ch4oxy.add(riliDataDO.getCh4() + 0.8);
                ch5oxy.add(riliDataDO.getCh5() + 1);
                ch6oxy.add(riliDataDO.getCh6() + 1.2);
                ch7oxy.add(riliDataDO.getCh7() + 1.4);
                ch8oxy.add(riliDataDO.getCh8() + 1.6);
                ch9oxy.add(riliDataDO.getCh9() + 1.8);
                ch10oxy.add(riliDataDO.getCh10() + 2);
                ch11oxy.add(riliDataDO.getCh11() + 2.2);


                ch12oxy.add(riliDataDO.getCh12() + 0.2);
                ch13oxy.add(riliDataDO.getCh13() + 0.4);
                ch14oxy.add(riliDataDO.getCh14() + 0.6);
                ch15oxy.add(riliDataDO.getCh15() + 0.8);
                ch16oxy.add(riliDataDO.getCh16() + 1);
                ch17oxy.add(riliDataDO.getCh17() + 1.2);
                ch18oxy.add(riliDataDO.getCh18() + 1.4);
                ch19oxy.add(riliDataDO.getCh19() + 1.6);
                ch20oxy.add(riliDataDO.getCh20() + 1.8);
                ch21oxy.add(riliDataDO.getCh21() + 2);
                ch22oxy.add(riliDataDO.getCh22() + 2.2);
            }

        }

        params.remove("type");
        params.put("type", "deoxy");
        List<RiliDataDO> riliDataDOListDEOXY = riliDataService.list(params);
        if (riliDataDOListDEOXY.size() > 0) {
            for (RiliDataDO riliDataDO : riliDataDOListDEOXY) {
                xdeoxy.add(riliDataDO.getTime());
                ch1deoxy.add(riliDataDO.getCh1());
                ch2deoxy.add(riliDataDO.getCh2() > 0 ? riliDataDO.getCh2() + 0.5 : riliDataDO.getCh2() - 0.5);
                ch3deoxy.add(riliDataDO.getCh3() > 0 ? riliDataDO.getCh3() + 1 : riliDataDO.getCh3() - 1);
                ch4deoxy.add(riliDataDO.getCh4() > 0 ? riliDataDO.getCh4() + 1.5 : riliDataDO.getCh4() - 1.5);
                ch5deoxy.add(riliDataDO.getCh5() > 0 ? riliDataDO.getCh5() + 2 : riliDataDO.getCh5() - 2);
                ch6deoxy.add(riliDataDO.getCh6() > 0 ? riliDataDO.getCh6() + 2.5 : riliDataDO.getCh6() - 2.5);
                ch7deoxy.add(riliDataDO.getCh7() > 0 ? riliDataDO.getCh7() + 3 : riliDataDO.getCh7() - 3);
                ch8deoxy.add(riliDataDO.getCh8() > 0 ? riliDataDO.getCh8() + 3.5 : riliDataDO.getCh8() - 3.5);
                ch9deoxy.add(riliDataDO.getCh9() > 0 ? riliDataDO.getCh9() + 4 : riliDataDO.getCh9() - 4);
                ch10deoxy.add(riliDataDO.getCh10() > 0 ? riliDataDO.getCh10() + 4.5 : riliDataDO.getCh10() - 4.5);
                ch11deoxy.add(riliDataDO.getCh11() > 0 ? riliDataDO.getCh11() + 5 : riliDataDO.getCh11() - 5);


                ch12deoxy.add(riliDataDO.getCh12() > 0 ? riliDataDO.getCh2() + 0.5 : riliDataDO.getCh2() - 0.5);
                ch13deoxy.add(riliDataDO.getCh13() > 0 ? riliDataDO.getCh2() + 1 : riliDataDO.getCh2() - 1);
                ch14deoxy.add(riliDataDO.getCh14() > 0 ? riliDataDO.getCh2() + 1.5 : riliDataDO.getCh2() - 1.5);
                ch15deoxy.add(riliDataDO.getCh15() > 0 ? riliDataDO.getCh2() + 2 : riliDataDO.getCh2() - 2);
                ch16deoxy.add(riliDataDO.getCh16() > 0 ? riliDataDO.getCh2() + 2.5 : riliDataDO.getCh2() - 2.5);
                ch17deoxy.add(riliDataDO.getCh17() > 0 ? riliDataDO.getCh2() + 3 : riliDataDO.getCh2() - 3);
                ch18deoxy.add(riliDataDO.getCh18() > 0 ? riliDataDO.getCh2() + 3.5 : riliDataDO.getCh2() - 3.5);
                ch19deoxy.add(riliDataDO.getCh19() > 0 ? riliDataDO.getCh2() + 4 : riliDataDO.getCh2() - 4);
                ch20deoxy.add(riliDataDO.getCh20() > 0 ? riliDataDO.getCh2() + 4.5 : riliDataDO.getCh2() - 4.5);
                ch21deoxy.add(riliDataDO.getCh21() > 0 ? riliDataDO.getCh2() + 5 : riliDataDO.getCh2() - 5);
                ch22deoxy.add(riliDataDO.getCh22() > 0 ? riliDataDO.getCh2() + 5.5 : riliDataDO.getCh2() - 5.5);
            }
        }

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

        result.put("xdeoxy", xdeoxy);
        result.put("ch1deoxy", ch1deoxy);
        result.put("ch2deoxy", ch2deoxy);
        result.put("ch3deoxy", ch3deoxy);
        result.put("ch4deoxy", ch4deoxy);
        result.put("ch5deoxy", ch5deoxy);
        result.put("ch6deoxy", ch6deoxy);
        result.put("ch7deoxy", ch7deoxy);
        result.put("ch8deoxy", ch8deoxy);
        result.put("ch9deoxy", ch9deoxy);
        result.put("ch10deoxy", ch10deoxy);
        result.put("ch11deoxy", ch11deoxy);
        result.put("ch12deoxy", ch12deoxy);
        result.put("ch13deoxy", ch13deoxy);
        result.put("ch14deoxy", ch14deoxy);
        result.put("ch15deoxy", ch15deoxy);
        result.put("ch16deoxy", ch16deoxy);
        result.put("ch17deoxy", ch17deoxy);
        result.put("ch18deoxy", ch18deoxy);
        result.put("ch19deoxy", ch19deoxy);
        result.put("ch20deoxy", ch20deoxy);
        result.put("ch21deoxy", ch21deoxy);
        result.put("ch22deoxy", ch22deoxy);


        result.put("riliDataDOList", riliDataDOList);


        data.put("data", result);
        return R.ok(data);
    }

    /**
     * 视标数据
     */
    @GetMapping("/getShibiao")
    @ResponseBody
    R getShibiao(Long id) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        params.put("dataId", id);
        List<ShibiaoDataDO> shibiaoDataDOList = shibiaoDataService.list(params);
        data.put("data", shibiaoDataDOList);
        return R.ok(data);
    }

    /**
     * 分析报告
     */
    @GetMapping("/getReport")
    @ResponseBody
    R getReport(Long id) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

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

        result.put("diopterL", diopterL);

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

        result.put("diopterR", diopterR);

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

        result.put("tiaojieL", tiaojieL);
        result.put("chartDOListBodongL", chartDOListBodongL);

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
        result.put("tiaojieR", tiaojieR);
        result.put("chartDOListBodongR", chartDOListBodongR);


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
        result.put("chartDOListL", chartDOListL);
        result.put("chartDOListR", chartDOListR);

        //戴镜类型 1=戴镜，2=不带镜
        result.put("type", type);
        data.put("data", result);
        return R.ok(data);
    }

}
