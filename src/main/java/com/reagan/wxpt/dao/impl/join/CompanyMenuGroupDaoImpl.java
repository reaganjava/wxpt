package com.reagan.wxpt.dao.impl.join;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.join.ICompanyMenuGroupDao;
import com.reagan.wxpt.pojo.join.JoinCompanyMenuGroup;

public class CompanyMenuGroupDaoImpl extends MapperDaoImpl<JoinCompanyMenuGroup>
		implements ICompanyMenuGroupDao {

	class CompanyMenuGroupMapper implements RowMapper<JoinCompanyMenuGroup> {
		
		private ObjectMapperParams<JoinCompanyMenuGroup> objectMapperParams = null;
		
		public CompanyMenuGroupMapper(ObjectMapperParams<JoinCompanyMenuGroup> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public JoinCompanyMenuGroup mapRow(ResultSet rs, int row) throws SQLException {
			JoinCompanyMenuGroup object = new JoinCompanyMenuGroup();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}


	@Override
	public RowMapper<JoinCompanyMenuGroup> getRowMapper(
			ObjectMapperParams<JoinCompanyMenuGroup> objectMapperParams) {
		// TODO Auto-generated method stub
		return new CompanyMenuGroupMapper(objectMapperParams);
	}

}
