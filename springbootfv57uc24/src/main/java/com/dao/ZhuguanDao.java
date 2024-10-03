package com.dao;

import com.entity.ZhuguanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuguanVO;
import com.entity.view.ZhuguanView;


/**
 * 技术部门经理
 * 
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public interface ZhuguanDao extends BaseMapper<ZhuguanEntity> {
	
	List<ZhuguanVO> selectListVO(@Param("ew") Wrapper<ZhuguanEntity> wrapper);
	
	ZhuguanVO selectVO(@Param("ew") Wrapper<ZhuguanEntity> wrapper);
	
	List<ZhuguanView> selectListView(@Param("ew") Wrapper<ZhuguanEntity> wrapper);

	List<ZhuguanView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuguanEntity> wrapper);
	
	ZhuguanView selectView(@Param("ew") Wrapper<ZhuguanEntity> wrapper);
	

}
