package com.naoshili.information.dao;

import com.naoshili.information.domain.JinggongAdjustDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 眼调节功能结果
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-02-02 10:13:27
 */
@Mapper
public interface JinggongAdjustDao {

	JinggongAdjustDO get(Integer id);
	
	List<JinggongAdjustDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JinggongAdjustDO jinggongAdjust);
	
	int update(JinggongAdjustDO jinggongAdjust);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
