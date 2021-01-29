package com.naoshili.information.service.impl;

import com.naoshili.information.dao.*;
import com.naoshili.information.domain.*;
import com.naoshili.information.service.CollectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
    @Autowired
    private ShibiaoMoveIfDao shibiaoMoveIfDao;
    @Autowired
    private ShibiaoTwinkleIfDao shibiaoTwinkleIfDao;


    @Transactional
    @Override
    public int saveData(AllDataDO allDataDO) {
        Date date = new Date();
        int result1 = 0;
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date dt = new Date();
        String dataid = simpledateformat.format(dt);
        if (allDataDO != null) {
            if (allDataDO.getInfo() != null) {

                allDataDO.getInfo().setAddTime(date);
                allDataDO.getInfo().setId(dataid);
                result1 += collectionInfoDao.save(allDataDO.getInfo());
                UserBasicDO userBasicDO = userBasicDao.get(allDataDO.getInfo().getUserId());
                if (userBasicDO == null) {
                    UserBasicDO ub = new UserBasicDO();
                    ub.setUserId(allDataDO.getInfo().getUserId());
                    if (userBasicDao.save(ub) > 0) {
                        UserEyeDataDO userEyeDataDO = new UserEyeDataDO();
                        userEyeDataDO.setUid(allDataDO.getInfo().getUserId());
                        userEyeDataDO.setlGlassesVision(allDataDO.getInfo().getlGlassesVision());
                        userEyeDataDO.setrGlassesVision(allDataDO.getInfo().getrGlassesVision());

                        userEyeDataDao.save(userEyeDataDO);
                    }
                } else {
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("uid", allDataDO.getInfo().getUserId());
                    if (userEyeDataDao.list(params).size() == 1) {
                        UserEyeDataDO userEyeDataDO = userEyeDataDao.list(params).get(0);
                        userEyeDataDO.setlGlassesVision(allDataDO.getInfo().getlGlassesVision());
                        userEyeDataDO.setrGlassesVision(allDataDO.getInfo().getrGlassesVision());

                        userEyeDataDao.update(userEyeDataDO);
                    }

                }
            }
            int i = 1;
            for (DataListDO dataDO : allDataDO.getData()) {
                i++;
                if (dataDO.getShibiaoMoveIfDO() != null) {
                    dataDO.getShibiaoMoveIfDO().setDataId(dataid);
                    dataDO.getShibiaoMoveIfDO().setDataType(allDataDO.getInfo().getExperimentalMode());
                    dataDO.getShibiaoMoveIfDO().setTestTime(allDataDO.getInfo().getCollectionDate());
                    dataDO.getShibiaoMoveIfDO().setSaveTime(new Date());

                    dataDO.getShibiaoMoveIfDO().setNum(i);
                    result1 += shibiaoMoveIfDao.save(dataDO.getShibiaoMoveIfDO());
                }
                if (dataDO.getShibiaoTwinkleIfDO() != null) {
                    dataDO.getShibiaoTwinkleIfDO().setDataId(dataid);
                    dataDO.getShibiaoTwinkleIfDO().setDataType(allDataDO.getInfo().getExperimentalMode());
                    dataDO.getShibiaoTwinkleIfDO().setTestTime(allDataDO.getInfo().getCollectionDate());
                    dataDO.getShibiaoTwinkleIfDO().setSaveTime(new Date());

                    dataDO.getShibiaoTwinkleIfDO().setNum(i);
                    result1 += shibiaoTwinkleIfDao.save(dataDO.getShibiaoTwinkleIfDO());
                }
                if (dataDO.getJinggongDataDOList() != null && dataDO.getJinggongDataDOList().size() > 0) {
                    for (JinggongDataDO jinggongDataDO : dataDO.getJinggongDataDOList()) {
                        if (allDataDO.getInfo() != null) {
                            jinggongDataDO.setAddTime(date);
                            jinggongDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                            jinggongDataDO.setDataId(dataid);
                            jinggongDataDO.setNum(i);
                            jinggongDataDO.setOriginalData(jinggongDataDO.getOriginalData());

                        }
                    }
                    result1 += jinggongDataDao.insertList(dataDO.getJinggongDataDOList());
                }
                if (dataDO.getRiliDataDOList() != null && dataDO.getRiliDataDOList().size() > 0) {
                    for (RiliDataDO riliDataDO : dataDO.getRiliDataDOList()) {
                        if (allDataDO.getInfo() != null) {
                            riliDataDO.setAddTime(date);
                            riliDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                            riliDataDO.setDataId(dataid);
                            riliDataDO.setNum(i);
                        }
                    }
                    result1 += riliDataDao.insertList(dataDO.getRiliDataDOList());
                }
                if (dataDO.getShibiaoDataDOList() != null && dataDO.getShibiaoDataDOList().size() > 0) {
                    for (ShibiaoDataDO shibiaoDataDO : dataDO.getShibiaoDataDOList()) {
                        if (allDataDO.getInfo() != null) {
                            shibiaoDataDO.setAddTime(date);
                            shibiaoDataDO.setExperimentalMode(allDataDO.getInfo().getExperimentalMode());
                            shibiaoDataDO.setDataId(dataid);
                            shibiaoDataDO.setNum(i);
                        }
                    }
                    result1 += shibiaoDataDao.insertList(dataDO.getShibiaoDataDOList());
                }
            }

        } else {
            return 0;
        }


        return result1;
    }

}
