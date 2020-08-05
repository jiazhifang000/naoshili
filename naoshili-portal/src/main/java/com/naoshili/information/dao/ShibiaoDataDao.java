package com.naoshili.information.dao;

import com.naoshili.information.domain.ShibiaoDataDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 视标数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
@Mapper
public interface ShibiaoDataDao {

    ShibiaoDataDO get(Long id);

    List<ShibiaoDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShibiaoDataDO shibiaoData);

    int update(ShibiaoDataDO shibiaoData);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int insertList(@Param("shibiaoDataDOList") List<ShibiaoDataDO> shibiaoDataDOList);
}
