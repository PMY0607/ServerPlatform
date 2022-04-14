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


import com.pmy.platform.dao.SchoolNoticeDao;
import com.pmy.platform.entity.SchoolNoticeEntity;
import com.pmy.platform.service.SchoolNoticeService;
import com.pmy.platform.entity.vo.SchoolNoticeVO;
import com.pmy.platform.entity.view.SchoolNoticeView;

@Service("schoolNoticeService")
public class SchoolNoticeServiceImpl extends ServiceImpl<SchoolNoticeDao, SchoolNoticeEntity> implements SchoolNoticeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SchoolNoticeEntity> page = this.selectPage(
                new Query<SchoolNoticeEntity>(params).getPage(),
                new EntityWrapper<SchoolNoticeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SchoolNoticeEntity> wrapper) {
		  Page<SchoolNoticeView> page =new Query<SchoolNoticeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SchoolNoticeVO> selectListVO(Wrapper<SchoolNoticeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SchoolNoticeVO selectVO(Wrapper<SchoolNoticeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SchoolNoticeView> selectListView(Wrapper<SchoolNoticeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SchoolNoticeView selectView(Wrapper<SchoolNoticeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
