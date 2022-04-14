package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.ScoreEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.ScoreVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.ScoreView;


/**
 * 学生成绩
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface ScoreService extends IService<ScoreEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ScoreVO> selectListVO(Wrapper<ScoreEntity> wrapper);
   	
   	ScoreVO selectVO(@Param("ew") Wrapper<ScoreEntity> wrapper);
   	
   	List<ScoreView> selectListView(Wrapper<ScoreEntity> wrapper);
   	
   	ScoreView selectView(@Param("ew") Wrapper<ScoreEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ScoreEntity> wrapper);
   	

}

