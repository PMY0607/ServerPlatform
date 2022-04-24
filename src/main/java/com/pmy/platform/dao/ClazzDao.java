package com.pmy.platform.dao;

import com.pmy.platform.entity.ClazzEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.ClazzVO;
import com.pmy.platform.entity.view.ClazzView;


/**
 * 班级信息
 *
 * @date 2022-03-01 10:57:52
 */
public interface ClazzDao extends BaseMapper<ClazzEntity> {
	
	List<ClazzVO> selectListVO(@Param("ew") Wrapper<ClazzEntity> wrapper);
	
	ClazzVO selectVO(@Param("ew") Wrapper<ClazzEntity> wrapper);
	
	List<ClazzView> selectListView(@Param("ew") Wrapper<ClazzEntity> wrapper);

	List<ClazzView> selectListView(Pagination page, @Param("ew") Wrapper<ClazzEntity> wrapper);
	
	ClazzView selectView(@Param("ew") Wrapper<ClazzEntity> wrapper);
	

}
