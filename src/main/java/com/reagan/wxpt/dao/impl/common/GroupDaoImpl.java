package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;




import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.JDBCDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectParams;
import com.reagan.wxpt.dao.common.IGroupDao;
import com.reagan.wxpt.pojo.common.CommonGroup;

public class GroupDaoImpl extends JDBCDaoImpl<CommonGroup> implements IGroupDao {
	
	class GroupMapper implements RowMapper<CommonGroup> {

		@Override
		public CommonGroup mapRow(ResultSet rs, int row) throws SQLException {
			CommonGroup group = new CommonGroup();
			ObjectParams<CommonGroup> objectParams = new ObjectParams<CommonGroup>();
			try {
				return objectParams.resultObjectFactory(group, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonGroup> getRowMapper() {
		return new GroupMapper();
	}



}
