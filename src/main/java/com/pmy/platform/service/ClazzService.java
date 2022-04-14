package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.ClazzEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.ClazzVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.ClazzView;


/**
 * 班级信息
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface ClazzService extends IService<ClazzEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ClazzVO> selectListVO(Wrapper<ClazzEntity> wrapper);
   	
   	ClazzVO selectVO(@Param("ew") Wrapper<ClazzEntity> wrapper);
   	
   	List<ClazzView> selectListView(Wrapper<ClazzEntity> wrapper);
   	
   	ClazzView selectView(@Param("ew") Wrapper<ClazzEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ClazzEntity> wrapper);
   	

}

