package com.pmy.platform.dao;

import com.pmy.platform.entity.StoreupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.StoreupVO;
import com.pmy.platform.entity.view.StoreupView;


/**
 * 收藏表
 * 
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface StoreupDao extends BaseMapper<StoreupEntity> {
	
	List<StoreupVO> selectListVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	StoreupVO selectVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	List<StoreupView> selectListView(@Param("ew") Wrapper<StoreupEntity> wrapper);

	List<StoreupView> selectListView(Pagination page,@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);
	

}
