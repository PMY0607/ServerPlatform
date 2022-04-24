package com.pmy.platform.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;

import com.pmy.platform.entity.DiscussSchoolNoticeEntity;
import com.pmy.platform.entity.view.DiscussSchoolNoticeView;

import com.pmy.platform.service.DiscussSchoolNoticeService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.utils.R;
import com.pmy.platform.utils.MPUtil;

/**
 * 学校公告评论表
 * 后端接口
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/discussSchoolNotice")
public class DiscussSchoolNoticeController {
    @Autowired
    private DiscussSchoolNoticeService discussSchoolNoticeService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscussSchoolNoticeEntity discussSchoolNoticeEntity,
                  HttpServletRequest request){
        EntityWrapper<DiscussSchoolNoticeEntity> ew = new EntityWrapper<DiscussSchoolNoticeEntity>();
		PageUtils page = discussSchoolNoticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussSchoolNoticeEntity), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussSchoolNoticeEntity discussSchoolNoticeEntity,
                  HttpServletRequest request){
        EntityWrapper<DiscussSchoolNoticeEntity> ew = new EntityWrapper<DiscussSchoolNoticeEntity>();
		PageUtils page = discussSchoolNoticeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussSchoolNoticeEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussSchoolNoticeEntity discussSchoolNoticeEntity){
       	EntityWrapper<DiscussSchoolNoticeEntity> ew = new EntityWrapper<DiscussSchoolNoticeEntity>();
       	//todo
      	ew.allEq(MPUtil.allEQMapPre( discussSchoolNoticeEntity, "discussSchoolNotice"));
        return R.ok().put("data", discussSchoolNoticeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussSchoolNoticeEntity discussSchoolNoticeEntity){
        EntityWrapper<DiscussSchoolNoticeEntity> ew = new EntityWrapper<DiscussSchoolNoticeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussSchoolNoticeEntity, "discussSchoolNotice"));
		DiscussSchoolNoticeView discussSchoolNoticeView =  discussSchoolNoticeService.selectView(ew);
		return R.ok("查询学校公告评论表成功").put("data", discussSchoolNoticeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussSchoolNoticeEntity discussSchoolNoticeEntity = discussSchoolNoticeService.selectById(id);
        return R.ok().put("data", discussSchoolNoticeEntity);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussSchoolNoticeEntity discussSchoolNoticeEntity = discussSchoolNoticeService.selectById(id);
        return R.ok().put("data", discussSchoolNoticeEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussSchoolNoticeEntity discussSchoolNoticeEntity, HttpServletRequest request){
    	discussSchoolNoticeEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussSchoolNotice);
        discussSchoolNoticeService.insert(discussSchoolNoticeEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussSchoolNoticeEntity discussSchoolNoticeEntity, HttpServletRequest request){
    	discussSchoolNoticeEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussSchoolNotice);
        discussSchoolNoticeService.insert(discussSchoolNoticeEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussSchoolNoticeEntity discussSchoolNoticeEntity, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussSchoolNotice);
        discussSchoolNoticeService.updateById(discussSchoolNoticeEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussSchoolNoticeService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussSchoolNoticeEntity> wrapper = new EntityWrapper<DiscussSchoolNoticeEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussSchoolNoticeService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
