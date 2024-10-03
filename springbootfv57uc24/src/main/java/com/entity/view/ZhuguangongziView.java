package com.entity.view;

import com.entity.ZhuguangongziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 技术部门经理工资
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@TableName("zhuguangongzi")
public class ZhuguangongziView  extends ZhuguangongziEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhuguangongziView(){
	}
 
 	public ZhuguangongziView(ZhuguangongziEntity zhuguangongziEntity){
 	try {
			BeanUtils.copyProperties(this, zhuguangongziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
