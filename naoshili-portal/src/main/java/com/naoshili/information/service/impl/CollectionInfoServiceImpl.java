package com.naoshili.information.service.impl;

import com.naoshili.information.dao.*;
import com.naoshili.information.domain.*;
import com.naoshili.information.service.CollectionInfoService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


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
    @Autowired
    private UserBasicDao userBasicDao;
    @Autowired
    private UserEyeDataDao userEyeDataDao;


    @Transactional
    @Override
    public int saveData(AllDataDO allDataDO) {
    	Date date = new Date();
        int result1 = 0;
        if (allDataDO != null) {
            if (allDataDO.getInfo() != null) {
            	allDataDO.getInfo().setAddTime(date);
				SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
				Date dt = new Date();
				String dataid = simpledateformat.format(dt);
                allDataDO.getInfo().setId(dataid);
                result1 += collectionInfoDao.save(allDataDO.getInfo());
                UserBasicDO userBasicDO = userBasicDao.get(allDataDO.getInfo().getUserId());
                if (userBasicDO == null) {
                    UserBasicDO ub = new UserBasicDO();
                    ub.setUserId(allDataDO.getInfo().getUserId());
                    if (userBasicDao.save(ub) > 0) {
                        UserEyeDataDO userEyeDataDO = new UserEyeDataDO();
                        userEyeDataDO.setUid(allDataDO.getInfo().getUserId());
                        userEyeDataDao.save(userEyeDataDO);
                    }
                }
            }
            if (allDataDO.getJinggongDataDOList() != null && allDataDO.getJinggongDataDOList().size() > 0) {
                for (JinggongDataDO jinggongDataDO : allDataDO.getJinggongDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                    	jinggongDataDO.setAddTime(date);
                    	jinggongDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                        jinggongDataDO.setDataId(dataid);
                    }
                }
                result1 += jinggongDataDao.insertList(allDataDO.getJinggongDataDOList());
            }
            if (allDataDO.getRiliDataDOList() != null && allDataDO.getRiliDataDOList().size() > 0) {
                for (RiliDataDO riliDataDO : allDataDO.getRiliDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                    	riliDataDO.setAddTime(date);
                    	riliDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                        riliDataDO.setDataId(dataid);
                    }
                }
                result1 += riliDataDao.insertList(allDataDO.getRiliDataDOList());
            }
            if (allDataDO.getShibiaoDataDOList() != null && allDataDO.getShibiaoDataDOList().size() > 0) {
                for (ShibiaoDataDO shibiaoDataDO : allDataDO.getShibiaoDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                    	shibiaoDataDO.setAddTime(date);
                    	shibiaoDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                        shibiaoDataDO.setDataId(dataid);
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
