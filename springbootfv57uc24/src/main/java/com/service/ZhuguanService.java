package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuguanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuguanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuguanView;


/**
 * 技术部门经理
 *
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public interface ZhuguanService extends IService<ZhuguanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuguanVO> selectListVO(Wrapper<ZhuguanEntity> wrapper);
   	
   	ZhuguanVO selectVO(@Param("ew") Wrapper<ZhuguanEntity> wrapper);
   	
   	List<ZhuguanView> selectListView(Wrapper<ZhuguanEntity> wrapper);
   	
   	ZhuguanView selectView(@Param("ew") Wrapper<ZhuguanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuguanEntity> wrapper);
   	

}

