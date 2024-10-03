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

import com.entity.YuangongEntity;
import com.entity.view.YuangongView;

import com.service.YuangongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 技术部门员工
 * 后端接口
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@RestController
@RequestMapping("/yuangong")
public class YuangongController {
    @Autowired
    private YuangongService yuangongService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", username));
        if(u.getStatus().intValue()==1) {
            return R.error("账号已锁定，请联系管理员。");
        }
		if(u==null || !u.getMima().equals(password)) {
            if(u!=null) {
                u.setPasswordwrongnum(u.getPasswordwrongnum()+1);
                if(u.getPasswordwrongnum()>=3) {
                    u.setStatus(1);
                }
                yuangongService.updateById(u);
            }
			return R.error("账号或密码不正确");
		}
		
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"yuangong",  "技术部门员工" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YuangongEntity yuangong){
    	//ValidatorUtils.validateEntity(yuangong);
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", yuangong.getYuangonggonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		yuangong.setId(uId);
        yuangongService.insert(yuangong);
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
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        YuangongEntity u = yuangongService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        yuangongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongEntity yuangong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhuguan")) {
			yuangong.setZhuguangonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongEntity> ew = new EntityWrapper<YuangongEntity>();

		PageUtils page = yuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongEntity yuangong, 
		HttpServletRequest request){
        EntityWrapper<YuangongEntity> ew = new EntityWrapper<YuangongEntity>();

		PageUtils page = yuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongEntity yuangong){
       	EntityWrapper<YuangongEntity> ew = new EntityWrapper<YuangongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangong, "yuangong")); 
        return R.ok().put("data", yuangongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongEntity yuangong){
        EntityWrapper< YuangongEntity> ew = new EntityWrapper< YuangongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangong, "yuangong")); 
		YuangongView yuangongView =  yuangongService.selectView(ew);
		return R.ok("查询技术部门员工成功").put("data", yuangongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongEntity yuangong = yuangongService.selectById(id);
        return R.ok().put("data", yuangong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongEntity yuangong = yuangongService.selectById(id);
        return R.ok().put("data", yuangong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
    	yuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangong);
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", yuangong.getYuangonggonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yuangong.setId(new Date().getTime());
        yuangongService.insert(yuangong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
    	yuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangong);
    	YuangongEntity u = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("yuangonggonghao", yuangong.getYuangonggonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yuangong.setId(new Date().getTime());
        yuangongService.insert(yuangong);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangong);
        yuangongService.updateById(yuangong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuangongEntity> list = new ArrayList<YuangongEntity>();
        for(Long id : ids) {
            YuangongEntity yuangong = yuangongService.selectById(id);
            yuangong.setSfsh(sfsh);
            yuangong.setShhf(shhf);
            list.add(yuangong);
        }
        yuangongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
