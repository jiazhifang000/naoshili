package com.naoshili.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naoshili.common.domain.LogDO;
import com.naoshili.common.domain.PageDO;
import com.naoshili.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
