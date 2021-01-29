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
public class DataListDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //移动视标参数
    private ShibiaoMoveIfDO shibiaoMoveIfDO;
    //闪烁视标参数
    private ShibiaoTwinkleIfDO shibiaoTwinkleIfDO;
    //视标数据集合
    private List<ShibiaoDataDO> shibiaoDataDOList;
    //精工数据集合
    private List<JinggongDataDO> jinggongDataDOList;
    //日立数据集合
    private List<RiliDataDO> riliDataDOList;

    public ShibiaoMoveIfDO getShibiaoMoveIfDO() {
        return shibiaoMoveIfDO;
    }

    public void setShibiaoMoveIfDO(ShibiaoMoveIfDO shibiaoMoveIfDO) {
        this.shibiaoMoveIfDO = shibiaoMoveIfDO;
    }

    public ShibiaoTwinkleIfDO getShibiaoTwinkleIfDO() {
        return shibiaoTwinkleIfDO;
    }

    public void setShibiaoTwinkleIfDO(ShibiaoTwinkleIfDO shibiaoTwinkleIfDO) {
        this.shibiaoTwinkleIfDO = shibiaoTwinkleIfDO;
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

}
