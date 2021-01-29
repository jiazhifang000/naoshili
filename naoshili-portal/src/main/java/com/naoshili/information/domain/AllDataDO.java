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

    private List<DataListDO> data;


    public CollectionInfoDO getInfo() {
        return info;
    }

    public void setInfo(CollectionInfoDO info) {
        this.info = info;
    }

    public List<DataListDO> getData() {
        return data;
    }

    public void setData(List<DataListDO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AllDataDO{" +
                "info=" + info +
                ", data=" + data +
                '}';
    }
}
