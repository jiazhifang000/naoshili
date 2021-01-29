package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 视标数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class ShibiaoDataDO implements Serializable {
    private static final long serialVersionUID = 1L;


    // id
    private Long id;
    // 单次数据序号
    private String dataId;
    //采集方式（1 静止视标 2 运动静止视标 3 运动实时视标 4 交替视标）
    private Integer experimentalMode;
    // 时间
    private String time;
    // 位置（移动视标）
    private Integer localtion;
    // 速度（移动视标）
    private Double speed;
    // 视标1（交替通断）
    private Double visualStandard1;
    // 视标2（交替通断）
    private Double visualStandard2;
    // 视标3（交替通断）
    private Double visualStandard3;

    private Date addTime;

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getExperimentalMode() {
        return experimentalMode;
    }

    public void setExperimentalMode(Integer experimentalMode) {
        this.experimentalMode = experimentalMode;
    }

    /**
     * 设置：id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：单次数据序号
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /**
     * 获取：单次数据序号
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * 设置：时间
     */

    /**
     * 设置：位置（移动视标）
     */
    public void setLocaltion(Integer localtion) {
        this.localtion = localtion;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取：位置（移动视标）
     */
    public Integer getLocaltion() {
        return localtion;
    }

    /**
     * 设置：速度（移动视标）
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 获取：速度（移动视标）
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 设置：视标1（交替通断）
     */
    public void setVisualStandard1(Double visualStandard1) {
        this.visualStandard1 = visualStandard1;
    }

    /**
     * 获取：视标1（交替通断）
     */
    public Double getVisualStandard1() {
        return visualStandard1;
    }

    /**
     * 设置：视标2（交替通断）
     */
    public void setVisualStandard2(Double visualStandard2) {
        this.visualStandard2 = visualStandard2;
    }

    /**
     * 获取：视标2（交替通断）
     */
    public Double getVisualStandard2() {
        return visualStandard2;
    }

    /**
     * 设置：视标3（交替通断）
     */
    public void setVisualStandard3(Double visualStandard3) {
        this.visualStandard3 = visualStandard3;
    }

    /**
     * 获取：视标3（交替通断）
     */
    public Double getVisualStandard3() {
        return visualStandard3;
    }

    @Override
    public String toString() {
        return "ShibiaoDataDO{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", time=" + time +
                ", localtion=" + localtion +
                ", speed=" + speed +
                ", visualStandard1=" + visualStandard1 +
                ", visualStandard2=" + visualStandard2 +
                ", visualStandard3=" + visualStandard3 +
                '}';
    }
}
