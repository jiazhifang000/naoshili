package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 视标数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class AllDataDO implements Serializable {
    private static final long serialVersionUID = 1L;


    //身份信息
    private CollectionInfoDO info;
    //视标数据集合
    private List<ShibiaoDataDO> shibiaoDataDOList;
    //精工数据集合
    private List<JinggongDataDO> jinggongDataDOList;
    //日立数据集合
    private List<RiliDataDO> riliDataDOList;

    public CollectionInfoDO getInfo() {
        return info;
    }

    public void setInfo(CollectionInfoDO info) {
        this.info = info;
    }

    public List<ShibiaoDataDO> getShibiaoDataDOList() {
        return shibiaoDataDOList;
    }

    public void setShibiaoDataDOList(List<ShibiaoDataDO> shibiaoDataDOList) {
        this.shibiaoDataDOList = shibiaoDataDOList;
    }

    public List<JinggongDataDO> getJinggongDataDOList() {
        return jinggongDataDOList;
    }

    public void setJinggongDataDOList(List<JinggongDataDO> jinggongDataDOList) {
        this.jinggongDataDOList = jinggongDataDOList;
    }

    public List<RiliDataDO> getRiliDataDOList() {
        return riliDataDOList;
    }

    public void setRiliDataDOList(List<RiliDataDO> riliDataDOList) {
        this.riliDataDOList = riliDataDOList;
    }

    @Override
    public String toString() {
        return "AllDataDO{" +
                "info=" + info +
                ", shibiaoDataDOList=" + shibiaoDataDOList +
                ", jinggongDataDOList=" + jinggongDataDOList +
                ", riliDataDOList=" + riliDataDOList +
                '}';
    }
}
