package com.reagan.wxpt.dao.impl.join;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.join.ICompanyCommandDao;
import com.reagan.wxpt.pojo.join.JoinCompanyCommand;

@Repository
public class CompanyCommandDaoImpl extends MapperDaoImpl<JoinCompanyCommand>
		implements ICompanyCommandDao {

	class CompanyCommandMapper implements RowMapper<JoinCompanyCommand> {
		
		private ObjectMapperParams<JoinCompanyCommand> objectMapperParams = null;
		
		public CompanyCommandMapper(ObjectMapperParams<JoinCompanyCommand> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public JoinCompanyCommand mapRow(ResultSet rs, int row) throws SQLException {
			JoinCompanyCommand object = new JoinCompanyCommand();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}


	@Override
	public RowMapper<JoinCompanyCommand> getRowMapper(
			ObjectMapperParams<JoinCompanyCommand> objectMapperParams) {
		// TODO Auto-generated method stub
		return new CompanyCommandMapper(objectMapperParams);
	}

}
