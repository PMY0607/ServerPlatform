package com.pmy.platform.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;

import com.pmy.platform.entity.CourseEntity;
import com.pmy.platform.entity.view.CourseView;

import com.pmy.platform.service.CourseService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.utils.R;
import com.pmy.platform.utils.MPUtil;

/**
 * 课程信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService CourseService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CourseEntity courseEntity,
				  HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("teacher")) {
			courseEntity.setTeacherUsername((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
		PageUtils page = CourseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, courseEntity), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, CourseEntity courseEntity,
				  HttpServletRequest request){
        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
		PageUtils page = CourseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, courseEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CourseEntity courseEntity){
       	EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
      	ew.allEq(MPUtil.allEQMapPre( courseEntity, "course"));
        return R.ok().put("data", CourseService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CourseEntity courseEntity){
        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
 		ew.allEq(MPUtil.allEQMapPre( courseEntity, "course"));
		CourseView courseView =  CourseService.selectView(ew);
		return R.ok("查询课程信息成功").put("data", courseView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CourseEntity courseEntity = CourseService.selectById(id);
		courseEntity.setClickNum(courseEntity.getClickNum()+1);
		courseEntity.setClickTime(new Date());
		CourseService.updateById(courseEntity);
        return R.ok().put("data", courseEntity);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CourseEntity courseEntity = CourseService.selectById(id);
		courseEntity.setClickNum(courseEntity.getClickNum()+1);
		courseEntity.setClickTime(new Date());
		CourseService.updateById(courseEntity);
        return R.ok().put("data", courseEntity);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        CourseEntity courseEntity = CourseService.selectById(id);
        if(type.equals("1")) {
        	courseEntity.setThumbsUpNum(courseEntity.getThumbsUpNum()+1);
        } else {
        	courseEntity.setCrazilyNum(courseEntity.getCrazilyNum()+1);
        }
        CourseService.updateById(courseEntity);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CourseEntity courseEntity, HttpServletRequest request){
    	courseEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(course);
        CourseService.insert(courseEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CourseEntity courseEntity, HttpServletRequest request){
    	courseEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(course);
        CourseService.insert(courseEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CourseEntity courseEntity, HttpServletRequest request){
        //ValidatorUtils.validateEntity(course);
        CourseService.updateById(courseEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        CourseService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CourseEntity> wrapper = new EntityWrapper<CourseEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("teacher")) {
			wrapper.eq("teacher_username", (String)request.getSession().getAttribute("username"));
		}

		int count = CourseService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params, CourseEntity courseEntity, HttpServletRequest request, String pre){
        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "click_num");
        params.put("order", "desc");
		PageUtils page = CourseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, courseEntity), params), params));
        return R.ok().put("data", page);
    }







}
