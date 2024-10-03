package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzuohuibaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongzuohuibaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuohuibaoView;


/**
 * 工作汇报
 *
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public interface GongzuohuibaoService extends IService<GongzuohuibaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuohuibaoVO> selectListVO(Wrapper<GongzuohuibaoEntity> wrapper);
   	
   	GongzuohuibaoVO selectVO(@Param("ew") Wrapper<GongzuohuibaoEntity> wrapper);
   	
   	List<GongzuohuibaoView> selectListView(Wrapper<GongzuohuibaoEntity> wrapper);
   	
   	GongzuohuibaoView selectView(@Param("ew") Wrapper<GongzuohuibaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuohuibaoEntity> wrapper);
   	

}

