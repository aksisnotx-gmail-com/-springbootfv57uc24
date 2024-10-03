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

import com.entity.YuangongqingjiaEntity;
import com.entity.view.YuangongqingjiaView;

import com.service.YuangongqingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 技术部门员工业务申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@RestController
@RequestMapping("/yuangongqingjia")
public class YuangongqingjiaController {
    @Autowired
    private YuangongqingjiaService yuangongqingjiaService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongqingjiaEntity yuangongqingjia,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date qingjiashijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date qingjiashijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangongqingjia.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhuguan")) {
			yuangongqingjia.setZhuguangonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongqingjiaEntity> ew = new EntityWrapper<YuangongqingjiaEntity>();
                if(qingjiashijianstart!=null) ew.ge("qingjiashijian", qingjiashijianstart);
                if(qingjiashijianend!=null) ew.le("qingjiashijian", qingjiashijianend);

		PageUtils page = yuangongqingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongqingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongqingjiaEntity yuangongqingjia, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date qingjiashijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date qingjiashijianend,
		HttpServletRequest request){
        EntityWrapper<YuangongqingjiaEntity> ew = new EntityWrapper<YuangongqingjiaEntity>();
                if(qingjiashijianstart!=null) ew.ge("qingjiashijian", qingjiashijianstart);
                if(qingjiashijianend!=null) ew.le("qingjiashijian", qingjiashijianend);

		PageUtils page = yuangongqingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongqingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongqingjiaEntity yuangongqingjia){
       	EntityWrapper<YuangongqingjiaEntity> ew = new EntityWrapper<YuangongqingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongqingjia, "yuangongqingjia")); 
        return R.ok().put("data", yuangongqingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongqingjiaEntity yuangongqingjia){
        EntityWrapper< YuangongqingjiaEntity> ew = new EntityWrapper< YuangongqingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongqingjia, "yuangongqingjia")); 
		YuangongqingjiaView yuangongqingjiaView =  yuangongqingjiaService.selectView(ew);
		return R.ok("查询技术部门员工业务申请成功").put("data", yuangongqingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongqingjiaEntity yuangongqingjia = yuangongqingjiaService.selectById(id);
        return R.ok().put("data", yuangongqingjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongqingjiaEntity yuangongqingjia = yuangongqingjiaService.selectById(id);
        return R.ok().put("data", yuangongqingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongqingjiaEntity yuangongqingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongqingjiaService.insert(yuangongqingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongqingjiaEntity yuangongqingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongqingjiaService.insert(yuangongqingjia);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangongqingjiaEntity yuangongqingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongqingjiaService.updateById(yuangongqingjia);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuangongqingjiaEntity> list = new ArrayList<YuangongqingjiaEntity>();
        for(Long id : ids) {
            YuangongqingjiaEntity yuangongqingjia = yuangongqingjiaService.selectById(id);
            yuangongqingjia.setSfsh(sfsh);
            yuangongqingjia.setShhf(shhf);
            list.add(yuangongqingjia);
        }
        yuangongqingjiaService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongqingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
