package com.naoshili.information.controller;

import com.naoshili.common.utils.*;
import com.naoshili.information.domain.JinggongImportDataDO;
import com.naoshili.information.service.JinggongImportDataService;
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
 * @date 2020-12-24 17:41:33
 */

@Controller
@RequestMapping("/information/jinggongImportData")
public class JinggongImportDataController {
    @Autowired
    private JinggongImportDataService jinggongImportDataService;

    @GetMapping("/jinggongImportData/{id}")
    @RequiresPermissions("information:jinggongImportData:jinggongImportData")
    String JinggongImportData(@PathVariable("id") String dataid, Model model) {
        Map<String, Object> params = new HashMap<>();

        params.put("dataId", dataid);
        params.put("eye", "R");
        List<JinggongImportDataDO> rJinggong = jinggongImportDataService.list(params);


        String[] right = new String[rJinggong.size()];
        String[] xr = new String[rJinggong.size()];

        int i = 0;
        for (JinggongImportDataDO elemeterInfo : rJinggong) {
            String eleseq = elemeterInfo.getDiopter();
            right[i] = eleseq;
            xr[i] = elemeterInfo.getUseTime();
            i++;
        }

        int j = 0;
        /*左眼屈光度*/
        params.remove("eye");
        params.put("eye", "L");
        List<JinggongImportDataDO> lJinggong = jinggongImportDataService.list(params);
        String[] left = new String[lJinggong.size()];
        String[] xl = new String[lJinggong.size()];
        for (JinggongImportDataDO jinggongImportDataDO : lJinggong) {
            String diopter = jinggongImportDataDO.getDiopter();
            left[j] = diopter;
            xl[j] = jinggongImportDataDO.getUseTime();
            j++;
        }


        model.addAttribute("rJinggong", right);
        model.addAttribute("lJinggong", left);
        model.addAttribute("xr", xr);
        model.addAttribute("xl", xl);
        model.addAttribute("dataId", dataid);
        return "information/jinggongImportData/jinggongImportData";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:jinggongImportData:jinggongImportData")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<JinggongImportDataDO> jinggongImportDataList = jinggongImportDataService.list(query);
        int total = jinggongImportDataService.count(query);
        PageUtils pageUtils = new PageUtils(jinggongImportDataList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:jinggongImportData:add")
    String add() {
        return "information/jinggongImportData/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:jinggongImportData:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        JinggongImportDataDO jinggongImportData = jinggongImportDataService.get(id);
        model.addAttribute("jinggongImportData", jinggongImportData);
        return "information/jinggongImportData/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:jinggongImportData:add")
    public R save(JinggongImportDataDO jinggongImportData) {
        if (jinggongImportDataService.save(jinggongImportData) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:jinggongImportData:edit")
    public R update(JinggongImportDataDO jinggongImportData) {
        jinggongImportDataService.update(jinggongImportData);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:jinggongImportData:remove")
    public R remove(Long id) {
        if (jinggongImportDataService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:jinggongImportData:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        jinggongImportDataService.batchRemove(ids);
        return R.ok();
    }

    @GetMapping("/importCsv/{id}")
    String importCsv(@PathVariable("id") String dataId, Model model) {
        model.addAttribute("id", dataId);
        return "information/jinggongImportData/import";
    }

    @PostMapping("/ajaxImport")
    @ResponseBody
    R ajaxImport(JinggongImportDataDO jinggongImportDataDO) {
        //第一步，读数据
        List<String> strings = null;
        try {
            strings = importCsv(MultipartFileToFile.multipartFileToFile(jinggongImportDataDO.getFile()));
            if (strings != null && !strings.isEmpty()) {
                List<String> list = new ArrayList<>();
                List<String[]> newlist = new ArrayList<>();
                List<String[]> nextlist = new ArrayList<>();
                List<JinggongImportDataDO> jinggongImportDataDOList = new ArrayList<>();

                //第二步，截取1行之后的数据
                for (int i = 1; i < strings.size(); i++) {
                    list.add(strings.get(i));
                }

                //,切割列
                for (String s : list) {
                    String[] string = s.split(",");
                    newlist.add(string);
                }

                for (int i = 0; i < newlist.size(); i++) {
                    JinggongImportDataDO jinggongImportDataDO1 = new JinggongImportDataDO();

                    jinggongImportDataDO1.setUseTime((newlist.get(i)[0]));
                    jinggongImportDataDO1.setEye((newlist.get(i)[1]));

                    jinggongImportDataDO1.setDiopter(newlist.get(i)[3]);
                    jinggongImportDataDO1.setPupilDistance(newlist.get(i)[4]);
                    jinggongImportDataDO1.setDataId(jinggongImportDataDO.getDataId());
                    jinggongImportDataDO1.setAddTime(new Date());
                    jinggongImportDataDOList.add(jinggongImportDataDO1);
                }
                int result = jinggongImportDataService.saveList(jinggongImportDataDOList);

            }
        } catch (Exception e) {
            return R.error(e.toString());
        }
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
        List<JinggongImportDataDO> list = jinggongImportDataService.list(params);

        if (list.size() > 0) {

            for (JinggongImportDataDO ujl : list) {
                Map<String, Object> mapp = new LinkedHashMap<>();
                mapp.put("实验序号", ujl.getDataId());

                mapp.put("采样时间(s)", ujl.getUseTime());
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
            filename = id + "_5500导出" + "L" + ".xls";
        } else if (type == 2) {
            filename = id + "_5500导出" + "R" + ".xls";
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
