package com.naoshili.information.service.impl;

import com.naoshili.information.dao.ShibiaoMoveIfDao;
import com.naoshili.information.domain.ShibiaoMoveIfDO;
import com.naoshili.information.service.ShibiaoMoveIfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ShibiaoMoveIfServiceImpl implements ShibiaoMoveIfService {
    @Autowired
    private ShibiaoMoveIfDao shibiaoMoveIfDao;

    @Override
    public ShibiaoMoveIfDO get(Integer id) {
        return shibiaoMoveIfDao.get(id);
    }

    @Override
    public List<ShibiaoMoveIfDO> list(Map<String, Object> map) {
        return shibiaoMoveIfDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return shibiaoMoveIfDao.count(map);
    }

    @Override
    public int save(ShibiaoMoveIfDO shibiaoMoveIf) {
        return shibiaoMoveIfDao.save(shibiaoMoveIf);
    }

    @Override
    public int update(ShibiaoMoveIfDO shibiaoMoveIf) {
        return shibiaoMoveIfDao.update(shibiaoMoveIf);
    }

    @Override
    public int remove(Integer id) {
        return shibiaoMoveIfDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return shibiaoMoveIfDao.batchRemove(ids);
    }

    @Override
    public int deleteByDataid(Long id) {
        return shibiaoMoveIfDao.deleteByDataid(id);
    }

}
