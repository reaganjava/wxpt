package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IAdvertisementDao;
import com.reagan.wxpt.pojo.business.BusinessAdvertisement;

@Repository
public class AdvertisementDaoImpl extends MapperDaoImpl<BusinessAdvertisement>
		implements IAdvertisementDao {

	
	@Override
	public RowMapper<BusinessAdvertisement> getRowMapper(
			ObjectMapperParams<BusinessAdvertisement> objectMapperParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
