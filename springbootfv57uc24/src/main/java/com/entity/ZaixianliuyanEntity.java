package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 在线留言
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@TableName("zaixianliuyan")
public class ZaixianliuyanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZaixianliuyanEntity() {
		
	}
	
	public ZaixianliuyanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 留言标题
	 */
					
	private String liuyanbiaoti;
	
	/**
	 * 留言详情
	 */
					
	private String liuyanxiangqing;
	
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
	 * 留言时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date liuyanshijian;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：留言标题
	 */
	public void setLiuyanbiaoti(String liuyanbiaoti) {
		this.liuyanbiaoti = liuyanbiaoti;
	}
	/**
	 * 获取：留言标题
	 */
	public String getLiuyanbiaoti() {
		return liuyanbiaoti;
	}
	/**
	 * 设置：留言详情
	 */
	public void setLiuyanxiangqing(String liuyanxiangqing) {
		this.liuyanxiangqing = liuyanxiangqing;
	}
	/**
	 * 获取：留言详情
	 */
	public String getLiuyanxiangqing() {
		return liuyanxiangqing;
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
	/**
	 * 设置：留言时间
	 */
	public void setLiuyanshijian(Date liuyanshijian) {
		this.liuyanshijian = liuyanshijian;
	}
	/**
	 * 获取：留言时间
	 */
	public Date getLiuyanshijian() {
		return liuyanshijian;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
