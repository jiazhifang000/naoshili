package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 移动视标实验条件表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-09-23 16:25:44
 */
public class ShibiaoMoveIfDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //实验序号
    private String dataId;


    //实验类型
    private Integer dataType;
    //实验时间
    private Date testTime;
    //速度
    private Double speed;
    //运动轨迹 1=由远及近，2=由近及远
    private Integer motionTrail;
    //视标亮灭 1=亮，2=灭
    private Integer lightIf;
    //位置信息
    /**
     * 预采集时间，位置1，采集时间，休息时间，位置2，采集时间，休息时间，位置3，采集时间，休息时间，位置4，采集时间，休息时间，位置5，采集时间，休息时间
     * [{"preliminaryAcquisitionTime":20,"locationStart":20,"collectTimeStart":10,"sleepStart":2,
     * "location2":50,"collectTime2":10,"sleep2":2,"location3":50,"collectTime3":10,"sleep3":2,"location4":50,"collectTime4":10,"sleep4":2,
     * "locationEnd":50,"collectTimeEnd":10,"sleepEnd":2}]
     */
    private String locationInfo;
    //保存时间
    private Date saveTime;

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /**
     * 设置：id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：id
     */
    public Integer getId() {
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
     * 设置：实验类型
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取：实验类型
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
     * 设置：速度
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 获取：速度
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 设置：运动轨迹 1=
     */
    public void setMotionTrail(Integer motionTrail) {
        this.motionTrail = motionTrail;
    }

    /**
     * 获取：运动轨迹 1=
     */
    public Integer getMotionTrail() {
        return motionTrail;
    }

    /**
     * 设置：视标亮灭 1=亮，2=灭
     */
    public void setLightIf(Integer lightIf) {
        this.lightIf = lightIf;
    }

    /**
     * 获取：视标亮灭 1=亮，2=灭
     */
    public Integer getLightIf() {
        return lightIf;
    }

    /**
     * 设置：位置信息
     */
    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    /**
     * 获取：位置信息
     */
    public String getLocationInfo() {
        return locationInfo;
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
