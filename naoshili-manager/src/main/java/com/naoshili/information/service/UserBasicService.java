package com.naoshili.information.service;

import com.naoshili.common.utils.R;
import com.naoshili.information.domain.UserBasicDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 用户基本数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public interface UserBasicService {

    UserBasicDO get(Long id);

    UserBasicDO getUserId(Long userId);

    List<UserBasicDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserBasicDO userBasic);

    int update(UserBasicDO userBasic);

    int remove(Long id);

    int batchRemove(Long[] ids);

    R importUser(MultipartFile file);

    boolean exit(Map<String, Object> params);

    Map<String, Object> getAge();

    int getTestPerson();

    Map<String, Object> getEyeHealth();

    Map<String, Object> getType();

    Map<String, Object> getGender();
}
