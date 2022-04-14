package com.pmy.platform.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;
import com.pmy.platform.entity.ScoreRankEntity;
import com.pmy.platform.entity.view.ScoreRankView;
import com.pmy.platform.service.ScoreRankService;
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
 * 成绩排名 后端接口
 *
 * @author
 * @email
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/scoreRank")
public class ScoreRankController {

  @Autowired
  private ScoreRankService scoreRankService;

  /**
   * 后端列表
   */
  @RequestMapping("/page")
  public R page(@RequestParam Map<String, Object> params, ScoreRankEntity scoreRankEntity,
      HttpServletRequest request) {
    String tableName = request.getSession().getAttribute("tableName").toString();
    if (tableName.equals("parent")) {
      scoreRankEntity.setParentUsername((String) request.getSession().getAttribute("username"));
    }
    EntityWrapper<ScoreRankEntity> ew = new EntityWrapper<ScoreRankEntity>();
    PageUtils page = scoreRankService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, scoreRankEntity), params), params));

    return R.ok().put("data", page);
  }

  /**
   * 前端列表
   */
  @IgnoreAuth
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params, ScoreRankEntity scoreRankEntity,
      HttpServletRequest request) {
    EntityWrapper<ScoreRankEntity> ew = new EntityWrapper<ScoreRankEntity>();
    PageUtils page = scoreRankService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, scoreRankEntity), params), params));
    return R.ok().put("data", page);
  }

  /**
   * 列表
   */
  @RequestMapping("/lists")
  public R list(ScoreRankEntity scoreRankEntity) {
    EntityWrapper<ScoreRankEntity> ew = new EntityWrapper<ScoreRankEntity>();
    ew.allEq(MPUtil.allEQMapPre(scoreRankEntity, "scoreRank"));
    return R.ok().put("data", scoreRankService.selectListView(ew));
  }

  /**
   * 查询
   */
  @RequestMapping("/query")
  public R query(ScoreRankEntity scoreRankEntity) {
    EntityWrapper<ScoreRankEntity> ew = new EntityWrapper<ScoreRankEntity>();
    ew.allEq(MPUtil.allEQMapPre(scoreRankEntity, "scoreRank"));
    ScoreRankView scoreRankView = scoreRankService.selectView(ew);
    return R.ok("查询成绩排名成功").put("data", scoreRankView);
  }

  /**
   * 后端详情
   */
  @RequestMapping("/info/{id}")
  public R info(@PathVariable("id") Long id) {
    ScoreRankEntity scoreRankEntity = scoreRankService.selectById(id);
    return R.ok().put("data", scoreRankEntity);
  }

  /**
   * 前端详情
   */
  @IgnoreAuth
  @RequestMapping("/detail/{id}")
  public R detail(@PathVariable("id") Long id) {
    ScoreRankEntity scoreRankEntity = scoreRankService.selectById(id);
    return R.ok().put("data", scoreRankEntity);
  }


  /**
   * 后端保存
   */
  @RequestMapping("/save")
  public R save(@RequestBody ScoreRankEntity scoreRankEntity, HttpServletRequest request) {
    scoreRankEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(scoreRank);
    scoreRankService.insert(scoreRankEntity);
    return R.ok();
  }

  /**
   * 前端保存
   */
  @IgnoreAuth
  @RequestMapping("/add")
  public R add(@RequestBody ScoreRankEntity scoreRankEntity, HttpServletRequest request) {
    scoreRankEntity.setId(
        new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(scoreRank);
    scoreRankService.insert(scoreRankEntity);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  public R update(@RequestBody ScoreRankEntity scoreRankEntity, HttpServletRequest request) {
    //ValidatorUtils.validateEntity(scoreRank);
    scoreRankService.updateById(scoreRankEntity);//全部更新
    return R.ok();
  }


  /**
   * 删除
   */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] ids) {
    scoreRankService.deleteBatchIds(Arrays.asList(ids));
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

    Wrapper<ScoreRankEntity> wrapper = new EntityWrapper<ScoreRankEntity>();
    if (map.get("remindstart") != null) {
      wrapper.ge(columnName, map.get("remindstart"));
    }
    if (map.get("remindend") != null) {
      wrapper.le(columnName, map.get("remindend"));
    }

    String tableName = request.getSession().getAttribute("tableName").toString();
    if (tableName.equals("parent")) {
      wrapper.eq("parent_username", (String) request.getSession().getAttribute("username"));
    }

    int count = scoreRankService.selectCount(wrapper);
    return R.ok().put("count", count);
  }


}
