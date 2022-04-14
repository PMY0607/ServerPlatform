package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.ParentEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.ParentVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.ParentView;


/**
 * 家长
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface ParentService extends IService<ParentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ParentVO> selectListVO(Wrapper<ParentEntity> wrapper);
   	
   	ParentVO selectVO(@Param("ew") Wrapper<ParentEntity> wrapper);
   	
   	List<ParentView> selectListView(Wrapper<ParentEntity> wrapper);
   	
   	ParentView selectView(@Param("ew") Wrapper<ParentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ParentEntity> wrapper);
   	

}

