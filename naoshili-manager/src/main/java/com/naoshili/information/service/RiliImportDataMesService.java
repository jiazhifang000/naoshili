package com.naoshili.information.service;

import com.naoshili.information.domain.RiliImportDataMesDO;

import java.util.List;
import java.util.Map;

/**
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-11-19 09:16:07
 */
public interface RiliImportDataMesService {

    RiliImportDataMesDO get(Integer id);

    List<RiliImportDataMesDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RiliImportDataMesDO riliImportDataMes);

    int update(RiliImportDataMesDO riliImportDataMes);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    int saveList(List<RiliImportDataMesDO> riliImportDataMesDOList);
}
