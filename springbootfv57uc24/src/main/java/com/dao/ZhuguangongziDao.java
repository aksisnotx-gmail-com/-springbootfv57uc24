package com.dao;

import com.entity.ZhuguangongziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuguangongziVO;
import com.entity.view.ZhuguangongziView;


/**
 * 技术部门经理工资
 * 
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public interface ZhuguangongziDao extends BaseMapper<ZhuguangongziEntity> {
	
	List<ZhuguangongziVO> selectListVO(@Param("ew") Wrapper<ZhuguangongziEntity> wrapper);
	
	ZhuguangongziVO selectVO(@Param("ew") Wrapper<ZhuguangongziEntity> wrapper);
	
	List<ZhuguangongziView> selectListView(@Param("ew") Wrapper<ZhuguangongziEntity> wrapper);

	List<ZhuguangongziView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuguangongziEntity> wrapper);
	
	ZhuguangongziView selectView(@Param("ew") Wrapper<ZhuguangongziEntity> wrapper);
	

}
