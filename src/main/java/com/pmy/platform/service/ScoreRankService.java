package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.ScoreRankEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.ScoreRankVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.ScoreRankView;


/**
 * 成绩排名
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface ScoreRankService extends IService<ScoreRankEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ScoreRankVO> selectListVO(Wrapper<ScoreRankEntity> wrapper);
   	
   	ScoreRankVO selectVO(@Param("ew") Wrapper<ScoreRankEntity> wrapper);
   	
   	List<ScoreRankView> selectListView(Wrapper<ScoreRankEntity> wrapper);
   	
   	ScoreRankView selectView(@Param("ew") Wrapper<ScoreRankEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ScoreRankEntity> wrapper);
   	

}

