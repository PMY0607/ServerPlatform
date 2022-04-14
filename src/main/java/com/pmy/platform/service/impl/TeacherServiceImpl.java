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


import com.pmy.platform.dao.TeacherDao;
import com.pmy.platform.entity.TeacherEntity;
import com.pmy.platform.service.TeacherService;
import com.pmy.platform.entity.vo.TeacherVO;
import com.pmy.platform.entity.view.TeacherEntityView;

@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TeacherEntity> page = this.selectPage(
                new Query<TeacherEntity>(params).getPage(),
                new EntityWrapper<TeacherEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TeacherEntity> wrapper) {
		  Page<TeacherEntityView> page =new Query<TeacherEntityView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TeacherVO> selectListVO(Wrapper<TeacherEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TeacherVO selectVO(Wrapper<TeacherEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TeacherEntityView> selectListView(Wrapper<TeacherEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TeacherEntityView selectView(Wrapper<TeacherEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
