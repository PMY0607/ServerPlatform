package com.pmy.platform.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;
import com.pmy.platform.entity.ClazzNoticeEntity;
import com.pmy.platform.entity.view.ClazzNoticeView;
import com.pmy.platform.service.ClazzNoticeService;
import com.pmy.platform.service.StoreupService;
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
 * 班级公告 后端接口
 *
 * @author
 * @email
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/clazzNotice")
public class ClazzNoticeController {

  @Autowired
  private ClazzNoticeService clazzNoticeService;

  @Autowired
  private StoreupService storeupService;


  /**
   * 后端列表
   */
  @RequestMapping("/page")
  public R page(@RequestParam Map<String, Object> params, ClazzNoticeEntity clazzNoticeEntity,
      HttpServletRequest request) {
    String tableName = request.getSession().getAttribute("tableName").toString();
    if (tableName.equals("teacher")) {
      clazzNoticeEntity.setTeacherUsername((String) request.getSession().getAttribute("username"));
    }
    EntityWrapper<ClazzNoticeEntity> ew = new EntityWrapper<ClazzNoticeEntity>();
    PageUtils page = clazzNoticeService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, clazzNoticeEntity), params), params));

    return R.ok().put("data", page);
  }

  /**
   * 前端列表
   */
  @IgnoreAuth
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params, ClazzNoticeEntity clazzNoticeEntity,
      HttpServletRequest request) {
    EntityWrapper<ClazzNoticeEntity> ew = new EntityWrapper<ClazzNoticeEntity>();
    PageUtils page = clazzNoticeService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, clazzNoticeEntity), params), params));
    return R.ok().put("data", page);
  }

  /**
   * 列表
   */
  @RequestMapping("/lists")
  public R list(ClazzNoticeEntity clazzNoticeEntity) {
    EntityWrapper<ClazzNoticeEntity> ew = new EntityWrapper<ClazzNoticeEntity>();
    ew.allEq(MPUtil.allEQMapPre(clazzNoticeEntity, "clazzNoticeEntity"));
    return R.ok().put("data", clazzNoticeService.selectListView(ew));
  }

  /**
   * 查询
   */
  @RequestMapping("/query")
  public R query(ClazzNoticeEntity clazzNoticeEntity) {
    EntityWrapper<ClazzNoticeEntity> ew = new EntityWrapper<ClazzNoticeEntity>();
    ew.allEq(MPUtil.allEQMapPre(clazzNoticeEntity, "clazzNoticeEntity"));
    ClazzNoticeView clazzNoticeView = clazzNoticeService.selectView(ew);
    return R.ok("查询班级公告成功").put("data", clazzNoticeView);
  }

  /**
   * 后端详情
   */
  @RequestMapping("/info/{id}")
  public R info(@PathVariable("id") Long id) {
    ClazzNoticeEntity clazzNoticeEntity = clazzNoticeService.selectById(id);
    clazzNoticeEntity.setClickNum(clazzNoticeEntity.getClickNum() + 1);
    clazzNoticeEntity.setClickTime(new Date());
    clazzNoticeService.updateById(clazzNoticeEntity);
    return R.ok().put("data", clazzNoticeEntity);
  }

  /**
   * 前端详情
   */
  @IgnoreAuth
  @RequestMapping("/detail/{id}")
  public R detail(@PathVariable("id") Long id) {
    ClazzNoticeEntity clazzNoticeEntity = clazzNoticeService.selectById(id);
    clazzNoticeEntity.setClickNum(clazzNoticeEntity.getClickNum() + 1);
    clazzNoticeEntity.setClickTime(new Date());
    clazzNoticeService.updateById(clazzNoticeEntity);
    return R.ok().put("data", clazzNoticeEntity);
  }


  /**
   * 后端保存
   */
  @RequestMapping("/save")
  public R save(@RequestBody ClazzNoticeEntity clazzNoticeEntity, HttpServletRequest request) {
    clazzNoticeEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(clazzNoticeEntity);
    clazzNoticeService.insert(clazzNoticeEntity);
    return R.ok();
  }

  /**
   * 前端保存
   */
  @IgnoreAuth
  @RequestMapping("/add")
  public R add(@RequestBody ClazzNoticeEntity clazzNoticeEntity, HttpServletRequest request) {
    clazzNoticeEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(clazzNoticeEntity);
    clazzNoticeService.insert(clazzNoticeEntity);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  public R update(@RequestBody ClazzNoticeEntity clazzNoticeEntity, HttpServletRequest request) {
    //ValidatorUtils.validateEntity(clazzNoticeEntity);
    clazzNoticeService.updateById(clazzNoticeEntity);//全部更新
    return R.ok();
  }


  /**
   * 删除
   */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] ids) {
    clazzNoticeService.deleteBatchIds(Arrays.asList(ids));
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

    Wrapper<ClazzNoticeEntity> wrapper = new EntityWrapper<ClazzNoticeEntity>();
    if (map.get("remindstart") != null) {
      wrapper.ge(columnName, map.get("remindstart"));
    }
    if (map.get("remindend") != null) {
      wrapper.le(columnName, map.get("remindend"));
    }

    String tableName = request.getSession().getAttribute("tableName").toString();
    if (tableName.equals("teacher")) {
      wrapper.eq("teacher_username", (String) request.getSession().getAttribute("username"));
    }

    int count = clazzNoticeService.selectCount(wrapper);
    return R.ok().put("count", count);
  }

  /**
   * 前端智能排序
   */
  @IgnoreAuth
  @RequestMapping("/autoSort")
  public R autoSort(@RequestParam Map<String, Object> params, ClazzNoticeEntity clazzNoticeEntity,
      HttpServletRequest request, String pre) {
    EntityWrapper<ClazzNoticeEntity> ew = new EntityWrapper<ClazzNoticeEntity>();
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
    PageUtils page = clazzNoticeService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, clazzNoticeEntity), params), params));
    return R.ok().put("data", page);
  }


}
