package com.naoshili.information.service.impl;

import com.naoshili.information.dao.LinshiUrlDao;
import com.naoshili.information.domain.LinshiUrlDO;
import com.naoshili.information.service.LinshiUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class LinshiUrlServiceImpl implements LinshiUrlService {
	@Autowired
	private LinshiUrlDao linshiUrlDao;
	
	@Override
	public LinshiUrlDO get(Integer id){
		return linshiUrlDao.get(id);
	}
	
	@Override
	public List<LinshiUrlDO> list(Map<String, Object> map){
		return linshiUrlDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return linshiUrlDao.count(map);
	}
	
	@Override
	public int save(LinshiUrlDO linshiUrl){
		return linshiUrlDao.save(linshiUrl);
	}
	
	@Override
	public int update(LinshiUrlDO linshiUrl){
		return linshiUrlDao.update(linshiUrl);
	}
	
	@Override
	public int remove(Integer id){
		return linshiUrlDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return linshiUrlDao.batchRemove(ids);
	}
	
}
