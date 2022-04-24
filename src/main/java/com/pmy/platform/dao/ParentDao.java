package com.pmy.platform.dao;

import com.pmy.platform.entity.ParentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.ParentVO;
import com.pmy.platform.entity.view.ParentView;


/**
 * 家长
 *
 * @date 2022-03-01 10:57:52
 */
public interface ParentDao extends BaseMapper<ParentEntity> {
	
	List<ParentVO> selectListVO(@Param("ew") Wrapper<ParentEntity> wrapper);
	
	ParentVO selectVO(@Param("ew") Wrapper<ParentEntity> wrapper);
	
	List<ParentView> selectListView(@Param("ew") Wrapper<ParentEntity> wrapper);

	List<ParentView> selectListView(Pagination page, @Param("ew") Wrapper<ParentEntity> wrapper);
	
	ParentView selectView(@Param("ew") Wrapper<ParentEntity> wrapper);
	

}
