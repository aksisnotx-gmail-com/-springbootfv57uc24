package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhuguangongziEntity;
import com.entity.view.ZhuguangongziView;

import com.service.ZhuguangongziService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 技术部门经理工资
 * 后端接口
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@RestController
@RequestMapping("/zhuguangongzi")
public class ZhuguangongziController {
    @Autowired
    private ZhuguangongziService zhuguangongziService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuguangongziEntity zhuguangongzi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhuguan")) {
			zhuguangongzi.setZhuguangonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhuguangongziEntity> ew = new EntityWrapper<ZhuguangongziEntity>();

		PageUtils page = zhuguangongziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuguangongzi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuguangongziEntity zhuguangongzi, 
		HttpServletRequest request){
        EntityWrapper<ZhuguangongziEntity> ew = new EntityWrapper<ZhuguangongziEntity>();

		PageUtils page = zhuguangongziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuguangongzi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuguangongziEntity zhuguangongzi){
       	EntityWrapper<ZhuguangongziEntity> ew = new EntityWrapper<ZhuguangongziEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuguangongzi, "zhuguangongzi")); 
        return R.ok().put("data", zhuguangongziService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuguangongziEntity zhuguangongzi){
        EntityWrapper< ZhuguangongziEntity> ew = new EntityWrapper< ZhuguangongziEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuguangongzi, "zhuguangongzi")); 
		ZhuguangongziView zhuguangongziView =  zhuguangongziService.selectView(ew);
		return R.ok("查询技术部门经理工资成功").put("data", zhuguangongziView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuguangongziEntity zhuguangongzi = zhuguangongziService.selectById(id);
        return R.ok().put("data", zhuguangongzi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuguangongziEntity zhuguangongzi = zhuguangongziService.selectById(id);
        return R.ok().put("data", zhuguangongzi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuguangongziEntity zhuguangongzi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhuguangongzi);
        zhuguangongziService.insert(zhuguangongzi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuguangongziEntity zhuguangongzi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhuguangongzi);
        zhuguangongziService.insert(zhuguangongzi);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuguangongziEntity zhuguangongzi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuguangongzi);
        zhuguangongziService.updateById(zhuguangongzi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuguangongziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
