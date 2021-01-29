package com.naoshili.information.service.impl;

import com.naoshili.information.dao.JinggongImportDataDao;
import com.naoshili.information.domain.JinggongImportDataDO;
import com.naoshili.information.service.JinggongImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class JinggongImportDataServiceImpl implements JinggongImportDataService {
    @Autowired
    private JinggongImportDataDao jinggongImportDataDao;

    @Override
    public JinggongImportDataDO get(Long id) {
        return jinggongImportDataDao.get(id);
    }

    @Override
    public List<JinggongImportDataDO> list(Map<String, Object> map) {
        return jinggongImportDataDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return jinggongImportDataDao.count(map);
    }

    @Override
    public int save(JinggongImportDataDO jinggongImportData) {
        return jinggongImportDataDao.save(jinggongImportData);
    }

    @Override
    public int update(JinggongImportDataDO jinggongImportData) {
        return jinggongImportDataDao.update(jinggongImportData);
    }

    @Override
    public int remove(Long id) {
        return jinggongImportDataDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return jinggongImportDataDao.batchRemove(ids);
    }

    @Override
    public int saveList(List<JinggongImportDataDO> jinggongImportDataDOList) {
        return jinggongImportDataDao.saveList(jinggongImportDataDOList);
    }

}
