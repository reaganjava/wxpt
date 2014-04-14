package com.reagan.wxpt.dao.impl.join;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.join.IShopMenuGroupDao;
import com.reagan.wxpt.pojo.join.JoinShopMenuGroup;

@Repository
public class ShopMenuGroupDaoImpl extends MapperDaoImpl<JoinShopMenuGroup>
		implements IShopMenuGroupDao {

	class CompanyMenuGroupMapper implements RowMapper<JoinShopMenuGroup> {
		
		private ObjectMapperParams<JoinShopMenuGroup> objectMapperParams = null;
		
		public CompanyMenuGroupMapper(ObjectMapperParams<JoinShopMenuGroup> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public JoinShopMenuGroup mapRow(ResultSet rs, int row) throws SQLException {
			JoinShopMenuGroup object = new JoinShopMenuGroup();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}


	@Override
	public RowMapper<JoinShopMenuGroup> getRowMapper(
			ObjectMapperParams<JoinShopMenuGroup> objectMapperParams) {
		// TODO Auto-generated method stub
		return new CompanyMenuGroupMapper(objectMapperParams);
	}

}
