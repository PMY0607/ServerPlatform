package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.TeacherEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.TeacherVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.TeacherEntityView;


/**
 * 教师
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface TeacherService extends IService<TeacherEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TeacherVO> selectListVO(Wrapper<TeacherEntity> wrapper);
   	
   	TeacherVO selectVO(@Param("ew") Wrapper<TeacherEntity> wrapper);
   	
   	List<TeacherEntityView> selectListView(Wrapper<TeacherEntity> wrapper);
   	
   	TeacherEntityView selectView(@Param("ew") Wrapper<TeacherEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TeacherEntity> wrapper);
   	

}

