package com.entity.view;

import com.entity.ZhuguanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;


/**
 * 技术部门经理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2024-9-11 20:16:26
 */
@TableName("zhuguan")
public class ZhuguanView  extends ZhuguanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhuguanView(){
	}

 	public ZhuguanView(ZhuguanEntity zhuguanEntity){
 	try {
			BeanUtils.copyProperties(this, zhuguanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
