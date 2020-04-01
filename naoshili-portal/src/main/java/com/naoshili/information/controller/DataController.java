package com.naoshili.information.controller;

import com.naoshili.common.annotation.Log;
import com.naoshili.common.controller.BaseController;
import com.naoshili.common.utils.R;
import com.naoshili.information.domain.CollectionInfoDO;
import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.domain.RiliDataDO;
import com.naoshili.information.domain.ShibiaoDataDO;
import com.naoshili.information.service.CollectionInfoService;
import com.naoshili.information.service.JinggongDataService;
import com.naoshili.information.service.RiliDataService;
import com.naoshili.information.service.ShibiaoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/DataController")
public class DataController extends BaseController {

    @Autowired
    CollectionInfoService collectionInfoService;
    @Autowired
    ShibiaoDataService shibiaoDataService;
    @Autowired
    JinggongDataService jinggongDataService;
    @Autowired
    RiliDataService riliDataService;

    /**
     *参数：保存采集信息
     * */
    @Log("保存采集信息")
    @PostMapping("/saveCollectionInfo")
    @ResponseBody
    R saveCollectionInfo(CollectionInfoDO collectionInfoDO){
       if(collectionInfoService.save(collectionInfoDO) >0) {
           return R.ok("保存成功");
       }else{
           return R.error("保存失败");
       }
    }

    /**
     *参数：保存视标数据
     * */
    @Log("保存视标数据")
    @PostMapping("/saveShiBiaoData")
    @ResponseBody
    R saveShiBiaoData(@RequestBody List<ShibiaoDataDO> shibiaoDataDOList){
        System.out.println("==============shibiaoDataDOList=================="+shibiaoDataDOList);
        boolean flag = true;
        for (ShibiaoDataDO shibiaoDataDO : shibiaoDataDOList) {
            if(shibiaoDataService.save(shibiaoDataDO)>0) {
                continue;
            }else{
                flag = false;
            }
        }
        if(flag){
            return R.ok("保存成功");
        }else{
            for (ShibiaoDataDO shibiaoDataDO : shibiaoDataDOList) {
                shibiaoDataService.remove(shibiaoDataDO.getId());
            }
            return R.error("保存失败");
        }
    }


    /**
     *参数：精工数据集合
     * */
    @Log("保存精工数据")
    @PostMapping("/saveJinggongData")
    @ResponseBody
    R saveJinggongData(@RequestBody List<JinggongDataDO> jinggongDataDOList){

        boolean flag = true;
        for (JinggongDataDO jinggongDataDO : jinggongDataDOList) {
            if(jinggongDataService.save(jinggongDataDO)>0) {
                continue;
            }else{
                flag = false;
            }
        }
        if(flag){
            return R.ok("保存成功");
        }else{
            for (JinggongDataDO jinggongDataDO : jinggongDataDOList) {
                jinggongDataService.remove(jinggongDataDO.getId());
            }
            return R.error("保存失败");
        }
    }

    /**
     *参数：日立数据集合
     * */
    @Log("日立精工数据")
    @PostMapping("/saveRiLiData")
    @ResponseBody
    R saveRiLiData(@RequestBody List<RiliDataDO> riliDataDOList){
        boolean flag = true;
        for (RiliDataDO riliDataDO : riliDataDOList) {
            if(riliDataService.save(riliDataDO)>0) {
                continue;
            }else{
                flag = false;
            }
        }
        if(flag){
            return R.ok("保存成功");
        }else{
            for (RiliDataDO riliDataDO : riliDataDOList) {
                riliDataService.remove(riliDataDO.getId());

            }
            return R.error("保存失败");
        }
    }

}
