package com.naoshili.information.service.impl;

import com.naoshili.information.dao.CollectionInfoDao;
import com.naoshili.information.dao.JinggongDataDao;
import com.naoshili.information.dao.RiliDataDao;
import com.naoshili.information.dao.ShibiaoDataDao;
import com.naoshili.information.domain.AllDataDO;
import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.domain.RiliDataDO;
import com.naoshili.information.domain.ShibiaoDataDO;
import com.naoshili.information.service.CollectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CollectionInfoServiceImpl implements CollectionInfoService {
    @Autowired
    private CollectionInfoDao collectionInfoDao;
    @Autowired
    private JinggongDataDao jinggongDataDao;
    @Autowired
    private RiliDataDao riliDataDao;
    @Autowired
    private ShibiaoDataDao shibiaoDataDao;


    @Override
    public int saveData(AllDataDO allDataDO) {
        int result1 = 0;
        if (allDataDO != null) {
            if (allDataDO.getInfo() != null) {
                result1 += collectionInfoDao.save(allDataDO.getInfo());
            }
            if (allDataDO.getJinggongDataDOList() != null) {
                for (JinggongDataDO jinggongDataDO : allDataDO.getJinggongDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                        jinggongDataDO.setDataId(allDataDO.getInfo().getId());
                    }
                }
                result1 += jinggongDataDao.insertList(allDataDO.getJinggongDataDOList());
            }
            if (allDataDO.getRiliDataDOList() != null) {
                for (RiliDataDO riliDataDO : allDataDO.getRiliDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                        riliDataDO.setDataId(allDataDO.getInfo().getId());
                    }
                }
                result1 += riliDataDao.insertList(allDataDO.getRiliDataDOList());
            }
            if (allDataDO.getShibiaoDataDOList() != null) {
                for (ShibiaoDataDO shibiaoDataDO : allDataDO.getShibiaoDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                        shibiaoDataDO.setDataId(allDataDO.getInfo().getId());
                    }
                }
                result1 += shibiaoDataDao.insertList(allDataDO.getShibiaoDataDOList());
            }
        } else {
            return 0;
        }


        return result1;
    }

}
