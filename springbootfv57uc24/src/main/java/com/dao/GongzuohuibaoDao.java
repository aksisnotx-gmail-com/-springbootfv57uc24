package com.dao;

import com.entity.GongzuohuibaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzuohuibaoVO;
import com.entity.view.GongzuohuibaoView;


/**
 * 工作汇报
 * 
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public interface GongzuohuibaoDao extends BaseMapper<GongzuohuibaoEntity> {
	
	List<GongzuohuibaoVO> selectListVO(@Param("ew") Wrapper<GongzuohuibaoEntity> wrapper);
	
	GongzuohuibaoVO selectVO(@Param("ew") Wrapper<GongzuohuibaoEntity> wrapper);
	
	List<GongzuohuibaoView> selectListView(@Param("ew") Wrapper<GongzuohuibaoEntity> wrapper);

	List<GongzuohuibaoView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuohuibaoEntity> wrapper);
	
	GongzuohuibaoView selectView(@Param("ew") Wrapper<GongzuohuibaoEntity> wrapper);
	

}
