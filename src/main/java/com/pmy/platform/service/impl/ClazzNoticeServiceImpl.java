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


import com.pmy.platform.dao.ClazzNoticeDao;
import com.pmy.platform.entity.ClazzNoticeEntity;
import com.pmy.platform.service.ClazzNoticeService;
import com.pmy.platform.entity.vo.ClazzNoticeVO;
import com.pmy.platform.entity.view.ClazzNoticeView;

@Service("clazzNoticeService")
public class ClazzNoticeServiceImpl extends ServiceImpl<ClazzNoticeDao, ClazzNoticeEntity> implements ClazzNoticeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClazzNoticeEntity> page = this.selectPage(
                new Query<ClazzNoticeEntity>(params).getPage(),
                new EntityWrapper<ClazzNoticeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ClazzNoticeEntity> wrapper) {
		  Page<ClazzNoticeView> page =new Query<ClazzNoticeView>(params).getPage();

	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ClazzNoticeVO> selectListVO(Wrapper<ClazzNoticeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ClazzNoticeVO selectVO(Wrapper<ClazzNoticeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ClazzNoticeView> selectListView(Wrapper<ClazzNoticeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ClazzNoticeView selectView(Wrapper<ClazzNoticeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
