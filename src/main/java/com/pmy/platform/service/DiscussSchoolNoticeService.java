package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.DiscussSchoolNoticeEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.DiscussSchoolNoticeVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.DiscussSchoolNoticeView;


/**
 * 学校公告评论表
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface DiscussSchoolNoticeService extends IService<DiscussSchoolNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussSchoolNoticeVO> selectListVO(Wrapper<DiscussSchoolNoticeEntity> wrapper);
   	
   	DiscussSchoolNoticeVO selectVO(@Param("ew") Wrapper<DiscussSchoolNoticeEntity> wrapper);
   	
   	List<DiscussSchoolNoticeView> selectListView(Wrapper<DiscussSchoolNoticeEntity> wrapper);
   	
   	DiscussSchoolNoticeView selectView(@Param("ew") Wrapper<DiscussSchoolNoticeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussSchoolNoticeEntity> wrapper);
   	

}

