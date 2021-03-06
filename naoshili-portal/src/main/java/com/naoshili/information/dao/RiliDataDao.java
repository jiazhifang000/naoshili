package com.naoshili.information.dao;

import com.naoshili.information.domain.RiliDataDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 日立4000数据
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
@Mapper
public interface RiliDataDao {

    RiliDataDO get(Long id);

    List<RiliDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RiliDataDO riliData);

    int update(RiliDataDO riliData);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int insertList(@Param("riliDataDOList") List<RiliDataDO> riliDataDOList);
}
