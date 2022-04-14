package com.pmy.platform.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.utils.Query;


import com.pmy.platform.dao.CadreDao;
import com.pmy.platform.entity.CadreEntity;
import com.pmy.platform.service.CadreService;
import com.pmy.platform.entity.vo.CadreVO;
import com.pmy.platform.entity.view.CadreView;

@Service("cadreService")
public class CadreServiceImpl extends ServiceImpl<CadreDao, CadreEntity> implements CadreService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CadreEntity> page = this.selectPage(
                new Query<CadreEntity>(params).getPage(),
                new EntityWrapper<CadreEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CadreEntity> wrapper) {
		  Page<CadreView> page =new Query<CadreView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CadreVO> selectListVO(Wrapper<CadreEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CadreVO selectVO(Wrapper<CadreEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CadreView> selectListView(Wrapper<CadreEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CadreView selectView(Wrapper<CadreEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
