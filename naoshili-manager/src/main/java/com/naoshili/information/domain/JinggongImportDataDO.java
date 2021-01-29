package com.naoshili.information.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;


/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-12-24 17:41:33
 */
public class JinggongImportDataDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //数据id
    private String dataId;
    //眼睛（L=左眼，R=右眼）
    private String eye;
    //屈光度
    private String diopter;
    //瞳距
    private String pupilDistance;
    //采样时间（s）
    private String useTime;
    //上传时间
    private Date addTime;

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
     * 设置：数据id
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /**
     * 获取：数据id
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * 设置：眼睛（L=左眼，R=右眼）
     */
    public void setEye(String eye) {
        this.eye = eye;
    }

    /**
     * 获取：眼睛（L=左眼，R=右眼）
     */
    public String getEye() {
        return eye;
    }

    /**
     * 设置：屈光度
     */
    public void setDiopter(String diopter) {
        this.diopter = diopter;
    }

    /**
     * 获取：屈光度
     */
    public String getDiopter() {
        return diopter;
    }

    /**
     * 设置：瞳距
     */
    public void setPupilDistance(String pupilDistance) {
        this.pupilDistance = pupilDistance;
    }

    /**
     * 获取：瞳距
     */
    public String getPupilDistance() {
        return pupilDistance;
    }

    /**
     * 设置：采样时间（s）
     */
    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    /**
     * 获取：采样时间（s）
     */
    public String getUseTime() {
        return useTime;
    }

    /**
     * 设置：上传时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取：上传时间
     */
    public Date getAddTime() {
        return addTime;
    }

    @Override
    public String toString() {
        return "JinggongImportDataDO{" +
                "id=" + id +
                ", dataId='" + dataId + '\'' +
                ", eye='" + eye + '\'' +
                ", diopter=" + diopter +
                ", pupilDistance=" + pupilDistance +
                ", useTime='" + useTime + '\'' +
                ", addTime=" + addTime +
                ", file=" + file +
                '}';
    }
}
