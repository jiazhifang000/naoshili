package com.naoshili.information.controller;

import com.naoshili.common.utils.ExcelExportUtil4DIY;
import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.domain.UserBasicDO;
import com.naoshili.information.service.CollectionInfoService;
import com.naoshili.information.service.JinggongDataService;
import com.naoshili.information.service.UserBasicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 精工5500数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */

@Controller
@RequestMapping("/information/jinggongData")
public class JinggongDataController {
    @Autowired
    private JinggongDataService jinggongDataService;

    @Autowired
    private CollectionInfoService collectionInfoService;
    @Autowired
    private UserBasicService userBasicService;


    @GetMapping("/jinggongList")
    @RequiresPermissions("information:jinggongData:jinggongData")
    String jinggongList() {
        return "information/jinggongData/jinggongList";
    }

    @GetMapping("/jinggongListData")
    @RequiresPermissions("information:jinggongData:jinggongData")
    @ResponseBody
    public PageUtils jinggongListData(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<JinggongDataDO> jinggongDataList = jinggongDataService.groupbyDataId(query);

        for (JinggongDataDO jinggongDataDO : jinggongDataList) {
            jinggongDataDO.setUserId(collectionInfoService.get(Long.parseLong(jinggongDataDO.getDataId())).getUserId().toString());
        }
        int total = jinggongDataService.countGroupbyDataId(query);

        PageUtils pageUtils = new PageUtils(jinggongDataList, total);

        return pageUtils;
    }

    @GetMapping("/detail/{id}")
    @RequiresPermissions("information:jinggongData:jinggongData")
    String JinggongData(@PathVariable("id") String id, Model model) {
        Map<String, Object> params = new HashMap<>();

        params.put("dataId", id);
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
        model.addAttribute("rJinggong", right);
        model.addAttribute("lJinggong", left);
        model.addAttribute("xr", xr);
        model.addAttribute("xl", xl);
        model.addAttribute("indexsr", indexsr);
        model.addAttribute("indexsl", indexsl);
        model.addAttribute("id", id);
        return "information/jinggongData/jinggongData";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:jinggongData:jinggongData")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<JinggongDataDO> jinggongDataList = jinggongDataService.list(query);
        int total = jinggongDataService.count(query);
        PageUtils pageUtils = new PageUtils(jinggongDataList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:jinggongData:add")
    String add() {
        return "information/jinggongData/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:jinggongData:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        JinggongDataDO jinggongData = jinggongDataService.get(id);
        model.addAttribute("jinggongData", jinggongData);
        return "information/jinggongData/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:jinggongData:add")
    public R save(JinggongDataDO jinggongData) {
        if (jinggongDataService.save(jinggongData) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:jinggongData:edit")
    public R update(JinggongDataDO jinggongData) {
        jinggongDataService.update(jinggongData);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:jinggongData:remove")
    public R remove(Long id) {
        if (jinggongDataService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:jinggongData:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        jinggongDataService.batchRemove(ids);
        return R.ok();
    }


    //导出左眼
    @GetMapping("/export")
    void exportR(String id, Integer type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> bb = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        //类型区分左右眼
        params.put("dataId", id);
        if (type == 1) {
            params.put("eye", "L");
        } else if (type == 2) {
            params.put("eye", "R");
        }
        List<JinggongDataDO> list = jinggongDataService.list(params);

        //查询用户id
        Long userid = 0L;
        if (list.size() > 0) {
            userid = collectionInfoService.get(Long.parseLong(list.get(0).getDataId())).getUserId();
        }

        //查询用户信息
        map.put("userId", userid);
        UserBasicDO userBasicDO = new UserBasicDO();
        if (userBasicService.list(map).size() > 0) {
            userBasicDO = userBasicService.list(map).get(0);
        }
        if (list.size() > 0) {

            for (JinggongDataDO ujl : list) {
                Map<String, Object> mapp = new LinkedHashMap<>();
                mapp.put("用户id", userid);
                mapp.put("用户名", userBasicDO.getName());
                mapp.put("实验序号", ujl.getDataId());
                if (ujl.getExperimentalMode() == 1) {
                    mapp.put("实验类型", "多段移动视标试验");
                } else if (ujl.getExperimentalMode() == 2) {
                    mapp.put("实验类型", "单段移动视标试验");
                } else if (ujl.getExperimentalMode() == 3) {
                    mapp.put("实验类型", "闪烁视标试验");
                } else {
                    mapp.put("实验类型", "");
                }

                mapp.put("采样时间", ujl.getSamplingTime());
                mapp.put("外部标记", ujl.getExternalTriggerMark());
                mapp.put("眼睛", ujl.getEye());
                mapp.put("屈光度", ujl.getDiopter());
                mapp.put("瞳距", ujl.getPupilDistance());

                bb.add(mapp);
            }

        } else {
            Map<String, Object> mapP = new HashMap<String, Object>();
            mapP.put("信息", "暂无数据！！！");
            bb.add(mapP);
        }
        String filename = "";
        if (type == 1) {
            filename = id + "_5500" + "L" + ".xls";
        } else if (type == 2) {
            filename = id + "_5500" + "R" + ".xls";
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


    //把文件保存到临时文件
    public void download(HttpServletRequest request, HttpServletResponse response, String template, String newWordName, Map dataMap) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加到压缩包
     */
    public static void craeteZipPath(String path, HttpServletResponse response) throws IOException {

        ZipOutputStream zipOutputStream = null;
        OutputStream output = response.getOutputStream();
//        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".zip");
        response.setContentType("application/zip");
        zipOutputStream = new ZipOutputStream(output, Charset.forName("GBK"));
        File[] files = new File(path).listFiles();
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[1024];
        int len = 0;
        if (files != null && files.length > 0) {
            for (File wordFile : files) {
                String fileName = wordFile.getName();
                fileInputStream = new FileInputStream(wordFile);
                //放入压缩zip包中;
                zipOutputStream.putNextEntry(new ZipEntry(fileName));

                //读取文件;
                while ((len = fileInputStream.read(buf)) > 0) {
                    zipOutputStream.write(buf, 0, len);
                }
                //关闭;
                zipOutputStream.closeEntry();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        }

        if (zipOutputStream != null) {
            zipOutputStream.close();
        }
    }
}
