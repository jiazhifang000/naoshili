package com.naoshili.information.service.impl;

import com.naoshili.information.dao.RiliImportDataMesDao;
import com.naoshili.information.domain.RiliImportDataMesDO;
import com.naoshili.information.service.RiliImportDataMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RiliImportDataMesServiceImpl implements RiliImportDataMesService {
    @Autowired
    private RiliImportDataMesDao riliImportDataMesDao;

    @Override
    public RiliImportDataMesDO get(Integer id) {
        return riliImportDataMesDao.get(id);
    }

    @Override
    public List<RiliImportDataMesDO> list(Map<String, Object> map) {
        return riliImportDataMesDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return riliImportDataMesDao.count(map);
    }

    @Override
    public int save(RiliImportDataMesDO riliImportDataMes) {
        return riliImportDataMesDao.save(riliImportDataMes);
    }

    @Override
    public int update(RiliImportDataMesDO riliImportDataMes) {
        return riliImportDataMesDao.update(riliImportDataMes);
    }

    @Override
    public int remove(Integer id) {
        return riliImportDataMesDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return riliImportDataMesDao.batchRemove(ids);
    }

    @Override
    public int saveList(List<RiliImportDataMesDO> riliImportDataMesDOList) {
        return riliImportDataMesDao.saveList(riliImportDataMesDOList);
    }

}
