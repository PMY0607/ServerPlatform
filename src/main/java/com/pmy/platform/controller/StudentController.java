package com.pmy.platform.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;
import com.pmy.platform.entity.StudentEntity;
import com.pmy.platform.entity.view.StudentView;
import com.pmy.platform.service.StudentService;
import com.pmy.platform.utils.MPUtil;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.utils.R;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生信息 后端接口
 *
 * @author
 * @email
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  /**
   * 后端列表
   */
  @RequestMapping("/page")
  public R page(@RequestParam Map<String, Object> params, StudentEntity studentEntity,
      HttpServletRequest request) {
    EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
    PageUtils page = studentService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, studentEntity), params), params));

    return R.ok().put("data", page);
  }

  /**
   * 前端列表
   */
  @IgnoreAuth
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params, StudentEntity studentEntity,
      HttpServletRequest request) {
    EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
    PageUtils page = studentService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, studentEntity), params), params));
    return R.ok().put("data", page);
  }

  /**
   * 列表
   */
  @RequestMapping("/lists")
  public R list(StudentEntity studentEntity) {
    EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
    ew.allEq(MPUtil.allEQMapPre(studentEntity, "studentEntity"));
    return R.ok().put("data", studentService.selectListView(ew));
  }

  /**
   * 查询
   */
  @RequestMapping("/query")
  public R query(StudentEntity studentEntity) {
    EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
    ew.allEq(MPUtil.allEQMapPre(studentEntity, "studentEntity"));
    StudentView studentView = studentService.selectView(ew);
    return R.ok("查询学生信息成功").put("data", studentView);
  }

  /**
   * 后端详情
   */
  @RequestMapping("/info/{id}")
  public R info(@PathVariable("id") Long id) {
    StudentEntity studentEntity = studentService.selectById(id);
    return R.ok().put("data", studentEntity);
  }

  /**
   * 前端详情
   */
  @IgnoreAuth
  @RequestMapping("/detail/{id}")
  public R detail(@PathVariable("id") Long id) {
    StudentEntity studentEntity = studentService.selectById(id);
    return R.ok().put("data", studentEntity);
  }


  /**
   * 后端保存
   */
  @RequestMapping("/save")
  public R save(@RequestBody StudentEntity studentEntity, HttpServletRequest request) {
    studentEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(studentEntity);
    studentService.insert(studentEntity);
    return R.ok();
  }

  /**
   * 前端保存
   */
  @RequestMapping("/add")
  public R add(@RequestBody StudentEntity studentEntity, HttpServletRequest request) {
    studentEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(studentEntity);
    studentService.insert(studentEntity);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  public R update(@RequestBody StudentEntity studentEntity, HttpServletRequest request) {
    //ValidatorUtils.validateEntity(studentEntity);
    studentService.updateById(studentEntity);//全部更新
    return R.ok();
  }


  /**
   * 删除
   */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] ids) {
    studentService.deleteBatchIds(Arrays.asList(ids));
    return R.ok();
  }

  /**
   * 提醒接口
   */
  @RequestMapping("/remind/{columnName}/{type}")
  public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
      @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
    map.put("column", columnName);
    map.put("type", type);

    if (type.equals("2")) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Calendar c = Calendar.getInstance();
      Date remindStartDate = null;
      Date remindEndDate = null;
      if (map.get("remindstart") != null) {
        Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, remindStart);
        remindStartDate = c.getTime();
        map.put("remindstart", sdf.format(remindStartDate));
      }
      if (map.get("remindend") != null) {
        Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, remindEnd);
        remindEndDate = c.getTime();
        map.put("remindend", sdf.format(remindEndDate));
      }
    }

    Wrapper<StudentEntity> wrapper = new EntityWrapper<StudentEntity>();
    if (map.get("remindstart") != null) {
      wrapper.ge(columnName, map.get("remindstart"));
    }
    if (map.get("remindend") != null) {
      wrapper.le(columnName, map.get("remindend"));
    }

    int count = studentService.selectCount(wrapper);
    return R.ok().put("count", count);
  }


}
