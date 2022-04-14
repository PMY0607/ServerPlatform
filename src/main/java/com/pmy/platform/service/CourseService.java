package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.CourseEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.CourseVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.CourseView;


/**
 * 课程信息
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface CourseService extends IService<CourseEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CourseVO> selectListVO(Wrapper<CourseEntity> wrapper);
   	
   	CourseVO selectVO(@Param("ew") Wrapper<CourseEntity> wrapper);
   	
   	List<CourseView> selectListView(Wrapper<CourseEntity> wrapper);
   	
   	CourseView selectView(@Param("ew") Wrapper<CourseEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CourseEntity> wrapper);
   	

}

