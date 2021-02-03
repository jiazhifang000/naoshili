package com.naoshili.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.naoshili.information.dao.JinggongAdjustDao;
import com.naoshili.information.domain.JinggongAdjustDO;
import com.naoshili.information.service.JinggongAdjustService;



@Service
public class JinggongAdjustServiceImpl implements JinggongAdjustService {
	@Autowired
	private JinggongAdjustDao jinggongAdjustDao;
	
	@Override
	public JinggongAdjustDO get(Integer id){
		return jinggongAdjustDao.get(id);
	}
	
	@Override
	public List<JinggongAdjustDO> list(Map<String, Object> map){
		return jinggongAdjustDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jinggongAdjustDao.count(map);
	}
	
	@Override
	public int save(JinggongAdjustDO jinggongAdjust){
		return jinggongAdjustDao.save(jinggongAdjust);
	}
	
	@Override
	public int update(JinggongAdjustDO jinggongAdjust){
		return jinggongAdjustDao.update(jinggongAdjust);
	}
	
	@Override
	public int remove(Integer id){
		return jinggongAdjustDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return jinggongAdjustDao.batchRemove(ids);
	}
	
}
