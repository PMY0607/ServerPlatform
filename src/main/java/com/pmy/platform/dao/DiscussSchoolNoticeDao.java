package com.pmy.platform.dao;

import com.pmy.platform.entity.DiscussSchoolNoticeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.DiscussSchoolNoticeVO;
import com.pmy.platform.entity.view.DiscussSchoolNoticeView;


/**
 * 学校公告评论表
 *
 * @date 2022-03-01 10:57:52
 */
public interface DiscussSchoolNoticeDao extends BaseMapper<DiscussSchoolNoticeEntity> {
	
	List<DiscussSchoolNoticeVO> selectListVO(@Param("ew") Wrapper<DiscussSchoolNoticeEntity> wrapper);
	
	DiscussSchoolNoticeVO selectVO(@Param("ew") Wrapper<DiscussSchoolNoticeEntity> wrapper);
	
	List<DiscussSchoolNoticeView> selectListView(@Param("ew") Wrapper<DiscussSchoolNoticeEntity> wrapper);

	List<DiscussSchoolNoticeView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussSchoolNoticeEntity> wrapper);
	
	DiscussSchoolNoticeView selectView(@Param("ew") Wrapper<DiscussSchoolNoticeEntity> wrapper);
	

}
