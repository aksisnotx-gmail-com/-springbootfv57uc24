package com.entity.model;

import com.entity.RenwufenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 任务分配
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public class RenwufenpeiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 任务简介
	 */
	
	private String renwujianjie;
		
	/**
	 * 任务详情
	 */
	
	private String renwuxiangqing;
		
	/**
	 * 完成日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date wanchengriqi;
		
	/**
	 * 技术部门员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 技术部门员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 部门
	 */
	
	private String bumen;
		
	/**
	 * 技术部门经理工号
	 */
	
	private String zhuguangonghao;
				
	
	/**
	 * 设置：任务简介
	 */
	 
	public void setRenwujianjie(String renwujianjie) {
		this.renwujianjie = renwujianjie;
	}
	
	/**
	 * 获取：任务简介
	 */
	public String getRenwujianjie() {
		return renwujianjie;
	}
				
	
	/**
	 * 设置：任务详情
	 */
	 
	public void setRenwuxiangqing(String renwuxiangqing) {
		this.renwuxiangqing = renwuxiangqing;
	}
	
	/**
	 * 获取：任务详情
	 */
	public String getRenwuxiangqing() {
		return renwuxiangqing;
	}
				
	
	/**
	 * 设置：完成日期
	 */
	 
	public void setWanchengriqi(Date wanchengriqi) {
		this.wanchengriqi = wanchengriqi;
	}
	
	/**
	 * 获取：完成日期
	 */
	public Date getWanchengriqi() {
		return wanchengriqi;
	}
				
	
	/**
	 * 设置：技术部门员工工号
	 */
	 
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	
	/**
	 * 获取：技术部门员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
				
	
	/**
	 * 设置：技术部门员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：技术部门员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
				
	
	/**
	 * 设置：部门
	 */
	 
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	
	/**
	 * 获取：部门
	 */
	public String getBumen() {
		return bumen;
	}
				
	
	/**
	 * 设置：技术部门经理工号
	 */
	 
	public void setZhuguangonghao(String zhuguangonghao) {
		this.zhuguangonghao = zhuguangonghao;
	}
	
	/**
	 * 获取：技术部门经理工号
	 */
	public String getZhuguangonghao() {
		return zhuguangonghao;
	}
			
}
