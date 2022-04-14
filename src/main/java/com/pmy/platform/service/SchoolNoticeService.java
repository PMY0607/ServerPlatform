package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.SchoolNoticeEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.SchoolNoticeVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.SchoolNoticeView;


/**
 * 学校公告
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface SchoolNoticeService extends IService<SchoolNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SchoolNoticeVO> selectListVO(Wrapper<SchoolNoticeEntity> wrapper);
   	
   	SchoolNoticeVO selectVO(@Param("ew") Wrapper<SchoolNoticeEntity> wrapper);
   	
   	List<SchoolNoticeView> selectListView(Wrapper<SchoolNoticeEntity> wrapper);
   	
   	SchoolNoticeView selectView(@Param("ew") Wrapper<SchoolNoticeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SchoolNoticeEntity> wrapper);
   	

}

