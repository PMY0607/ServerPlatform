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


import com.pmy.platform.dao.ScoreDao;
import com.pmy.platform.entity.ScoreEntity;
import com.pmy.platform.service.ScoreService;
import com.pmy.platform.entity.vo.ScoreVO;
import com.pmy.platform.entity.view.ScoreView;

@Service("ScoreService")
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, ScoreEntity> implements ScoreService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ScoreEntity> page = this.selectPage(
                new Query<ScoreEntity>(params).getPage(),
                new EntityWrapper<ScoreEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ScoreEntity> wrapper) {
		  Page<ScoreView> page =new Query<ScoreView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ScoreVO> selectListVO(Wrapper<ScoreEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ScoreVO selectVO(Wrapper<ScoreEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ScoreView> selectListView(Wrapper<ScoreEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ScoreView selectView(Wrapper<ScoreEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
