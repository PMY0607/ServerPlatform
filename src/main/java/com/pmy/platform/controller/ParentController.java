package com.pmy.platform.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.annotation.IgnoreAuth;
import com.pmy.platform.entity.ParentEntity;
import com.pmy.platform.entity.view.ParentView;
import com.pmy.platform.service.ParentService;
import com.pmy.platform.service.TokenService;
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
 * 家长 后端接口
 *
 * @author
 * @email
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/parent")
public class ParentController {

  @Autowired
  private ParentService parentService;
  @Autowired
  private TokenService tokenService;

  /**
   * 登录
   */
  @IgnoreAuth
  @RequestMapping(value = "/login")
  public R login(String username, String password, String captcha, HttpServletRequest request) {
    ParentEntity user = parentService.selectOne(
        new EntityWrapper<ParentEntity>().eq("username", username));
    if (user == null || !user.getPassword().equals(password)) {
      return R.error("账号或密码不正确");
    }

    String token = tokenService.generateToken(user.getId(), username, "parent", "家长");
    return R.ok().put("token", token);
  }

  /**
   * 注册
   */
  @IgnoreAuth
  @RequestMapping("/register")
  public R register(@RequestBody ParentEntity parent) {
    //ValidatorUtils.validateEntity(parent);
    ParentEntity user = parentService.selectOne(
        new EntityWrapper<ParentEntity>().eq("username", parent.getUsername()));
    if (user != null) {
      return R.error("注册用户已存在");
    }
    Long uId = new Date().getTime();
    parent.setId(uId);
    parentService.insert(parent);
    return R.ok();
  }


  /**
   * 退出
   */
  @RequestMapping("/logout")
  public R logout(HttpServletRequest request) {
    request.getSession().invalidate();
    return R.ok("退出成功");
  }

  /**
   * 获取用户的session用户信息
   */
  @RequestMapping("/session")
  public R getCurrUser(HttpServletRequest request) {
    Long id = (Long) request.getSession().getAttribute("userId");
    ParentEntity user = parentService.selectById(id);
    return R.ok().put("data", user);
  }

  /**
   * 密码重置
   */
  @IgnoreAuth
  @RequestMapping(value = "/resetPass")
  public R resetPass(String username, HttpServletRequest request) {
    ParentEntity user = parentService.selectOne(
        new EntityWrapper<ParentEntity>().eq("username", username));
    if (user == null) {
      return R.error("账号不存在");
    }
    user.setPassword("123456");
    parentService.updateById(user);
    return R.ok("密码已重置为：123456");
  }


  /**
   * 后端列表
   */
  @RequestMapping("/page")
  public R page(@RequestParam Map<String, Object> params, ParentEntity parent,
      HttpServletRequest request) {
    EntityWrapper<ParentEntity> ew = new EntityWrapper<ParentEntity>();
    PageUtils page = parentService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, parent), params), params));

    return R.ok().put("data", page);
  }

  /**
   * 前端列表
   */
  @IgnoreAuth
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params, ParentEntity parent,
      HttpServletRequest request) {
    EntityWrapper<ParentEntity> ew = new EntityWrapper<ParentEntity>();
    PageUtils page = parentService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, parent), params), params));
    return R.ok().put("data", page);
  }

  /**
   * 列表
   */
  @RequestMapping("/lists")
  public R list(ParentEntity parent) {
    EntityWrapper<ParentEntity> ew = new EntityWrapper<ParentEntity>();
    ew.allEq(MPUtil.allEQMapPre(parent, "parent"));
    return R.ok().put("data", parentService.selectListView(ew));
  }

  /**
   * 查询
   */
  @RequestMapping("/query")
  public R query(ParentEntity parent) {
    EntityWrapper<ParentEntity> ew = new EntityWrapper<ParentEntity>();
    ew.allEq(MPUtil.allEQMapPre(parent, "parent"));
    ParentView parentView = parentService.selectView(ew);
    return R.ok("查询家长成功").put("data", parentView);
  }

  /**
   * 后端详情
   */
  @RequestMapping("/info/{id}")
  public R info(@PathVariable("id") Long id) {
    ParentEntity parent = parentService.selectById(id);
    return R.ok().put("data", parent);
  }

  /**
   * 前端详情
   */
  @IgnoreAuth
  @RequestMapping("/detail/{id}")
  public R detail(@PathVariable("id") Long id) {
    ParentEntity parent = parentService.selectById(id);
    return R.ok().put("data", parent);
  }


  /**
   * 后端保存
   */
  @RequestMapping("/save")
  public R save(@RequestBody ParentEntity parent, HttpServletRequest request) {
    parent.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(parent);
    ParentEntity user = parentService.selectOne(
        new EntityWrapper<ParentEntity>().eq("username", parent.getUsername()));
    if (user != null) {
      return R.error("用户已存在");
    }
    parent.setId(new Date().getTime());
    parentService.insert(parent);
    return R.ok();
  }

  /**
   * 前端保存
   */
  @RequestMapping("/add")
  public R add(@RequestBody ParentEntity parent, HttpServletRequest request) {
    parent.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
    //ValidatorUtils.validateEntity(parent);
    ParentEntity user = parentService.selectOne(
        new EntityWrapper<ParentEntity>().eq("username", parent.getUsername()));
    if (user != null) {
      return R.error("用户已存在");
    }
    parent.setId(new Date().getTime());
    parentService.insert(parent);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  public R update(@RequestBody ParentEntity parent, HttpServletRequest request) {
    //ValidatorUtils.validateEntity(parent);
    parentService.updateById(parent);//全部更新
    return R.ok();
  }


  /**
   * 删除
   */
  @RequestMapping("/delete")
  public R delete(@RequestBody Long[] ids) {
    parentService.deleteBatchIds(Arrays.asList(ids));
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

    Wrapper<ParentEntity> wrapper = new EntityWrapper<ParentEntity>();
    if (map.get("remindstart") != null) {
      wrapper.ge(columnName, map.get("remindstart"));
    }
    if (map.get("remindend") != null) {
      wrapper.le(columnName, map.get("remindend"));
    }

    int count = parentService.selectCount(wrapper);
    return R.ok().put("count", count);
  }


}
