package com.naoshili.information.service.impl;

import com.naoshili.information.dao.RiliImportDataDao;
import com.naoshili.information.domain.RiliImportDataDO;
import com.naoshili.information.service.RiliImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RiliImportDataServiceImpl implements RiliImportDataService {
    @Autowired
    private RiliImportDataDao riliImportDataDao;

    @Override
    public RiliImportDataDO get(Integer id) {
        return riliImportDataDao.get(id);
    }

    @Override
    public List<RiliImportDataDO> list(Map<String, Object> map) {
        return riliImportDataDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return riliImportDataDao.count(map);
    }

    @Override
    public int save(RiliImportDataDO riliImportData) {
        return riliImportDataDao.save(riliImportData);
    }

    @Override
    public int update(RiliImportDataDO riliImportData) {
        return riliImportDataDao.update(riliImportData);
    }

    @Override
    public int remove(Integer id) {
        return riliImportDataDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return riliImportDataDao.batchRemove(ids);
    }

    @Override
    public int saveList(List<RiliImportDataDO> riliImportDataDOS) {
        return riliImportDataDao.saveList(riliImportDataDOS);
    }

}
