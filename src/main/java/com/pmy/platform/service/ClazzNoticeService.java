package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.ClazzNoticeEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.ClazzNoticeVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.ClazzNoticeView;


/**
 * 班级公告
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface ClazzNoticeService extends IService<ClazzNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ClazzNoticeVO> selectListVO(Wrapper<ClazzNoticeEntity> wrapper);
   	
   	ClazzNoticeVO selectVO(@Param("ew") Wrapper<ClazzNoticeEntity> wrapper);
   	
   	List<ClazzNoticeView> selectListView(Wrapper<ClazzNoticeEntity> wrapper);
   	
   	ClazzNoticeView selectView(@Param("ew") Wrapper<ClazzNoticeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ClazzNoticeEntity> wrapper);
   	

}

