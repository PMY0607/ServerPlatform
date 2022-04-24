package com.pmy.platform.dao;

import com.pmy.platform.entity.CourseEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.CourseVO;
import com.pmy.platform.entity.view.CourseView;


/**
 * 课程信息
 *
 * @date 2022-03-01 10:57:52
 */
public interface CourseDao extends BaseMapper<CourseEntity> {
	
	List<CourseVO> selectListVO(@Param("ew") Wrapper<CourseEntity> wrapper);
	
	CourseVO selectVO(@Param("ew") Wrapper<CourseEntity> wrapper);
	
	List<CourseView> selectListView(@Param("ew") Wrapper<CourseEntity> wrapper);

	List<CourseView> selectListView(Pagination page, @Param("ew") Wrapper<CourseEntity> wrapper);
	
	CourseView selectView(@Param("ew") Wrapper<CourseEntity> wrapper);
	

}
