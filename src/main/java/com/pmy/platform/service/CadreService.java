package com.pmy.platform.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.entity.CadreEntity;
import java.util.List;
import java.util.Map;
import com.pmy.platform.entity.vo.CadreVO;
import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.view.CadreView;


/**
 * 班干部
 *
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface CadreService extends IService<CadreEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CadreVO> selectListVO(Wrapper<CadreEntity> wrapper);
   	
   	CadreVO selectVO(@Param("ew") Wrapper<CadreEntity> wrapper);
   	
   	List<CadreView> selectListView(Wrapper<CadreEntity> wrapper);
   	
   	CadreView selectView(@Param("ew") Wrapper<CadreEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CadreEntity> wrapper);
   	

}

