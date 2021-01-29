package com.naoshili.information.service.impl;

import com.naoshili.information.dao.JinggongDataDao;
import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.domain.ZhiHouDO;
import com.naoshili.information.service.JinggongDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class JinggongDataServiceImpl implements JinggongDataService {
    @Autowired
    private JinggongDataDao jinggongDataDao;

    @Override
    public JinggongDataDO get(Long id) {
        return jinggongDataDao.get(id);
    }

    @Override
    public List<JinggongDataDO> list(Map<String, Object> map) {
        return jinggongDataDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return jinggongDataDao.count(map);
    }

    @Override
    public List<JinggongDataDO> groupbyDataId(Map<String, Object> map) {
        return jinggongDataDao.groupbyDataId(map);
    }

    @Override
    public int countGroupbyDataId(Map<String, Object> map) {
        return jinggongDataDao.countGroupbyDataId(map);
    }


    @Override
    public ZhiHouDO getLocation(String samplingTime, Long id) {
        return jinggongDataDao.getLocation(samplingTime, id);
    }

    @Override
    public int deleteByDataid(Long id) {
        return jinggongDataDao.deleteByDataid(id);
    }


    @Override
    public int save(JinggongDataDO jinggongData) {
        return jinggongDataDao.save(jinggongData);
    }

    @Override
    public int update(JinggongDataDO jinggongData) {
        return jinggongDataDao.update(jinggongData);
    }

    @Override
    public int remove(Long id) {
        return jinggongDataDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return jinggongDataDao.batchRemove(ids);
    }


}
