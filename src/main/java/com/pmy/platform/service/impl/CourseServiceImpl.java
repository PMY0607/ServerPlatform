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


import com.pmy.platform.dao.CourseDao;
import com.pmy.platform.entity.CourseEntity;
import com.pmy.platform.service.CourseService;
import com.pmy.platform.entity.vo.CourseVO;
import com.pmy.platform.entity.view.CourseView;

@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CourseEntity> page = this.selectPage(
                new Query<CourseEntity>(params).getPage(),
                new EntityWrapper<CourseEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CourseEntity> wrapper) {
		  Page<CourseView> page =new Query<CourseView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CourseVO> selectListVO(Wrapper<CourseEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CourseVO selectVO(Wrapper<CourseEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CourseView> selectListView(Wrapper<CourseEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CourseView selectView(Wrapper<CourseEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
