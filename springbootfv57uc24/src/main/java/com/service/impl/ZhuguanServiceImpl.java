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


import com.dao.ZhuguanDao;
import com.entity.ZhuguanEntity;
import com.service.ZhuguanService;
import com.entity.vo.ZhuguanVO;
import com.entity.view.ZhuguanView;

@Service("zhuguanService")
public class ZhuguanServiceImpl extends ServiceImpl<ZhuguanDao, ZhuguanEntity> implements ZhuguanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuguanEntity> page = this.selectPage(
                new Query<ZhuguanEntity>(params).getPage(),
                new EntityWrapper<ZhuguanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuguanEntity> wrapper) {
		  Page<ZhuguanView> page =new Query<ZhuguanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuguanVO> selectListVO(Wrapper<ZhuguanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuguanVO selectVO(Wrapper<ZhuguanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuguanView> selectListView(Wrapper<ZhuguanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuguanView selectView(Wrapper<ZhuguanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
