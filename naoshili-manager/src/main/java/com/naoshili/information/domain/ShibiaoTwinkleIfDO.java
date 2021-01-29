package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-09-23 16:25:44
 */
public class ShibiaoTwinkleIfDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //实验序号
    private String dataId;
    //数据类型
    private Integer dataType;
    //实验时间
    private Date testTime;
    //亮灯时长
    private Integer lightTime;
    //灭灯时长
    private Integer offlightTime;
    //预采集时间
    private Integer preliminaryAcquisitionTime;
    //凝视时间
    private Integer gazeTime;
    //第一次休息时间
    private Integer firstSleep;
    //交替次数
    private Integer alternateCount;
    //第二次休息时间
    private Integer secondSleep;
    //1号灯位置
    private Integer light1;
    //2号灯位置
    private Integer light2;
    //3号灯位置
    private Integer light3;
    //保存时间
    private Date saveTime;

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
     * 设置：实验序号
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /**
     * 获取：实验序号
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * 设置：数据类型
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取：数据类型
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * 设置：实验时间
     */
    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    /**
     * 获取：实验时间
     */
    public Date getTestTime() {
        return testTime;
    }

    /**
     * 设置：亮灯时长
     */
    public void setLightTime(Integer lightTime) {
        this.lightTime = lightTime;
    }

    /**
     * 获取：亮灯时长
     */
    public Integer getLightTime() {
        return lightTime;
    }

    /**
     * 设置：灭灯时长
     */
    public void setOfflightTime(Integer offlightTime) {
        this.offlightTime = offlightTime;
    }

    /**
     * 获取：灭灯时长
     */
    public Integer getOfflightTime() {
        return offlightTime;
    }

    /**
     * 设置：预采集时间
     */
    public void setPreliminaryAcquisitionTime(Integer preliminaryAcquisitionTime) {
        this.preliminaryAcquisitionTime = preliminaryAcquisitionTime;
    }

    /**
     * 获取：预采集时间
     */
    public Integer getPreliminaryAcquisitionTime() {
        return preliminaryAcquisitionTime;
    }

    /**
     * 设置：凝视时间
     */
    public void setGazeTime(Integer gazeTime) {
        this.gazeTime = gazeTime;
    }

    /**
     * 获取：凝视时间
     */
    public Integer getGazeTime() {
        return gazeTime;
    }

    /**
     * 设置：第一次休息时间
     */
    public void setFirstSleep(Integer firstSleep) {
        this.firstSleep = firstSleep;
    }

    /**
     * 获取：第一次休息时间
     */
    public Integer getFirstSleep() {
        return firstSleep;
    }

    /**
     * 设置：交替次数
     */
    public void setAlternateCount(Integer alternateCount) {
        this.alternateCount = alternateCount;
    }

    /**
     * 获取：交替次数
     */
    public Integer getAlternateCount() {
        return alternateCount;
    }

    /**
     * 设置：第二次休息时间
     */
    public void setSecondSleep(Integer secondSleep) {
        this.secondSleep = secondSleep;
    }

    /**
     * 获取：第二次休息时间
     */
    public Integer getSecondSleep() {
        return secondSleep;
    }

    /**
     * 设置：1号灯位置
     */
    public void setLight1(Integer light1) {
        this.light1 = light1;
    }

    /**
     * 获取：1号灯位置
     */
    public Integer getLight1() {
        return light1;
    }

    /**
     * 设置：2号灯位置
     */
    public void setLight2(Integer light2) {
        this.light2 = light2;
    }

    /**
     * 获取：2号灯位置
     */
    public Integer getLight2() {
        return light2;
    }

    /**
     * 设置：3号灯位置
     */
    public void setLight3(Integer light3) {
        this.light3 = light3;
    }

    /**
     * 获取：3号灯位置
     */
    public Integer getLight3() {
        return light3;
    }

    /**
     * 设置：保存时间
     */
    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    /**
     * 获取：保存时间
     */
    public Date getSaveTime() {
        return saveTime;
    }
}
