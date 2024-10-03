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
 * 工作日志
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@TableName("gongzuorizhi")
public class GongzuorizhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongzuorizhiEntity() {
		
	}
	
	public GongzuorizhiEntity(T t) {
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
	 * 日程名称
	 */
					
	private String richengmingcheng;
	
	/**
	 * 工作日志
	 */
					
	private String gongzuorizhi;
	
	/**
	 * 技术部门经理工号
	 */
					
	private String zhuguangonghao;
	
	/**
	 * 技术部门员工工号
	 */
					
	private String yuangonggonghao;
	
	/**
	 * 技术部门员工姓名
	 */
					
	private String yuangongxingming;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	
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
	 * 设置：日程名称
	 */
	public void setRichengmingcheng(String richengmingcheng) {
		this.richengmingcheng = richengmingcheng;
	}
	/**
	 * 获取：日程名称
	 */
	public String getRichengmingcheng() {
		return richengmingcheng;
	}
	/**
	 * 设置：工作日志
	 */
	public void setGongzuorizhi(String gongzuorizhi) {
		this.gongzuorizhi = gongzuorizhi;
	}
	/**
	 * 获取：工作日志
	 */
	public String getGongzuorizhi() {
		return gongzuorizhi;
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
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}

}
