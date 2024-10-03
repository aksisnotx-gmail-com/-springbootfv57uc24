package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhuguangongziDao;
import com.entity.ZhuguangongziEntity;
import com.service.ZhuguangongziService;
import com.entity.vo.ZhuguangongziVO;
import com.entity.view.ZhuguangongziView;

@Service("zhuguangongziService")
public class ZhuguangongziServiceImpl extends ServiceImpl<ZhuguangongziDao, ZhuguangongziEntity> implements ZhuguangongziService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuguangongziEntity> page = this.selectPage(
                new Query<ZhuguangongziEntity>(params).getPage(),
                new EntityWrapper<ZhuguangongziEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuguangongziEntity> wrapper) {
		  Page<ZhuguangongziView> page =new Query<ZhuguangongziView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuguangongziVO> selectListVO(Wrapper<ZhuguangongziEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuguangongziVO selectVO(Wrapper<ZhuguangongziEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuguangongziView> selectListView(Wrapper<ZhuguangongziEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuguangongziView selectView(Wrapper<ZhuguangongziEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
