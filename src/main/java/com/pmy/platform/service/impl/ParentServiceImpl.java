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


import com.pmy.platform.dao.ParentDao;
import com.pmy.platform.entity.ParentEntity;
import com.pmy.platform.service.ParentService;
import com.pmy.platform.entity.vo.ParentVO;
import com.pmy.platform.entity.view.ParentView;

@Service("parentService")
public class ParentServiceImpl extends ServiceImpl<ParentDao, ParentEntity> implements ParentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ParentEntity> page = this.selectPage(
                new Query<ParentEntity>(params).getPage(),
                new EntityWrapper<ParentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ParentEntity> wrapper) {
		  Page<ParentView> page =new Query<ParentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ParentVO> selectListVO(Wrapper<ParentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ParentVO selectVO(Wrapper<ParentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ParentView> selectListView(Wrapper<ParentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ParentView selectView(Wrapper<ParentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
