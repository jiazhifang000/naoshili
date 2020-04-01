package com.naoshili.information.service;

import com.naoshili.information.domain.UserEyeDataDO;

import java.util.List;
import java.util.Map;

/**
 * 用户眼部数据表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public interface UserEyeDataService {
	
	UserEyeDataDO get(Long id);
	
	List<UserEyeDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserEyeDataDO userEyeData);
	
	int update(UserEyeDataDO userEyeData);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
