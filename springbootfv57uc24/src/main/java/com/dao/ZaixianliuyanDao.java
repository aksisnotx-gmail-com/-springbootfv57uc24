package com.dao;

import com.entity.ZaixianliuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianliuyanVO;
import com.entity.view.ZaixianliuyanView;


/**
 * 在线留言
 * 
 * @author 
 * @email 
 * @date 2024-9-11 20:16:26
 */
public interface ZaixianliuyanDao extends BaseMapper<ZaixianliuyanEntity> {
	
	List<ZaixianliuyanVO> selectListVO(@Param("ew") Wrapper<ZaixianliuyanEntity> wrapper);
	
	ZaixianliuyanVO selectVO(@Param("ew") Wrapper<ZaixianliuyanEntity> wrapper);
	
	List<ZaixianliuyanView> selectListView(@Param("ew") Wrapper<ZaixianliuyanEntity> wrapper);

	List<ZaixianliuyanView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianliuyanEntity> wrapper);
	
	ZaixianliuyanView selectView(@Param("ew") Wrapper<ZaixianliuyanEntity> wrapper);
	

}
