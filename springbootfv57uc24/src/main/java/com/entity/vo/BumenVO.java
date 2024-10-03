package com.entity.vo;

import com.entity.BumenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 部门
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author
 * @email
 * @date 2024-9-11 20:16:26
 */
public class BumenVO  implements Serializable {
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
