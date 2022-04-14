
package com.pmy.platform.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.entity.ConfigEntity;
import com.pmy.platform.utils.PageUtils;


/**
 * 系统用户
 */
public interface ConfigService extends IService<ConfigEntity> {
	PageUtils queryPage(Map<String, Object> params);
}
