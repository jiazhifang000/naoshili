package com.naoshili.information.service;

import com.naoshili.information.domain.AllDataDO;

/**
 * 采集数据基本信息
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public interface CollectionInfoService {

    int saveData(AllDataDO allDataDO);
}
