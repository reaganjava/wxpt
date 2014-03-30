package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IDistributionDao;
import com.reagan.wxpt.pojo.business.BusinessDistribution;

@Repository
public class DistributionDaoImpl extends MapperDaoImpl<BusinessDistribution>
		implements IDistributionDao {
	
	class DistributionMapper implements RowMapper<BusinessDistribution> {
		
		private ObjectMapperParams<BusinessDistribution> objectMapperParams = null;
		
		public DistributionMapper(ObjectMapperParams<BusinessDistribution> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessDistribution mapRow(ResultSet rs, int row) throws SQLException {
			BusinessDistribution object = new BusinessDistribution();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<BusinessDistribution> getRowMapper(
			ObjectMapperParams<BusinessDistribution> objectMapperParams) {
		return new DistributionMapper(objectMapperParams);
	}

}
