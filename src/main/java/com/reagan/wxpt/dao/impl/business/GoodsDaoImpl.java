package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IGoodsDao;
import com.reagan.wxpt.pojo.business.BusinessGoods;

@Repository
public class GoodsDaoImpl extends MapperDaoImpl<BusinessGoods>
		implements IGoodsDao {

	class GoodsMapper implements RowMapper<BusinessGoods> {
		
		private ObjectMapperParams<BusinessGoods> objectMapperParams = null;
		
		public GoodsMapper(ObjectMapperParams<BusinessGoods> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessGoods mapRow(ResultSet rs, int row) throws SQLException {
			BusinessGoods object = new BusinessGoods();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<BusinessGoods> getRowMapper(
			ObjectMapperParams<BusinessGoods> objectMapperParams) {
		return new GoodsMapper(objectMapperParams);
	}

}
