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


import com.pmy.platform.dao.DiscussSchoolNoticeDao;
import com.pmy.platform.entity.DiscussSchoolNoticeEntity;
import com.pmy.platform.service.DiscussSchoolNoticeService;
import com.pmy.platform.entity.vo.DiscussSchoolNoticeVO;
import com.pmy.platform.entity.view.DiscussSchoolNoticeView;

@Service("discussSchoolNoticeService")
public class DiscussSchoolNoticeServiceImpl extends ServiceImpl<DiscussSchoolNoticeDao, DiscussSchoolNoticeEntity> implements DiscussSchoolNoticeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussSchoolNoticeEntity> page = this.selectPage(
                new Query<DiscussSchoolNoticeEntity>(params).getPage(),
                new EntityWrapper<DiscussSchoolNoticeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussSchoolNoticeEntity> wrapper) {
		  Page<DiscussSchoolNoticeView> page =new Query<DiscussSchoolNoticeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussSchoolNoticeVO> selectListVO(Wrapper<DiscussSchoolNoticeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussSchoolNoticeVO selectVO(Wrapper<DiscussSchoolNoticeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussSchoolNoticeView> selectListView(Wrapper<DiscussSchoolNoticeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussSchoolNoticeView selectView(Wrapper<DiscussSchoolNoticeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
