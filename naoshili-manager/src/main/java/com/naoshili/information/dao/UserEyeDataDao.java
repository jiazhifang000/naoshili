package com.naoshili.information.dao;

import com.naoshili.information.domain.UserEyeDataDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户眼部数据表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
@Mapper
public interface UserEyeDataDao {

	UserEyeDataDO get(Long id);
	UserEyeDataDO getUid(Long id);

	List<UserEyeDataDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserEyeDataDO userEyeData);
	
	int update(UserEyeDataDO userEyeData);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
