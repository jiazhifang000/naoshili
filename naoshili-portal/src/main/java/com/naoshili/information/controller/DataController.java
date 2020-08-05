package com.naoshili.information.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.naoshili.common.annotation.Log;
import com.naoshili.common.config.BootdoConfig;
import com.naoshili.common.controller.BaseController;
import com.naoshili.common.utils.FileUtil;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.AllDataDO;
import com.naoshili.information.service.CollectionInfoService;
import com.naoshili.information.service.JinggongDataService;
import com.naoshili.information.service.RiliDataService;
import com.naoshili.information.service.ShibiaoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Controller
@RequestMapping("/dataController")
public class DataController extends BaseController {

    @Autowired
    CollectionInfoService collectionInfoService;
    @Autowired
    ShibiaoDataService shibiaoDataService;
    @Autowired
    JinggongDataService jinggongDataService;
    @Autowired
    RiliDataService riliDataService;
    @Autowired
    private BootdoConfig bootdoConfig;

    /**
     * 参数：精工数据集合
     */
    @Log("保存数据")
    @PostMapping("/saveData")
    @ResponseBody
    R saveJinggongData(@RequestBody MultipartFile dataFile) {

        try {
            //获取文件
            String filename = dataFile.getOriginalFilename();
            FileUtil.uploadFile(dataFile.getBytes(), bootdoConfig.getUploadPath() + "/temporaryFiles/", filename);
            File file = new File(bootdoConfig.getUploadPath() + "/temporaryFiles/" + filename);
            FileReader in = new FileReader(file);
            BufferedReader br = new BufferedReader(in);
            //读取文件
            String str = "";
            String json = "";
            while ((str = br.readLine()) != null) {
                json += str;
            }
            if (json != null) {
                JSONObject data = JSONObject.parseObject(new String(json));
                AllDataDO allDataDO = JSON.toJavaObject(data, AllDataDO.class);
                //保存数据
                if (allDataDO != null) {
                    int result = collectionInfoService.saveData(allDataDO);

                    if (result > 0) {
                        return R.ok();
                    } else {
                        return R.error(-1, "保存失败");
                    }
                } else {
                    return R.error(-1, "无数据");
                }
            } else {
                return R.error(-1, "无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(500, e.toString());
        }

    }

}
