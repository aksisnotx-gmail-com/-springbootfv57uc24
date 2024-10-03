package com.entity.vo;

import com.entity.RichenganpaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 日程安排
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public class RichenganpaiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 日程安排
	 */
	
	private String richenganpai;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
		
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
	 * 设置：日程安排
	 */
	 
	public void setRichenganpai(String richenganpai) {
		this.richenganpai = richenganpai;
	}
	
	/**
	 * 获取：日程安排
	 */
	public String getRichenganpai() {
		return richenganpai;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
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
