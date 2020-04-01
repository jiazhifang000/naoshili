package com.naoshili.information.service.impl;

import com.naoshili.information.dao.UserBasicDao;
import com.naoshili.information.domain.UserBasicDO;
import com.naoshili.information.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class UserBasicServiceImpl implements UserBasicService {
    @Autowired
    private UserBasicDao userBasicDao;

    @Override
    public UserBasicDO get(Long id) {
        return userBasicDao.get(id);
    }

    @Override
    public List<UserBasicDO> list(Map<String, Object> map) {
        return userBasicDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userBasicDao.count(map);
    }

    @Override
    public int save(UserBasicDO userBasic) {
        return userBasicDao.save(userBasic);
    }

    @Override
    public int update(UserBasicDO userBasic) {
        return userBasicDao.update(userBasic);
    }

    @Override
    public int remove(Long id) {
        return userBasicDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return userBasicDao.batchRemove(ids);
    }


}
