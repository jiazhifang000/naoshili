package com.naoshili.information.service.impl;

import com.naoshili.information.dao.ShibiaoDataDao;
import com.naoshili.information.domain.ShibiaoDataDO;
import com.naoshili.information.service.ShibiaoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ShibiaoDataServiceImpl implements ShibiaoDataService {
    @Autowired
    private ShibiaoDataDao shibiaoDataDao;

    @Override
    public ShibiaoDataDO get(Long id) {
        return shibiaoDataDao.get(id);
    }

    @Override
    public List<ShibiaoDataDO> list(Map<String, Object> map) {
        return shibiaoDataDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return shibiaoDataDao.count(map);
    }

    @Override
    public int save(ShibiaoDataDO shibiaoData) {
        return shibiaoDataDao.save(shibiaoData);
    }

    @Override
    public int update(ShibiaoDataDO shibiaoData) {
        return shibiaoDataDao.update(shibiaoData);
    }

    @Override
    public int remove(Long id) {
        return shibiaoDataDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return shibiaoDataDao.batchRemove(ids);
    }

    @Override
    public List<ShibiaoDataDO> detaillist(Map<String, Object> map) {
        return shibiaoDataDao.detaillist(map);
    }

    @Override
    public int detailcount(Map<String, Object> map) {
        return shibiaoDataDao.detailcount(map);
    }

    @Override
    public int deleteByDataid(Long id) {
        return shibiaoDataDao.deleteByDataid(id);
    }

}
