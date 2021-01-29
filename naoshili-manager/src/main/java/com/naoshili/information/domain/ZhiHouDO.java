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
public class ZhiHouDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String samplingTime;

    private Double diopter;
    // 时间
    private String time;

    // 位置（移动视标）
    private Integer localtion;
    // 速度（移动视标）
    private Double speed;
    // 差值
    private Double gap;
    // 位置
    private Integer localtion1;

}
