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


import com.pmy.platform.dao.StudentDao;
import com.pmy.platform.entity.StudentEntity;
import com.pmy.platform.service.StudentService;
import com.pmy.platform.entity.vo.StudentVO;
import com.pmy.platform.entity.view.StudentView;

@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StudentEntity> page = this.selectPage(
                new Query<StudentEntity>(params).getPage(),
                new EntityWrapper<StudentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<StudentEntity> wrapper) {
		  Page<StudentView> page =new Query<StudentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<StudentVO> selectListVO(Wrapper<StudentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public StudentVO selectVO(Wrapper<StudentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<StudentView> selectListView(Wrapper<StudentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public StudentView selectView(Wrapper<StudentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
