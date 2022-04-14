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


import com.pmy.platform.dao.ClazzDao;
import com.pmy.platform.entity.ClazzEntity;
import com.pmy.platform.service.ClazzService;
import com.pmy.platform.entity.vo.ClazzVO;
import com.pmy.platform.entity.view.ClazzView;

@Service("clazzService")
public class ClazzServiceImpl extends ServiceImpl<ClazzDao, ClazzEntity> implements ClazzService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClazzEntity> page = this.selectPage(
                new Query<ClazzEntity>(params).getPage(),
                new EntityWrapper<ClazzEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ClazzEntity> wrapper) {
		  Page<ClazzView> page =new Query<ClazzView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ClazzVO> selectListVO(Wrapper<ClazzEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ClazzVO selectVO(Wrapper<ClazzEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ClazzView> selectListView(Wrapper<ClazzEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ClazzView selectView(Wrapper<ClazzEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
