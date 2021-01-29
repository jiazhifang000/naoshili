package com.naoshili.information.dao;

import com.naoshili.information.domain.RiliImportDataDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-10-23 13:20:38
 */
@Mapper
public interface RiliImportDataDao {

    RiliImportDataDO get(Integer id);

    List<RiliImportDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RiliImportDataDO riliImportData);

    int update(RiliImportDataDO riliImportData);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    int saveList(@Param("riliImportDataDOS") List<RiliImportDataDO> riliImportDataDOS);
}
