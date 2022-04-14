package com.pmy.platform.dao;

import com.pmy.platform.entity.TeacherEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.TeacherVO;
import com.pmy.platform.entity.view.TeacherEntityView;


/**
 * 教师
 * 
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface TeacherDao extends BaseMapper<TeacherEntity> {
	
	List<TeacherVO> selectListVO(@Param("ew") Wrapper<TeacherEntity> wrapper);
	
	TeacherVO selectVO(@Param("ew") Wrapper<TeacherEntity> wrapper);
	
	List<TeacherEntityView> selectListView(@Param("ew") Wrapper<TeacherEntity> wrapper);

	List<TeacherEntityView> selectListView(Pagination page, @Param("ew") Wrapper<TeacherEntity> wrapper);
	
	TeacherEntityView selectView(@Param("ew") Wrapper<TeacherEntity> wrapper);
	

}
