package com.pmy.platform.dao;

import com.pmy.platform.entity.ClazzNoticeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.ClazzNoticeVO;
import com.pmy.platform.entity.view.ClazzNoticeView;


/**
 * 班级公告
 * 
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface ClazzNoticeDao extends BaseMapper<ClazzNoticeEntity> {
	
	List<ClazzNoticeVO> selectListVO(@Param("ew") Wrapper<ClazzNoticeEntity> wrapper);
	
	ClazzNoticeVO selectVO(@Param("ew") Wrapper<ClazzNoticeEntity> wrapper);
	
	List<ClazzNoticeView> selectListView(@Param("ew") Wrapper<ClazzNoticeEntity> wrapper);

	List<ClazzNoticeView> selectListView(Pagination page, @Param("ew") Wrapper<ClazzNoticeEntity> wrapper);
	
	ClazzNoticeView selectView(@Param("ew") Wrapper<ClazzNoticeEntity> wrapper);
	

}
