package com.naoshili.information.service;

import com.naoshili.information.domain.ShibiaoDataDO;

import java.util.List;
import java.util.Map;

/**
 * 视标数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public interface ShibiaoDataService {

    ShibiaoDataDO get(Long id);

    List<ShibiaoDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShibiaoDataDO shibiaoData);

    int update(ShibiaoDataDO shibiaoData);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<ShibiaoDataDO> detaillist(Map<String, Object> map);

    int detailcount(Map<String, Object> map);

    int deleteByDataid(Long id);
}
