package com.naoshili.information.service.impl;

import com.naoshili.information.dao.UserEyeDataDao;
import com.naoshili.information.domain.UserEyeDataDO;
import com.naoshili.information.service.UserEyeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserEyeDataServiceImpl implements UserEyeDataService {
	@Autowired
	private UserEyeDataDao userEyeDataDao;
	
	@Override
	public UserEyeDataDO get(Long id){
		return userEyeDataDao.get(id);
	}
	
	@Override
	public List<UserEyeDataDO> list(Map<String, Object> map){
		return userEyeDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userEyeDataDao.count(map);
	}
	
	@Override
	public int save(UserEyeDataDO userEyeData){
		return userEyeDataDao.save(userEyeData);
	}
	
	@Override
	public int update(UserEyeDataDO userEyeData){
		return userEyeDataDao.update(userEyeData);
	}
	
	@Override
	public int remove(Long id){
		return userEyeDataDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userEyeDataDao.batchRemove(ids);
	}
	
}
