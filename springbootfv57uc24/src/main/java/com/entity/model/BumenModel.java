package com.entity.model;

import com.entity.BumenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 部门
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public class BumenModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 技术部门经理工号
	 */
	
	private String zhuguangonghao;
				
	
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
