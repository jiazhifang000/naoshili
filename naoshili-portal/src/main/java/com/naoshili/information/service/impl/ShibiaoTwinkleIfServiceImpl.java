package com.naoshili.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.naoshili.information.dao.ShibiaoTwinkleIfDao;
import com.naoshili.information.domain.ShibiaoTwinkleIfDO;
import com.naoshili.information.service.ShibiaoTwinkleIfService;



@Service
public class ShibiaoTwinkleIfServiceImpl implements ShibiaoTwinkleIfService {
	@Autowired
	private ShibiaoTwinkleIfDao shibiaoTwinkleIfDao;
	
	@Override
	public ShibiaoTwinkleIfDO get(Long id){
		return shibiaoTwinkleIfDao.get(id);
	}
	
	@Override
	public List<ShibiaoTwinkleIfDO> list(Map<String, Object> map){
		return shibiaoTwinkleIfDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return shibiaoTwinkleIfDao.count(map);
	}
	
	@Override
	public int save(ShibiaoTwinkleIfDO shibiaoTwinkleIf){
		return shibiaoTwinkleIfDao.save(shibiaoTwinkleIf);
	}
	
	@Override
	public int update(ShibiaoTwinkleIfDO shibiaoTwinkleIf){
		return shibiaoTwinkleIfDao.update(shibiaoTwinkleIf);
	}
	
	@Override
	public int remove(Long id){
		return shibiaoTwinkleIfDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return shibiaoTwinkleIfDao.batchRemove(ids);
	}
	
}
