package com.naoshili.information.service.impl;

import com.naoshili.information.dao.CollectionInfoDao;
import com.naoshili.information.domain.CollectionInfoDO;
import com.naoshili.information.service.CollectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CollectionInfoServiceImpl implements CollectionInfoService {
	@Autowired
	private CollectionInfoDao collectionInfoDao;
	
	@Override
	public CollectionInfoDO get(Long id){
		return collectionInfoDao.get(id);
	}
	
	@Override
	public List<CollectionInfoDO> list(Map<String, Object> map){
		return collectionInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return collectionInfoDao.count(map);
	}
	
	@Override
	public int save(CollectionInfoDO collectionInfo){
		return collectionInfoDao.save(collectionInfo);
	}
	
	@Override
	public int update(CollectionInfoDO collectionInfo){
		return collectionInfoDao.update(collectionInfo);
	}
	
	@Override
	public int remove(Long id){
		return collectionInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return collectionInfoDao.batchRemove(ids);
	}
	
}
