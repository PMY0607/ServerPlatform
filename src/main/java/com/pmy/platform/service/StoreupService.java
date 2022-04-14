package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.StoreupEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.StoreupVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.StoreupView;


/**
 * 收藏表
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface StoreupService extends IService<StoreupEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<StoreupVO> selectListVO(Wrapper<StoreupEntity> wrapper);
   	
   	StoreupVO selectVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
   	
   	List<StoreupView> selectListView(Wrapper<StoreupEntity> wrapper);
   	
   	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<StoreupEntity> wrapper);
   	

}

