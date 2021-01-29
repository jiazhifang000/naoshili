package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 日立4000数据
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class RiliDataDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //单次数据序号
    private String dataId;
    //采集时间（精确到秒）
    private String time;
    //采集方式（1 静止视标 2 运动静止视标 3 运动实时视标 4 交替视标）
    private Integer experimentalMode;
    //同步标记
    private String synchronizationMark;
    //外部触发标记
    private String externalTriggerMark;
    //脑氧类型 type=oxy(有氧) type=deoxy(无氧)
    private String type;
    //CH1
    private Double ch1;
    //CH2
    private Double ch2;
    //CH3
    private Double ch3;
    //CH4
    private Double ch4;
    //CH5
    private Double ch5;
    //CH6
    private Double ch6;
    //CH7
    private Double ch7;
    //CH8
    private Double ch8;
    //CH9
    private Double ch9;
    //CH10
    private Double ch10;
    //CH11
    private Double ch11;
    //CH12
    private Double ch12;
    //CH13
    private Double ch13;
    //CH14
    private Double ch14;
    //CH15
    private Double ch15;
    //CH16
    private Double ch16;
    //CH17
    private Double ch17;
    //CH18
    private Double ch18;
    //CH19
    private Double ch19;
    //CH20
    private Double ch20;
    //CH21
    private Double ch21;
    //CH22
    private Double ch22;

    private Date addTime;


    private int num;

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 设置：同步标记
     */
    public void setSynchronizationMark(String synchronizationMark) {
        this.synchronizationMark = synchronizationMark;
    }

    /**
     * 获取：同步标记
     */
    public String getSynchronizationMark() {
        return synchronizationMark;
    }

    /**
     * 设置：外部触发标记
     */
    public void setExternalTriggerMark(String externalTriggerMark) {
        this.externalTriggerMark = externalTriggerMark;
    }

    /**
     * 获取：外部触发标记
     */
    public String getExternalTriggerMark() {
        return externalTriggerMark;
    }

    /**
     * 设置：CH1
     */
    public void setCh1(Double ch1) {
        this.ch1 = ch1;
    }

    /**
     * 获取：CH1
     */
    public Double getCh1() {
        return ch1;
    }

    /**
     * 设置：CH2
     */
    public void setCh2(Double ch2) {
        this.ch2 = ch2;
    }

    /**
     * 获取：CH2
     */
    public Double getCh2() {
        return ch2;
    }

    /**
     * 设置：CH3
     */
    public void setCh3(Double ch3) {
        this.ch3 = ch3;
    }

    /**
     * 获取：CH3
     */
    public Double getCh3() {
        return ch3;
    }

    /**
     * 设置：CH4
     */
    public void setCh4(Double ch4) {
        this.ch4 = ch4;
    }

    /**
     * 获取：CH4
     */
    public Double getCh4() {
        return ch4;
    }

    /**
     * 设置：CH5
     */
    public void setCh5(Double ch5) {
        this.ch5 = ch5;
    }

    /**
     * 获取：CH5
     */
    public Double getCh5() {
        return ch5;
    }

    /**
     * 设置：CH6
     */
    public void setCh6(Double ch6) {
        this.ch6 = ch6;
    }

    /**
     * 获取：CH6
     */
    public Double getCh6() {
        return ch6;
    }

    /**
     * 设置：CH7
     */
    public void setCh7(Double ch7) {
        this.ch7 = ch7;
    }

    /**
     * 获取：CH7
     */
    public Double getCh7() {
        return ch7;
    }

    /**
     * 设置：CH8
     */
    public void setCh8(Double ch8) {
        this.ch8 = ch8;
    }

    /**
     * 获取：CH8
     */
    public Double getCh8() {
        return ch8;
    }

    /**
     * 设置：CH9
     */
    public void setCh9(Double ch9) {
        this.ch9 = ch9;
    }

    /**
     * 获取：CH9
     */
    public Double getCh9() {
        return ch9;
    }

    /**
     * 设置：CH10
     */
    public void setCh10(Double ch10) {
        this.ch10 = ch10;
    }

    /**
     * 获取：CH10
     */
    public Double getCh10() {
        return ch10;
    }

    /**
     * 设置：CH11
     */
    public void setCh11(Double ch11) {
        this.ch11 = ch11;
    }

    /**
     * 获取：CH11
     */
    public Double getCh11() {
        return ch11;
    }

    /**
     * 设置：CH12
     */
    public void setCh12(Double ch12) {
        this.ch12 = ch12;
    }

    /**
     * 获取：CH12
     */
    public Double getCh12() {
        return ch12;
    }

    /**
     * 设置：CH13
     */
    public void setCh13(Double ch13) {
        this.ch13 = ch13;
    }

    /**
     * 获取：CH13
     */
    public Double getCh13() {
        return ch13;
    }

    /**
     * 设置：CH14
     */
    public void setCh14(Double ch14) {
        this.ch14 = ch14;
    }

    /**
     * 获取：CH14
     */
    public Double getCh14() {
        return ch14;
    }

    /**
     * 设置：CH15
     */
    public void setCh15(Double ch15) {
        this.ch15 = ch15;
    }

    /**
     * 获取：CH15
     */
    public Double getCh15() {
        return ch15;
    }

    /**
     * 设置：CH16
     */
    public void setCh16(Double ch16) {
        this.ch16 = ch16;
    }

    /**
     * 获取：CH16
     */
    public Double getCh16() {
        return ch16;
    }

    /**
     * 设置：CH17
     */
    public void setCh17(Double ch17) {
        this.ch17 = ch17;
    }

    /**
     * 获取：CH17
     */
    public Double getCh17() {
        return ch17;
    }

    /**
     * 设置：CH18
     */
    public void setCh18(Double ch18) {
        this.ch18 = ch18;
    }

    /**
     * 获取：CH18
     */
    public Double getCh18() {
        return ch18;
    }

    /**
     * 设置：CH19
     */
    public void setCh19(Double ch19) {
        this.ch19 = ch19;
    }

    /**
     * 获取：CH19
     */
    public Double getCh19() {
        return ch19;
    }

    /**
     * 设置：CH20
     */
    public void setCh20(Double ch20) {
        this.ch20 = ch20;
    }

    /**
     * 获取：CH20
     */
    public Double getCh20() {
        return ch20;
    }

    /**
     * 设置：CH21
     */
    public void setCh21(Double ch21) {
        this.ch21 = ch21;
    }

    /**
     * 获取：CH21
     */
    public Double getCh21() {
        return ch21;
    }

    /**
     * 设置：CH22
     */
    public void setCh22(Double ch22) {
        this.ch22 = ch22;
    }

    /**
     * 获取：CH22
     */
    public Double getCh22() {
        return ch22;
    }

    @Override
    public String toString() {
        return "RiliDataDO{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", time='" + time + '\'' +
                ", synchronizationMark='" + synchronizationMark + '\'' +
                ", externalTriggerMark='" + externalTriggerMark + '\'' +
                ", type='" + type + '\'' +
                ", ch1=" + ch1 +
                ", ch2=" + ch2 +
                ", ch3=" + ch3 +
                ", ch4=" + ch4 +
                ", ch5=" + ch5 +
                ", ch6=" + ch6 +
                ", ch7=" + ch7 +
                ", ch8=" + ch8 +
                ", ch9=" + ch9 +
                ", ch10=" + ch10 +
                ", ch11=" + ch11 +
                ", ch12=" + ch12 +
                ", ch13=" + ch13 +
                ", ch14=" + ch14 +
                ", ch15=" + ch15 +
                ", ch16=" + ch16 +
                ", ch17=" + ch17 +
                ", ch18=" + ch18 +
                ", ch19=" + ch19 +
                ", ch20=" + ch20 +
                ", ch21=" + ch21 +
                ", ch22=" + ch22 +
                '}';
    }
}
