package com.entity.view;

import com.entity.ZaixianliuyanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 在线留言
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
@TableName("zaixianliuyan")
public class ZaixianliuyanView  extends ZaixianliuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianliuyanView(){
	}
 
 	public ZaixianliuyanView(ZaixianliuyanEntity zaixianliuyanEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianliuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
