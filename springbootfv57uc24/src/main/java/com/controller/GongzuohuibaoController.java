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

import com.entity.GongzuohuibaoEntity;
import com.entity.view.GongzuohuibaoView;

import com.service.GongzuohuibaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 工作汇报
 * 后端接口
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@RestController
@RequestMapping("/gongzuohuibao")
public class GongzuohuibaoController {
    @Autowired
    private GongzuohuibaoService gongzuohuibaoService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzuohuibaoEntity gongzuohuibao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhuguan")) {
			gongzuohuibao.setZhuguangonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yuangong")) {
			gongzuohuibao.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzuohuibaoEntity> ew = new EntityWrapper<GongzuohuibaoEntity>();

		PageUtils page = gongzuohuibaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuohuibao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzuohuibaoEntity gongzuohuibao, 
		HttpServletRequest request){
        EntityWrapper<GongzuohuibaoEntity> ew = new EntityWrapper<GongzuohuibaoEntity>();

		PageUtils page = gongzuohuibaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuohuibao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzuohuibaoEntity gongzuohuibao){
       	EntityWrapper<GongzuohuibaoEntity> ew = new EntityWrapper<GongzuohuibaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzuohuibao, "gongzuohuibao")); 
        return R.ok().put("data", gongzuohuibaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzuohuibaoEntity gongzuohuibao){
        EntityWrapper< GongzuohuibaoEntity> ew = new EntityWrapper< GongzuohuibaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzuohuibao, "gongzuohuibao")); 
		GongzuohuibaoView gongzuohuibaoView =  gongzuohuibaoService.selectView(ew);
		return R.ok("查询工作汇报成功").put("data", gongzuohuibaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzuohuibaoEntity gongzuohuibao = gongzuohuibaoService.selectById(id);
        return R.ok().put("data", gongzuohuibao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzuohuibaoEntity gongzuohuibao = gongzuohuibaoService.selectById(id);
        return R.ok().put("data", gongzuohuibao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuohuibaoEntity gongzuohuibao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongzuohuibao);
        gongzuohuibaoService.insert(gongzuohuibao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuohuibaoEntity gongzuohuibao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongzuohuibao);
        gongzuohuibaoService.insert(gongzuohuibao);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongzuohuibaoEntity gongzuohuibao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzuohuibao);
        gongzuohuibaoService.updateById(gongzuohuibao);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<GongzuohuibaoEntity> list = new ArrayList<GongzuohuibaoEntity>();
        for(Long id : ids) {
            GongzuohuibaoEntity gongzuohuibao = gongzuohuibaoService.selectById(id);
            gongzuohuibao.setSfsh(sfsh);
            gongzuohuibao.setShhf(shhf);
            list.add(gongzuohuibao);
        }
        gongzuohuibaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzuohuibaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
