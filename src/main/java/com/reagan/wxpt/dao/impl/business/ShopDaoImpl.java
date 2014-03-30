package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IShopDao;
import com.reagan.wxpt.pojo.business.BusinessShop;

@Repository
public class ShopDaoImpl extends MapperDaoImpl<BusinessShop>
		implements IShopDao {

	class ShopMapper implements RowMapper<BusinessShop> {
		
		private ObjectMapperParams<BusinessShop> objectMapperParams = null;
		
		public ShopMapper(ObjectMapperParams<BusinessShop> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessShop mapRow(ResultSet rs, int row) throws SQLException {
			BusinessShop object = new BusinessShop();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<BusinessShop> getRowMapper(
			ObjectMapperParams<BusinessShop> objectMapperParams) {
		return new ShopMapper(objectMapperParams);
	}

}
