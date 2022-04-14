package com.pmy.platform.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;
import com.pmy.platform.entity.ClazzEntity;
import com.pmy.platform.entity.view.ClazzView;
import com.pmy.platform.service.ClazzService;
import com.pmy.platform.utils.MPUtil;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.utils.R;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 班级信息 后端接口
 *
 * @author
 * @email
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/clazz")
public class ClazzController {

  @Autowired
  private ClazzService clazzService;

  /**
   * 后端列表
   */
  @RequestMapping("/page")
  public R page(@RequestParam Map<String, Object> params, ClazzEntity clazzEntity,
      HttpServletRequest request) {
    EntityWrapper<ClazzEntity> ew = new EntityWrapper<ClazzEntity>();
    PageUtils page = clazzService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, clazzEntity), params), params));

    return R.ok().put("data", page);
  }

  /**
   * 前端列表
   */
  @IgnoreAuth
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params, ClazzEntity clazzEntity,
      HttpServletRequest request) {
    EntityWrapper<ClazzEntity> ew = new EntityWrapper<ClazzEntity>();
    PageUtils page = clazzService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, clazzEntity), params), params));
    return R.ok().put("data", page);
  }

  /**
   * 列表
   */
  @RequestMapping("/lists")
  public R list(ClazzEntity clazzEntity) {
    EntityWrapper<ClazzEntity> ew = new EntityWrapper<ClazzEntity>();
    ew.allEq(MPUtil.allEQMapPre(clazzEntity, "clazz"));
    return R.ok().put("data", clazzService.selectListView(ew));
  }

  /**
   * 查询
   */
  @RequestMapping("/query")
  public R query(ClazzEntity clazzEntity) {
    EntityWrapper<ClazzEntity> ew = new EntityWrapper<ClazzEntity>();
    ew.allEq(MPUtil.allEQMapPre(clazzEntity, "clazz"));
    ClazzView clazzView = clazzService.selectView(ew);
    return R.ok("查询班级信息成功").put("data", clazzView);
  }

  /**
   * 后端详情
   */
  @RequestMapping("/info/{id}")
  public R info(@PathVariable("id") Long id) {
    ClazzEntity clazzEntity = clazzService.selectById(id);
    clazzEntity.setClickNum(clazzEntity.getClickNum() + 1);
    clazzEntity.setClickTime(new Date());
    clazzService.updateById(clazzEntity);
    return R.ok().put("data", clazzEntity);
  }

  /**
   * 前端详情
   */
  @IgnoreAuth
  @RequestMapping("/detail/{id}")
  public R detail(@PathVariable("id") Long id) {
    ClazzEntity clazzEntity = clazzService.selectById(id);
    clazzEntity.setClickNum(clazzEntity.getClickNum() + 1);
    clazzEntity.setClickTime(new Date());
    clazzService.updateById(clazzEntity);
    return R.ok().put("data", clazzEntity);
  }


  /**
   * 后端保存
   */
  @RequestMapping("/save")
  public R save(@RequestBody ClazzEntity clazzEntity, HttpServletRequest request) {
    clazzEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(clazz);
    clazzService.insert(clazzEntity);
    return R.ok();
  }

  /**
   * 前端保存
   */
  @RequestMapping("/add")
  public R add(@RequestBody ClazzEntity clazzEntity, HttpServletRequest request) {
    clazzEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(clazz);
    clazzService.insert(clazzEntity);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  public R update(@RequestBody ClazzEntity clazzEntity, HttpServletRequest request) {
    //ValidatorUtils.validateEntity(clazz);
    clazzService.updateById(clazzEntity);//全部更新
    return R.ok();
  }


  /**
   * 删除
   */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] ids) {
    clazzService.deleteBatchIds(Arrays.asList(ids));
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

    Wrapper<ClazzEntity> wrapper = new EntityWrapper<ClazzEntity>();
    if (map.get("remindstart") != null) {
      wrapper.ge(columnName, map.get("remindstart"));
    }
    if (map.get("remindend") != null) {
      wrapper.le(columnName, map.get("remindend"));
    }

    int count = clazzService.selectCount(wrapper);
    return R.ok().put("count", count);
  }

  /**
   * 前端智能排序
   */
  @IgnoreAuth
  @RequestMapping("/autoSort")
  public R autoSort(@RequestParam Map<String, Object> params, ClazzEntity clazzEntity,
      HttpServletRequest request, String pre) {
    EntityWrapper<ClazzEntity> ew = new EntityWrapper<ClazzEntity>();
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
    PageUtils page = clazzService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, clazzEntity), params), params));
    return R.ok().put("data", page);
  }


}
