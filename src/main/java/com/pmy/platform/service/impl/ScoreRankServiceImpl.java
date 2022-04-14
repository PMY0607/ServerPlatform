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


import com.pmy.platform.dao.scoreRankDao;
import com.pmy.platform.entity.ScoreRankEntity;
import com.pmy.platform.service.ScoreRankService;
import com.pmy.platform.entity.vo.ScoreRankVO;
import com.pmy.platform.entity.view.ScoreRankView;

@Service("scoreRankService")
public class ScoreRankServiceImpl extends ServiceImpl<scoreRankDao, ScoreRankEntity> implements ScoreRankService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ScoreRankEntity> page = this.selectPage(
                new Query<ScoreRankEntity>(params).getPage(),
                new EntityWrapper<ScoreRankEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ScoreRankEntity> wrapper) {
		  Page<ScoreRankView> page =new Query<ScoreRankView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ScoreRankVO> selectListVO(Wrapper<ScoreRankEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ScoreRankVO selectVO(Wrapper<ScoreRankEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ScoreRankView> selectListView(Wrapper<ScoreRankEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ScoreRankView selectView(Wrapper<ScoreRankEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
