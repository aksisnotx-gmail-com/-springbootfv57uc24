package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuguangongziEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuguangongziVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuguangongziView;


/**
 * 技术部门经理工资
 *
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public interface ZhuguangongziService extends IService<ZhuguangongziEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuguangongziVO> selectListVO(Wrapper<ZhuguangongziEntity> wrapper);
   	
   	ZhuguangongziVO selectVO(@Param("ew") Wrapper<ZhuguangongziEntity> wrapper);
   	
   	List<ZhuguangongziView> selectListView(Wrapper<ZhuguangongziEntity> wrapper);
   	
   	ZhuguangongziView selectView(@Param("ew") Wrapper<ZhuguangongziEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuguangongziEntity> wrapper);
   	

}

