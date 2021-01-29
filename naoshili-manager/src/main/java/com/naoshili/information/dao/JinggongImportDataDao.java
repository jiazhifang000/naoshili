package com.naoshili.information.dao;

import com.naoshili.information.domain.JinggongImportDataDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-12-24 17:41:33
 */
@Mapper
public interface JinggongImportDataDao {

    JinggongImportDataDO get(Long id);

    List<JinggongImportDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(JinggongImportDataDO jinggongImportData);

    int update(JinggongImportDataDO jinggongImportData);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int saveList(@Param("jinggongImportDataDOList") List<JinggongImportDataDO> jinggongImportDataDOList);
}
