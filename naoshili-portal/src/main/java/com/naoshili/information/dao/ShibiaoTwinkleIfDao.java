package com.naoshili.information.dao;

import com.naoshili.information.domain.ShibiaoTwinkleIfDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-09-23 16:25:44
 */
@Mapper
public interface ShibiaoTwinkleIfDao {

    ShibiaoTwinkleIfDO get(Long id);

    List<ShibiaoTwinkleIfDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShibiaoTwinkleIfDO shibiaoTwinkleIf);

    int update(ShibiaoTwinkleIfDO shibiaoTwinkleIf);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
