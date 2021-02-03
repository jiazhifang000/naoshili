package com.naoshili.information.dao;

import com.naoshili.information.domain.LinshiUrlDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 临时图片保存  可以清空
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-02-02 15:24:04
 */
@Mapper
public interface LinshiUrlDao {

	LinshiUrlDO get(Integer id);
	
	List<LinshiUrlDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LinshiUrlDO linshiUrl);
	
	int update(LinshiUrlDO linshiUrl);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
