package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IDistributionDao;
import com.reagan.wxpt.pojo.business.BusinessDistribution;

@Repository
public class DistributionDaoImpl extends MapperDaoImpl<BusinessDistribution>
		implements IDistributionDao {

	
	@Override
	public RowMapper<BusinessDistribution> getRowMapper(
			ObjectMapperParams<BusinessDistribution> objectMapperParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
