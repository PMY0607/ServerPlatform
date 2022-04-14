package com.pmy.platform.dao;

import com.pmy.platform.entity.StudentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.StudentVO;
import com.pmy.platform.entity.view.StudentView;


/**
 * 学生信息
 * 
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface StudentDao extends BaseMapper<StudentEntity> {
	
	List<StudentVO> selectListVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentVO selectVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	List<StudentView> selectListView(@Param("ew") Wrapper<StudentEntity> wrapper);

	List<StudentView> selectListView(Pagination page, @Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentView selectView(@Param("ew") Wrapper<StudentEntity> wrapper);
	

}
