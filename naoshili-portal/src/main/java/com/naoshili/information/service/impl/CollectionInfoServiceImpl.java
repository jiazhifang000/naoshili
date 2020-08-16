package com.naoshili.information.service.impl;

import com.naoshili.information.dao.CollectionInfoDao;
import com.naoshili.information.dao.JinggongDataDao;
import com.naoshili.information.dao.RiliDataDao;
import com.naoshili.information.dao.ShibiaoDataDao;
import com.naoshili.information.dao.UserBasicDao;
import com.naoshili.information.dao.UserEyeDataDao;
import com.naoshili.information.domain.AllDataDO;
import com.naoshili.information.domain.JinggongDataDO;
import com.naoshili.information.domain.RiliDataDO;
import com.naoshili.information.domain.ShibiaoDataDO;
import com.naoshili.information.domain.UserBasicDO;
import com.naoshili.information.domain.UserEyeDataDO;
import com.naoshili.information.service.CollectionInfoService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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
                result1 += collectionInfoDao.save(allDataDO.getInfo());
                UserBasicDO userBasicDO = userBasicDao.get(allDataDO.getInfo().getUserId());
                if(userBasicDO==null){
                	UserBasicDO ub = new UserBasicDO();
                	ub.setUserId(allDataDO.getInfo().getUserId());
                	if(userBasicDao.save(ub)>0){
                		UserEyeDataDO userEyeDataDO = new UserEyeDataDO();
                		userEyeDataDO.setUid(allDataDO.getInfo().getUserId());
                		userEyeDataDao.save(userEyeDataDO);
                	}
                }
            }
            if (allDataDO.getJinggongDataDOList() != null && allDataDO.getJinggongDataDOList().size()>0) {
                for (JinggongDataDO jinggongDataDO : allDataDO.getJinggongDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                    	jinggongDataDO.setAddTime(date);
                    	jinggongDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                        jinggongDataDO.setDataId(allDataDO.getInfo().getId());
                    }
                }
                result1 += jinggongDataDao.insertList(allDataDO.getJinggongDataDOList());
            }
            if (allDataDO.getRiliDataDOList() != null && allDataDO.getRiliDataDOList().size()>0) {
                for (RiliDataDO riliDataDO : allDataDO.getRiliDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                    	riliDataDO.setAddTime(date);
                    	riliDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                        riliDataDO.setDataId(allDataDO.getInfo().getId());
                    }
                }
                result1 += riliDataDao.insertList(allDataDO.getRiliDataDOList());
            }
            if (allDataDO.getShibiaoDataDOList() != null && allDataDO.getShibiaoDataDOList().size()>0) {
                for (ShibiaoDataDO shibiaoDataDO : allDataDO.getShibiaoDataDOList()) {
                    if (allDataDO.getInfo() != null) {
                    	shibiaoDataDO.setAddTime(date);
                    	shibiaoDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
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
