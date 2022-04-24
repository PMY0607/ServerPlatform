package com.pmy.platform.dao;

import com.pmy.platform.entity.ScoreRankEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.ScoreRankVO;
import com.pmy.platform.entity.view.ScoreRankView;


/**
 * 成绩排名
 * 
 * @date 2022-03-01 10:57:52
 */
public interface scoreRankDao extends BaseMapper<ScoreRankEntity> {
	
	List<ScoreRankVO> selectListVO(@Param("ew") Wrapper<ScoreRankEntity> wrapper);
	
	ScoreRankVO selectVO(@Param("ew") Wrapper<ScoreRankEntity> wrapper);
	
	List<ScoreRankView> selectListView(@Param("ew") Wrapper<ScoreRankEntity> wrapper);

	List<ScoreRankView> selectListView(Pagination page, @Param("ew") Wrapper<ScoreRankEntity> wrapper);
	
	ScoreRankView selectView(@Param("ew") Wrapper<ScoreRankEntity> wrapper);
	

}
