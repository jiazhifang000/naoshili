package com.naoshili.information.service.impl;

import com.naoshili.information.dao.RiliDataDao;
import com.naoshili.information.domain.RiliDataDO;
import com.naoshili.information.service.RiliDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RiliDataServiceImpl implements RiliDataService {
    @Autowired
    private RiliDataDao riliDataDao;

    @Override
    public RiliDataDO get(Long id) {
        return riliDataDao.get(id);
    }

    @Override
    public List<RiliDataDO> list(Map<String, Object> map) {
        return riliDataDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return riliDataDao.count(map);
    }

    @Override
    public int save(RiliDataDO riliData) {
        return riliDataDao.save(riliData);
    }

    @Override
    public int update(RiliDataDO riliData) {
        return riliDataDao.update(riliData);
    }

    @Override
    public int remove(Long id) {
        return riliDataDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return riliDataDao.batchRemove(ids);
    }

    @Override
    public List<RiliDataDO> groupbyDataId(Map<String, Object> map) {
        return riliDataDao.groupbyDataId(map);
    }

    @Override
    public int countGroupbyDataId(Map<String, Object> map) {
        return riliDataDao.countGroupbyDataId(map);
    }

    @Override
    public int deleteByDataid(Long id) {
        return riliDataDao.deleteByDataid(id);
    }

}
