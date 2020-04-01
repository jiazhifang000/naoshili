package com.naoshili.information.dao;

import com.naoshili.information.domain.UserBasicDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户基本数据表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
@Mapper
public interface UserBasicDao {

	UserBasicDO get(Long id);
	
	List<UserBasicDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserBasicDO userBasic);
	
	int update(UserBasicDO userBasic);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

}
