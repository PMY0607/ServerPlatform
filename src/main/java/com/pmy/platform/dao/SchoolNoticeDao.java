package com.pmy.platform.dao;

import com.pmy.platform.entity.SchoolNoticeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.SchoolNoticeVO;
import com.pmy.platform.entity.view.SchoolNoticeView;


/**
 * 学校公告
 *
 * @date 2022-03-01 10:57:52
 */
public interface SchoolNoticeDao extends BaseMapper<SchoolNoticeEntity> {
	
	List<SchoolNoticeVO> selectListVO(@Param("ew") Wrapper<SchoolNoticeEntity> wrapper);
	
	SchoolNoticeVO selectVO(@Param("ew") Wrapper<SchoolNoticeEntity> wrapper);
	
	List<SchoolNoticeView> selectListView(@Param("ew") Wrapper<SchoolNoticeEntity> wrapper);

	List<SchoolNoticeView> selectListView(Pagination page, @Param("ew") Wrapper<SchoolNoticeEntity> wrapper);
	
	SchoolNoticeView selectView(@Param("ew") Wrapper<SchoolNoticeEntity> wrapper);
	

}
