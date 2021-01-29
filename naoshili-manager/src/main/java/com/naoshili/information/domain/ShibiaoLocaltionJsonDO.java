package com.naoshili.information.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 采集数据基本信息
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
@Data
public class ShibiaoLocaltionJsonDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //预采集时间
    private int preliminaryAcquisitionTime;
    //开始采集位置
    private int locationStart;
    //开始采集时长
    private int collectTimeStart;
    //开始休息时间
    private int sleepStart;
    //第二次采集位置
    private int location2;
    //第二次采集时长
    private int collectTime2;
    //第二次休息时间
    private int sleep2;
    //第三次采集位置
    private int location3;
    //第三次采集时长
    private int collectTime3;
    //第三次休息时间
    private int sleep3;
    //第四次采集位置
    private int location4;
    //第四次采集时长
    private int collectTime4;
    //第四次休息时间
    private int sleep4;
    //终点位置
    private int locationEnd;
    //终点采集时长
    private int collectTimeEnd;
    //终点休息时长
    private int sleepEnd;


}
