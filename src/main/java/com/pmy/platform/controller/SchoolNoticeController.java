package com.pmy.platform.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;
import com.pmy.platform.entity.SchoolNoticeEntity;
import com.pmy.platform.entity.view.SchoolNoticeView;
import com.pmy.platform.service.SchoolNoticeService;
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
 * 学校公告 后端接口
 *
 * @author
 * @email
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/schoolNotice")
public class SchoolNoticeController {

  @Autowired
  private SchoolNoticeService schoolNoticeService;
  @Autowired
  private StoreupService storeupService;

  /**
   * 后端列表
   */
  @RequestMapping("/page")
  public R page(@RequestParam Map<String, Object> params, SchoolNoticeEntity schoolNoticeEntity,
      HttpServletRequest request) {
    EntityWrapper<SchoolNoticeEntity> ew = new EntityWrapper<SchoolNoticeEntity>();
    PageUtils page = schoolNoticeService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, schoolNoticeEntity), params), params));

    return R.ok().put("data", page);
  }

  /**
   * 前端列表
   */
  @IgnoreAuth
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params, SchoolNoticeEntity schoolNoticeEntity,
      HttpServletRequest request) {
    EntityWrapper<SchoolNoticeEntity> ew = new EntityWrapper<SchoolNoticeEntity>();
    PageUtils page = schoolNoticeService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, schoolNoticeEntity), params), params));
    return R.ok().put("data", page);
  }

  /**
   * 列表
   */
  @RequestMapping("/lists")
  public R list(SchoolNoticeEntity schoolNoticeEntity) {
    EntityWrapper<SchoolNoticeEntity> ew = new EntityWrapper<SchoolNoticeEntity>();
    ew.allEq(MPUtil.allEQMapPre(schoolNoticeEntity, "schoolNoticeEntity"));
    return R.ok().put("data", schoolNoticeService.selectListView(ew));
  }

  /**
   * 查询
   */
  @RequestMapping("/query")
  public R query(SchoolNoticeEntity schoolNoticeEntity) {
    EntityWrapper<SchoolNoticeEntity> ew = new EntityWrapper<SchoolNoticeEntity>();
    ew.allEq(MPUtil.allEQMapPre(schoolNoticeEntity, "schoolNoticeEntity"));
    SchoolNoticeView schoolNoticeView = schoolNoticeService.selectView(ew);
    return R.ok("查询学校公告成功").put("data", schoolNoticeView);
  }

  /**
   * 后端详情
   */
  @RequestMapping("/info/{id}")
  public R info(@PathVariable("id") Long id) {
    SchoolNoticeEntity schoolNoticeEntity = schoolNoticeService.selectById(id);
    schoolNoticeEntity.setClickNum(schoolNoticeEntity.getClickNum() + 1);
    schoolNoticeEntity.setClickTime(new Date());
    schoolNoticeService.updateById(schoolNoticeEntity);
    return R.ok().put("data", schoolNoticeEntity);
  }

  /**
   * 前端详情
   */
  @IgnoreAuth
  @RequestMapping("/detail/{id}")
  public R detail(@PathVariable("id") Long id) {
    SchoolNoticeEntity schoolNoticeEntity = schoolNoticeService.selectById(id);
    schoolNoticeEntity.setClickNum(schoolNoticeEntity.getClickNum() + 1);
    schoolNoticeEntity.setClickTime(new Date());
    schoolNoticeService.updateById(schoolNoticeEntity);
    return R.ok().put("data", schoolNoticeEntity);
  }


  /**
   * 后端保存
   */
  @RequestMapping("/save")
  public R save(@RequestBody SchoolNoticeEntity schoolNoticeEntity, HttpServletRequest request) {
    schoolNoticeEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(schoolNoticeEntity);
    schoolNoticeService.insert(schoolNoticeEntity);
    return R.ok();
  }

  /**
   * 前端保存
   */
  @IgnoreAuth
  @RequestMapping("/add")
  public R add(@RequestBody SchoolNoticeEntity schoolNoticeEntity, HttpServletRequest request) {
    schoolNoticeEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(schoolNoticeEntity);
    schoolNoticeService.insert(schoolNoticeEntity);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  public R update(@RequestBody SchoolNoticeEntity schoolNoticeEntity, HttpServletRequest request) {
    //ValidatorUtils.validateEntity(schoolNoticeEntity);
    schoolNoticeService.updateById(schoolNoticeEntity);//全部更新
    return R.ok();
  }


  /**
   * 删除
   */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] ids) {
    schoolNoticeService.deleteBatchIds(Arrays.asList(ids));
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

    Wrapper<SchoolNoticeEntity> wrapper = new EntityWrapper<SchoolNoticeEntity>();
    if (map.get("remindstart") != null) {
      wrapper.ge(columnName, map.get("remindstart"));
    }
    if (map.get("remindend") != null) {
      wrapper.le(columnName, map.get("remindend"));
    }

    int count = schoolNoticeService.selectCount(wrapper);
    return R.ok().put("count", count);
  }

  /**
   * 前端智能排序
   */
  @IgnoreAuth
  @RequestMapping("/autoSort")
  public R autoSort(@RequestParam Map<String, Object> params, SchoolNoticeEntity schoolNoticeEntity,
      HttpServletRequest request, String pre) {
    EntityWrapper<SchoolNoticeEntity> ew = new EntityWrapper<SchoolNoticeEntity>();
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
    PageUtils page = schoolNoticeService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, schoolNoticeEntity), params), params));
    return R.ok().put("data", page);
  }


}
