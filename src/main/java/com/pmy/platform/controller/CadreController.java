package com.pmy.platform.controller;

import com.pmy.platform.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.pmy.platform.entity.CadreEntity;
import com.pmy.platform.entity.view.CadreView;
import com.pmy.platform.service.CadreService;
import com.pmy.platform.utils.MPUtil;
import com.pmy.platform.utils.PageUtils;
import com.pmy.platform.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 班干部
 * 后端接口
 *
 * @author
 * @email
 * @date 2022-03-01 10:57:52
 */
@RestController
@RequestMapping("/cadre")
public class CadreController {
    @Autowired
    private CadreService cadreService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CadreEntity cadreEntity,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("teacher")) {
            cadreEntity.setTeacherUsername((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<CadreEntity> ew = new EntityWrapper<CadreEntity>();
        PageUtils page = cadreService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cadreEntity), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, CadreEntity cadreEntity,
                  HttpServletRequest request) {
        EntityWrapper<CadreEntity> ew = new EntityWrapper<CadreEntity>();
        PageUtils page = cadreService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cadreEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(CadreEntity cadreEntity) {
        EntityWrapper<CadreEntity> ew = new EntityWrapper<CadreEntity>();
        ew.allEq(MPUtil.allEQMapPre(cadreEntity, "cadreEntity"));
        return R.ok().put("data", cadreService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CadreEntity cadreEntity) {
        EntityWrapper<CadreEntity> ew = new EntityWrapper<CadreEntity>();
        ew.allEq(MPUtil.allEQMapPre(cadreEntity, "cadreEntity"));
        CadreView cadreView = cadreService.selectView(ew);
        return R.ok("查询班干部成功").put("data", cadreView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        CadreEntity cadreEntity = cadreService.selectById(id);
        return R.ok().put("data", cadreEntity);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        CadreEntity cadreEntity = cadreService.selectById(id);
        return R.ok().put("data", cadreEntity);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CadreEntity cadreEntity, HttpServletRequest request) {
        cadreEntity.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(cadreEntity);
        cadreService.insert(cadreEntity);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CadreEntity cadreEntity, HttpServletRequest request) {
        cadreEntity.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(cadreEntity);
        cadreService.insert(cadreEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CadreEntity cadreEntity, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(cadreEntity);
        cadreService.updateById(cadreEntity);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        cadreService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<CadreEntity> wrapper = new EntityWrapper<CadreEntity>();
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

        int count = cadreService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


}
