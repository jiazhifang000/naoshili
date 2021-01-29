package com.naoshili.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-10-23 13:20:38
 */
public class RiliImportDataDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //实验序号
    private String dataId;
    //ch1
    private Double ch1;
    //ch2
    private Double ch2;
    //ch3
    private Double ch3;
    //ch4
    private Double ch4;
    //ch5
    private Double ch5;
    //ch6
    private Double ch6;
    //ch7
    private Double ch7;
    //ch8
    private Double ch8;
    //ch9
    private Double ch9;
    //ch10
    private Double ch10;
    //ch11
    private Double ch11;
    //ch12
    private Double ch12;
    //ch13
    private Double ch13;
    //ch14
    private Double ch14;
    //ch15
    private Double ch15;
    //ch16
    private Double ch16;
    //ch17
    private Double ch17;
    //ch18
    private Double ch18;
    //ch19
    private Double ch19;
    //ch20
    private Double ch20;
    //ch21
    private Double ch21;
    //ch22
    private Double ch22;
    //外部标记
    private String mark;
    //采集时间
    private String time;
    //文件类型，1=oxy,2=deoxy,3=total,4=mes
    private Integer type;

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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
     * 设置：ch1
     */
    public void setCh1(Double ch1) {
        this.ch1 = ch1;
    }

    /**
     * 获取：ch1
     */
    public Double getCh1() {
        return ch1;
    }

    /**
     * 设置：ch2
     */
    public void setCh2(Double ch2) {
        this.ch2 = ch2;
    }

    /**
     * 获取：ch2
     */
    public Double getCh2() {
        return ch2;
    }

    /**
     * 设置：ch3
     */
    public void setCh3(Double ch3) {
        this.ch3 = ch3;
    }

    /**
     * 获取：ch3
     */
    public Double getCh3() {
        return ch3;
    }

    /**
     * 设置：ch4
     */
    public void setCh4(Double ch4) {
        this.ch4 = ch4;
    }

    /**
     * 获取：ch4
     */
    public Double getCh4() {
        return ch4;
    }

    /**
     * 设置：ch5
     */
    public void setCh5(Double ch5) {
        this.ch5 = ch5;
    }

    /**
     * 获取：ch5
     */
    public Double getCh5() {
        return ch5;
    }

    /**
     * 设置：ch6
     */
    public void setCh6(Double ch6) {
        this.ch6 = ch6;
    }

    /**
     * 获取：ch6
     */
    public Double getCh6() {
        return ch6;
    }

    /**
     * 设置：ch7
     */
    public void setCh7(Double ch7) {
        this.ch7 = ch7;
    }

    /**
     * 获取：ch7
     */
    public Double getCh7() {
        return ch7;
    }

    /**
     * 设置：ch8
     */
    public void setCh8(Double ch8) {
        this.ch8 = ch8;
    }

    /**
     * 获取：ch8
     */
    public Double getCh8() {
        return ch8;
    }

    /**
     * 设置：ch9
     */
    public void setCh9(Double ch9) {
        this.ch9 = ch9;
    }

    /**
     * 获取：ch9
     */
    public Double getCh9() {
        return ch9;
    }

    /**
     * 设置：ch10
     */
    public void setCh10(Double ch10) {
        this.ch10 = ch10;
    }

    /**
     * 获取：ch10
     */
    public Double getCh10() {
        return ch10;
    }

    /**
     * 设置：ch11
     */
    public void setCh11(Double ch11) {
        this.ch11 = ch11;
    }

    /**
     * 获取：ch11
     */
    public Double getCh11() {
        return ch11;
    }

    /**
     * 设置：ch12
     */
    public void setCh12(Double ch12) {
        this.ch12 = ch12;
    }

    /**
     * 获取：ch12
     */
    public Double getCh12() {
        return ch12;
    }

    /**
     * 设置：ch13
     */
    public void setCh13(Double ch13) {
        this.ch13 = ch13;
    }

    /**
     * 获取：ch13
     */
    public Double getCh13() {
        return ch13;
    }

    /**
     * 设置：ch14
     */
    public void setCh14(Double ch14) {
        this.ch14 = ch14;
    }

    /**
     * 获取：ch14
     */
    public Double getCh14() {
        return ch14;
    }

    /**
     * 设置：ch15
     */
    public void setCh15(Double ch15) {
        this.ch15 = ch15;
    }

    /**
     * 获取：ch15
     */
    public Double getCh15() {
        return ch15;
    }

    /**
     * 设置：ch16
     */
    public void setCh16(Double ch16) {
        this.ch16 = ch16;
    }

    /**
     * 获取：ch16
     */
    public Double getCh16() {
        return ch16;
    }

    /**
     * 设置：ch17
     */
    public void setCh17(Double ch17) {
        this.ch17 = ch17;
    }

    /**
     * 获取：ch17
     */
    public Double getCh17() {
        return ch17;
    }

    /**
     * 设置：ch18
     */
    public void setCh18(Double ch18) {
        this.ch18 = ch18;
    }

    /**
     * 获取：ch18
     */
    public Double getCh18() {
        return ch18;
    }

    /**
     * 设置：ch19
     */
    public void setCh19(Double ch19) {
        this.ch19 = ch19;
    }

    /**
     * 获取：ch19
     */
    public Double getCh19() {
        return ch19;
    }

    /**
     * 设置：ch20
     */
    public void setCh20(Double ch20) {
        this.ch20 = ch20;
    }

    /**
     * 获取：ch20
     */
    public Double getCh20() {
        return ch20;
    }

    /**
     * 设置：ch21
     */
    public void setCh21(Double ch21) {
        this.ch21 = ch21;
    }

    /**
     * 获取：ch21
     */
    public Double getCh21() {
        return ch21;
    }

    /**
     * 设置：ch22
     */
    public void setCh22(Double ch22) {
        this.ch22 = ch22;
    }

    /**
     * 获取：ch22
     */
    public Double getCh22() {
        return ch22;
    }

    /**
     * 设置：外部标记
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 获取：外部标记
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置：采集时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取：采集时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置：文件类型，1=oxy,2=deoxy,3=total,4=mes
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：文件类型，1=oxy,2=deoxy,3=total,4=mes
     */
    public Integer getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RiliImportDataDO{" +
                "id=" + id +
                ", dataId='" + dataId + '\'' +
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
                ", mark='" + mark + '\'' +
                ", time='" + time + '\'' +
                ", type=" + type +
                ", file=" + file +
                '}';
    }
}
