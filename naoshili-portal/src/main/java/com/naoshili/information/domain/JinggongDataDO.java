package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 精工5500数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class JinggongDataDO implements Serializable {
    private static final long serialVersionUID = 1L;


    //id
    private Long id;
    //单次数据序号
    private String dataId;
    //采样时间间隔
    private String samplingTime;
    //采集方式（1 静止视标 2 运动静止视标 3 运动实时视标 4 交替视标）
    private Integer experimentalMode;
    //R 右眼  L左眼
    private String eye;
    //屈光度
    private Double diopter;
    //瞳距
    private Double pupilDistance;

    private Date addTime;

    private Integer location;

    private int num;

    //外部触发标记
    private String externalTriggerMark;

    private String originalData;

    public String getOriginalData() {
        return originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    public String getExternalTriggerMark() {
        return externalTriggerMark;
    }

    public void setExternalTriggerMark(String externalTriggerMark) {
        this.externalTriggerMark = externalTriggerMark;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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
     * 设置：采样时间间隔
     */
    public void setSamplingTime(String samplingTime) {
        this.samplingTime = samplingTime;
    }

    /**
     * 获取：采样时间间隔
     */
    public String getSamplingTime() {
        return samplingTime;
    }

    /**
     * 设置：采集方式（1 静止视标 2 运动静止视标 3 运动实时视标 4 交替视标）
     */
    public void setExperimentalMode(Integer experimentalMode) {
        this.experimentalMode = experimentalMode;
    }

    /**
     * 获取：采集方式（1 静止视标 2 运动静止视标 3 运动实时视标 4 交替视标）
     */
    public Integer getExperimentalMode() {
        return experimentalMode;
    }

    /**
     * 设置：R 右眼  L左眼
     */
    public void setEye(String eye) {
        this.eye = eye;
    }

    /**
     * 获取：R 右眼  L左眼
     */
    public String getEye() {
        return eye;
    }

    /**
     * 设置：屈光度
     */
    public void setDiopter(Double diopter) {
        this.diopter = diopter;
    }

    /**
     * 获取：屈光度
     */
    public Double getDiopter() {
        return diopter;
    }

    /**
     * 设置：瞳距
     */
    public void setPupilDistance(Double pupilDistance) {
        this.pupilDistance = pupilDistance;
    }

    /**
     * 获取：瞳距
     */
    public Double getPupilDistance() {
        return pupilDistance;
    }

    @Override
    public String toString() {
        return "JinggongDataDO{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", samplingTime='" + samplingTime + '\'' +
                ", eye='" + eye + '\'' +
                ", diopter=" + diopter +
                ", pupilDistance=" + pupilDistance +
                '}';
    }
}
