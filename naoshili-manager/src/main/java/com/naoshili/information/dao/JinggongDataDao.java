package com.naoshili.information.dao;

import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.domain.ZhiHouDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 精工5500数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
@Mapper
public interface JinggongDataDao {

    JinggongDataDO get(Long id);

    List<JinggongDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(JinggongDataDO jinggongData);

    int update(JinggongDataDO jinggongData);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<JinggongDataDO> groupbyDataId(Map<String, Object> map);

    int countGroupbyDataId(Map<String, Object> map);


    ZhiHouDO getLocation(@Param("samplingTime") String samplingTime, @Param("id") Long id);

    int deleteByDataid(Long id);

    List<JinggongDataDO> getList(Map<String, Object> map);

    String getCheckTime(String id);
}
