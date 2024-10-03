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
 * 技术部门经理工资
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@TableName("zhuguangongzi")
public class ZhuguangongziEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhuguangongziEntity() {
		
	}
	
	public ZhuguangongziEntity(T t) {
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
	 * 工资月份
	 */
					
	private String gongziyuefen;
	
	/**
	 * 技术部门经理工号
	 */
					
	private String zhuguangonghao;
	
	/**
	 * 技术部门经理姓名
	 */
					
	private String zhuguanxingming;
	
	/**
	 * 部门
	 */
					
	private String bumen;
	
	/**
	 * 基本工资
	 */
					
	private Integer jibengongzi;
	
	/**
	 * 绩效工资
	 */
					
	private Double jixiaogongzi;
	
	/**
	 * 加班工资
	 */
					
	private Double jiabangongzi;
	
	/**
	 * 个税
	 */
					
	private Double geshui;
	
	/**
	 * 社保代缴
	 */
					
	private Double shebaodaijiao;
	
	/**
	 * 奖励
	 */
					
	private Integer jiangli;
	
	/**
	 * 罚款
	 */
					
	private Integer fakuan;
	
	/**
	 * 奖惩说明
	 */
					
	private String jiangchengshuoming;
	
	/**
	 * 实发工资
	 */
					
	private Double shifagongzi;
	
	/**
	 * 录入时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date lurushijian;
	
	
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
	 * 设置：工资月份
	 */
	public void setGongziyuefen(String gongziyuefen) {
		this.gongziyuefen = gongziyuefen;
	}
	/**
	 * 获取：工资月份
	 */
	public String getGongziyuefen() {
		return gongziyuefen;
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
	 * 设置：技术部门经理姓名
	 */
	public void setZhuguanxingming(String zhuguanxingming) {
		this.zhuguanxingming = zhuguanxingming;
	}
	/**
	 * 获取：技术部门经理姓名
	 */
	public String getZhuguanxingming() {
		return zhuguanxingming;
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
	 * 设置：基本工资
	 */
	public void setJibengongzi(Integer jibengongzi) {
		this.jibengongzi = jibengongzi;
	}
	/**
	 * 获取：基本工资
	 */
	public Integer getJibengongzi() {
		return jibengongzi;
	}
	/**
	 * 设置：绩效工资
	 */
	public void setJixiaogongzi(Double jixiaogongzi) {
		this.jixiaogongzi = jixiaogongzi;
	}
	/**
	 * 获取：绩效工资
	 */
	public Double getJixiaogongzi() {
		return jixiaogongzi;
	}
	/**
	 * 设置：加班工资
	 */
	public void setJiabangongzi(Double jiabangongzi) {
		this.jiabangongzi = jiabangongzi;
	}
	/**
	 * 获取：加班工资
	 */
	public Double getJiabangongzi() {
		return jiabangongzi;
	}
	/**
	 * 设置：个税
	 */
	public void setGeshui(Double geshui) {
		this.geshui = geshui;
	}
	/**
	 * 获取：个税
	 */
	public Double getGeshui() {
		return geshui;
	}
	/**
	 * 设置：社保代缴
	 */
	public void setShebaodaijiao(Double shebaodaijiao) {
		this.shebaodaijiao = shebaodaijiao;
	}
	/**
	 * 获取：社保代缴
	 */
	public Double getShebaodaijiao() {
		return shebaodaijiao;
	}
	/**
	 * 设置：奖励
	 */
	public void setJiangli(Integer jiangli) {
		this.jiangli = jiangli;
	}
	/**
	 * 获取：奖励
	 */
	public Integer getJiangli() {
		return jiangli;
	}
	/**
	 * 设置：罚款
	 */
	public void setFakuan(Integer fakuan) {
		this.fakuan = fakuan;
	}
	/**
	 * 获取：罚款
	 */
	public Integer getFakuan() {
		return fakuan;
	}
	/**
	 * 设置：奖惩说明
	 */
	public void setJiangchengshuoming(String jiangchengshuoming) {
		this.jiangchengshuoming = jiangchengshuoming;
	}
	/**
	 * 获取：奖惩说明
	 */
	public String getJiangchengshuoming() {
		return jiangchengshuoming;
	}
	/**
	 * 设置：实发工资
	 */
	public void setShifagongzi(Double shifagongzi) {
		this.shifagongzi = shifagongzi;
	}
	/**
	 * 获取：实发工资
	 */
	public Double getShifagongzi() {
		return shifagongzi;
	}
	/**
	 * 设置：录入时间
	 */
	public void setLurushijian(Date lurushijian) {
		this.lurushijian = lurushijian;
	}
	/**
	 * 获取：录入时间
	 */
	public Date getLurushijian() {
		return lurushijian;
	}

}
