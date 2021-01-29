package com.naoshili.information.dao;

import com.naoshili.information.domain.ShibiaoMoveIfDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 移动视标实验条件表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-09-23 16:25:44
 */
@Mapper
public interface ShibiaoMoveIfDao {

    ShibiaoMoveIfDO get(Integer id);

    List<ShibiaoMoveIfDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShibiaoMoveIfDO shibiaoMoveIf);

    int update(ShibiaoMoveIfDO shibiaoMoveIf);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    int deleteByDataid(Long id);
}
