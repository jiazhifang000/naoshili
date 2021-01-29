package com.naoshili.information.service;

import com.naoshili.information.domain.ShibiaoTwinkleIfDO;

import java.util.List;
import java.util.Map;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-09-23 16:25:44
 */
public interface ShibiaoTwinkleIfService {

    ShibiaoTwinkleIfDO get(Long id);

    List<ShibiaoTwinkleIfDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShibiaoTwinkleIfDO shibiaoTwinkleIf);

    int update(ShibiaoTwinkleIfDO shibiaoTwinkleIf);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int deleteByDataid(Long id);
}
