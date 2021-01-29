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
    private String testTime;
    //速度
    private int speed;
    //运动轨迹 1=
    private Integer motionTrail;
    //视标亮灭 1=亮，2=灭
    private Integer lightIf;
    //位置信息
    private String locationInfo;
    //保存时间
    private Date saveTime;

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


    public int getPreliminaryAcquisitionTime() {
        return preliminaryAcquisitionTime;
    }

    public void setPreliminaryAcquisitionTime(int preliminaryAcquisitionTime) {
        this.preliminaryAcquisitionTime = preliminaryAcquisitionTime;
    }

    public int getLocationStart() {
        return locationStart;
    }

    public void setLocationStart(int locationStart) {
        this.locationStart = locationStart;
    }

    public int getCollectTimeStart() {
        return collectTimeStart;
    }

    public void setCollectTimeStart(int collectTimeStart) {
        this.collectTimeStart = collectTimeStart;
    }

    public int getSleepStart() {
        return sleepStart;
    }

    public void setSleepStart(int sleepStart) {
        this.sleepStart = sleepStart;
    }

    public int getLocation2() {
        return location2;
    }

    public void setLocation2(int location2) {
        this.location2 = location2;
    }

    public int getCollectTime2() {
        return collectTime2;
    }

    public void setCollectTime2(int collectTime2) {
        this.collectTime2 = collectTime2;
    }

    public int getSleep2() {
        return sleep2;
    }

    public void setSleep2(int sleep2) {
        this.sleep2 = sleep2;
    }

    public int getLocation3() {
        return location3;
    }

    public void setLocation3(int location3) {
        this.location3 = location3;
    }

    public int getCollectTime3() {
        return collectTime3;
    }

    public void setCollectTime3(int collectTime3) {
        this.collectTime3 = collectTime3;
    }

    public int getSleep3() {
        return sleep3;
    }

    public void setSleep3(int sleep3) {
        this.sleep3 = sleep3;
    }

    public int getLocation4() {
        return location4;
    }

    public void setLocation4(int location4) {
        this.location4 = location4;
    }

    public int getCollectTime4() {
        return collectTime4;
    }

    public void setCollectTime4(int collectTime4) {
        this.collectTime4 = collectTime4;
    }

    public int getSleep4() {
        return sleep4;
    }

    public void setSleep4(int sleep4) {
        this.sleep4 = sleep4;
    }

    public int getLocationEnd() {
        return locationEnd;
    }

    public void setLocationEnd(int locationEnd) {
        this.locationEnd = locationEnd;
    }

    public int getCollectTimeEnd() {
        return collectTimeEnd;
    }

    public void setCollectTimeEnd(int collectTimeEnd) {
        this.collectTimeEnd = collectTimeEnd;
    }

    public int getSleepEnd() {
        return sleepEnd;
    }

    public void setSleepEnd(int sleepEnd) {
        this.sleepEnd = sleepEnd;
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
    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    /**
     * 获取：实验时间
     */
    public String getTestTime() {
        return testTime;
    }

    /**
     * 设置：速度
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * 获取：速度
     */
    public int getSpeed() {
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
