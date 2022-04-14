package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.StudentEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.StudentVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.StudentView;


/**
 * 学生信息
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<StudentVO> selectListVO(Wrapper<StudentEntity> wrapper);
   	
   	StudentVO selectVO(@Param("ew") Wrapper<StudentEntity> wrapper);
   	
   	List<StudentView> selectListView(Wrapper<StudentEntity> wrapper);
   	
   	StudentView selectView(@Param("ew") Wrapper<StudentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<StudentEntity> wrapper);
   	

}

