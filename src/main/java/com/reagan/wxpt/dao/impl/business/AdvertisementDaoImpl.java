package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IAdvertisementDao;
import com.reagan.wxpt.pojo.business.BusinessAdvertisement;

@Repository
public class AdvertisementDaoImpl extends MapperDaoImpl<BusinessAdvertisement>
		implements IAdvertisementDao {

	class AdvertisementMapper implements RowMapper<BusinessAdvertisement> {
		
		private ObjectMapperParams<BusinessAdvertisement> objectMapperParams = null;
		
		public AdvertisementMapper(ObjectMapperParams<BusinessAdvertisement> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessAdvertisement mapRow(ResultSet rs, int row) throws SQLException {
			BusinessAdvertisement advertisement = new BusinessAdvertisement();
			try {
				return objectMapperParams.resultObjectFactory(advertisement, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<BusinessAdvertisement> getRowMapper(
			ObjectMapperParams<BusinessAdvertisement> objectMapperParams) {
		return new AdvertisementMapper(objectMapperParams);
	}

}
