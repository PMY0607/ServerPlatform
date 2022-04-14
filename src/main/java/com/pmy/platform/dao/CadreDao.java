package com.pmy.platform.dao;

import com.pmy.platform.entity.CadreEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.pmy.platform.entity.vo.CadreVO;
import com.pmy.platform.entity.view.CadreView;


/**
 * 班干部
 * 
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public interface CadreDao extends BaseMapper<CadreEntity> {
	
	List<CadreVO> selectListVO(@Param("ew") Wrapper<CadreEntity> wrapper);
	
	CadreVO selectVO(@Param("ew") Wrapper<CadreEntity> wrapper);
	
	List<CadreView> selectListView(@Param("ew") Wrapper<CadreEntity> wrapper);

	List<CadreView> selectListView(Pagination page, @Param("ew") Wrapper<CadreEntity> wrapper);
	
	CadreView selectView(@Param("ew") Wrapper<CadreEntity> wrapper);
	

}
