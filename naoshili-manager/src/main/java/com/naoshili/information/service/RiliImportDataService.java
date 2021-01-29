package com.naoshili.information.service;

import com.naoshili.information.domain.RiliImportDataDO;

import java.util.List;
import java.util.Map;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-10-23 13:20:38
 */
public interface RiliImportDataService {

    RiliImportDataDO get(Integer id);

    List<RiliImportDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RiliImportDataDO riliImportData);

    int update(RiliImportDataDO riliImportData);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    int saveList(List<RiliImportDataDO> riliImportDataDOS);
}
