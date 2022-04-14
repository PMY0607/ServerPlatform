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

import com.pmy.platform.entity.ScoreEntity;
import com.pmy.platform.entity.view.ScoreView;

import com.pmy.platform.service.ScoreService;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.utils.R;
import com.pmy.platform.utils.MPUtil;
import com.pmy.platform.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 学生成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ScoreEntity scoreEntity,
                  HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("teacher")) {
			scoreEntity.setTeacherUsername((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("parent")) {
			scoreEntity.setParentUsername((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ScoreEntity> ew = new EntityWrapper<ScoreEntity>();
		PageUtils page = scoreService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, scoreEntity), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ScoreEntity scoreEntity,
                  HttpServletRequest request){
        EntityWrapper<ScoreEntity> ew = new EntityWrapper<ScoreEntity>();
		PageUtils page = scoreService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, scoreEntity), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ScoreEntity scoreEntity){
       	EntityWrapper<ScoreEntity> ew = new EntityWrapper<ScoreEntity>();
      	ew.allEq(MPUtil.allEQMapPre( scoreEntity, "scoreEntity"));
        return R.ok().put("data", scoreService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ScoreEntity scoreEntity){
        EntityWrapper<ScoreEntity> ew = new EntityWrapper<ScoreEntity>();
 		ew.allEq(MPUtil.allEQMapPre( scoreEntity, "scoreEntity"));
		ScoreView scoreView =  scoreService.selectView(ew);
		return R.ok("查询学生成绩成功").put("data", scoreView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ScoreEntity scoreEntity = scoreService.selectById(id);
        return R.ok().put("data", scoreEntity);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ScoreEntity scoreEntity = scoreService.selectById(id);
        return R.ok().put("data", scoreEntity);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ScoreEntity scoreEntity, HttpServletRequest request){
    	scoreEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(scoreEntity);
        scoreService.insert(scoreEntity);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ScoreEntity scoreEntity, HttpServletRequest request){
    	scoreEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(scoreEntity);
        scoreService.insert(scoreEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ScoreEntity scoreEntity, HttpServletRequest request){
        //ValidatorUtils.validateEntity(scoreEntity);
        scoreService.updateById(scoreEntity);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        scoreService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ScoreEntity> wrapper = new EntityWrapper<ScoreEntity>();
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
		if(tableName.equals("parent")) {
			wrapper.eq("parent_username", (String)request.getSession().getAttribute("username"));
		}

		int count = scoreService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	





    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    ScoreEntity scoreEntity =new ScoreEntity();
                    scoreEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
                    String stuNo = CommonUtil.getCellValue(row.getCell(0));
                    scoreEntity.setStuNo(stuNo);
                    String name = CommonUtil.getCellValue(row.getCell(1));
                    scoreEntity.setName(name);
                    String clazz = CommonUtil.getCellValue(row.getCell(2));
                    scoreEntity.setClazz(clazz);
                    String score = CommonUtil.getCellValue(row.getCell(3));
                    scoreEntity.setScore(score);
                    String comment = CommonUtil.getCellValue(row.getCell(4));
                    scoreEntity.setComment(comment);
                    String teacherUsername = CommonUtil.getCellValue(row.getCell(5));
                    scoreEntity.setTeacherUsername(teacherUsername);
                    String teacherName = CommonUtil.getCellValue(row.getCell(6));
                    scoreEntity.setTeacherName(teacherName);
                     
                    //想数据库中添加新对象
                    scoreService.insert(scoreEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }


}
