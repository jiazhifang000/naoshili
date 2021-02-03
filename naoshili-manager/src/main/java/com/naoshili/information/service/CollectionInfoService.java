package com.naoshili.information.service;

import com.naoshili.information.domain.CollectionInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 采集数据基本信息
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public interface CollectionInfoService {
	
	CollectionInfoDO get(Long id);
	
	List<CollectionInfoDO> list(Map<String, Object> map);
	List<CollectionInfoDO> getAllCollection(Long id);

	int count(Map<String, Object> map);
	
	int save(CollectionInfoDO collectionInfo);
	
	int update(CollectionInfoDO collectionInfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    Integer getUserId(Long id);
}
