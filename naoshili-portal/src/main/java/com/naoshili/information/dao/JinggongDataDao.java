package com.naoshili.information.dao;

import com.naoshili.information.domain.JinggongDataDO;
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

    int insertList(@Param("jinggongDataDOList") List<JinggongDataDO> jinggongDataDOList);
}
