package com.entity.model;

import com.entity.GongzuohuibaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 工作汇报
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public class GongzuohuibaoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 工作进度
	 */
	
	private String gongzuojindu;
		
	/**
	 * 工作文件
	 */
	
	private String gongzuowenjian;
		
	/**
	 * 汇报详情
	 */
	
	private String huibaoxiangqing;
		
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
	 * 汇报时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date huibaoshijian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：工作进度
	 */
	 
	public void setGongzuojindu(String gongzuojindu) {
		this.gongzuojindu = gongzuojindu;
	}
	
	/**
	 * 获取：工作进度
	 */
	public String getGongzuojindu() {
		return gongzuojindu;
	}
				
	
	/**
	 * 设置：工作文件
	 */
	 
	public void setGongzuowenjian(String gongzuowenjian) {
		this.gongzuowenjian = gongzuowenjian;
	}
	
	/**
	 * 获取：工作文件
	 */
	public String getGongzuowenjian() {
		return gongzuowenjian;
	}
				
	
	/**
	 * 设置：汇报详情
	 */
	 
	public void setHuibaoxiangqing(String huibaoxiangqing) {
		this.huibaoxiangqing = huibaoxiangqing;
	}
	
	/**
	 * 获取：汇报详情
	 */
	public String getHuibaoxiangqing() {
		return huibaoxiangqing;
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
	 * 设置：汇报时间
	 */
	 
	public void setHuibaoshijian(Date huibaoshijian) {
		this.huibaoshijian = huibaoshijian;
	}
	
	/**
	 * 获取：汇报时间
	 */
	public Date getHuibaoshijian() {
		return huibaoshijian;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
