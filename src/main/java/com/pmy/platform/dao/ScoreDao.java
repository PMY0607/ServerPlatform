package com.pmy.platform.dao;

import com.pmy.platform.entity.ScoreEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.ScoreVO;
import com.pmy.platform.entity.view.ScoreView;


/**
 * 学生成绩
 * 
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface ScoreDao extends BaseMapper<ScoreEntity> {
	
	List<ScoreVO> selectListVO(@Param("ew") Wrapper<ScoreEntity> wrapper);
	
	ScoreVO selectVO(@Param("ew") Wrapper<ScoreEntity> wrapper);
	
	List<ScoreView> selectListView(@Param("ew") Wrapper<ScoreEntity> wrapper);

	List<ScoreView> selectListView(Pagination page, @Param("ew") Wrapper<ScoreEntity> wrapper);
	
	ScoreView selectView(@Param("ew") Wrapper<ScoreEntity> wrapper);
	

}
