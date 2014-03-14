package com.reagan.wxpt.dao.impl.common;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.IBaseDao;
import com.reagan.core.util.ObjectParams;
import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.pojo.common.CommonAdmin;

public class AdminDaoImpl implements IAdminDao {
	
	public final String INSERT_ADMIN = "INSERT INTO COMMON_ADMIN"
									+ " (GROUP_ID,COMPANY_ID,USERNAME,PASSWORD,REALNAME,CREATEDATE,CREATENAME,STATUS)"
									+ " VALUES (?,?,?,?,?,?,?,?)";
	
	public final String UPDATE_ADMIN_PASSWORD = "UPDATE COMMON_ADMIN SET PASSWORD = ? WHERE ADMID = ?";
	
	public final String UPDATE_ADMIN_STATUS = "UPDATE COMMON_ADMIN SET STATUS = ? WHERE ADMID = ?";
	
	public final String DELETE_ADMIN = "DELETE FROM COMMON_ADMIN ";
	
	public final String QUERY_ADMIN = "SELECT {0} FROM COMMON_ADMIN WHERE 1=1 ";
	
	public final String WHERE_BY_USERNAME_PASSWORD = "AND USERNAME = ? AND PASSWORD = ? ";
	
	public final String WHERE_BY_ID = "AND ADMID = ? ";
	
	public final String WHERE_BY_GROUP_ID = "AND GROUP_ID = ? ";
	
	public final String WHERE_BY_COMPANY_ID = "AND COMPANY_ID = ? ";
	
	public final String WHERE_BY_STATUS = "AND STATUS = ? ";
	
	public final String WHERE_BY_CREATEDATE = "AND CREATEDATE > ? AND CREATEDATE < ?";
	
	public final String LIKE_BY_CREATENAME = "AND CREATENAME LIKE ?";
	
	public final String LIKE_BY_USERNAME = "AND USERNAME LIKE ? ";
	
	public final String LIKE_BY_REALNAME = "AND REALNAME LIKE ? ";
	
	public final String LIMIT = " LIMIT ?, ?";
	
	@Autowired
	private IBaseDao<CommonAdmin> baseDao;

	@Override
	public void saveAdmin(CommonAdmin admin) {
		ObjectParams<CommonAdmin> objectParams = new ObjectParams<CommonAdmin>();
		Object[] args = objectParams.objectArrayFactory(admin, new String[]{"admid"});
		baseDao.execute(INSERT_ADMIN, args);
	}

	@Override
	public int updateForPassword(String password, int admid) {
		Object[] args = new Object[2];
		args[0] = password;
		args[1] = admid;
		baseDao.executeReturn(UPDATE_ADMIN_PASSWORD, args);
		return 0;
	}
	
	public int updateForStatus(int status, int admid) {
		Object[] args = new Object[2];
		args[0] = status;
		args[1] = admid;
		return baseDao.executeReturn(UPDATE_ADMIN_STATUS, args);
	}

	@Override
	public int deleteAdmin(CommonAdmin admin) {		
		Map<String, Object> mapper = whereMapper(admin, DELETE_ADMIN);
		return baseDao.executeReturn((String) mapper.get("QUERY"),  ((List<?>)mapper.get("ARGS")).toArray());
	}

	@Override
	public CommonAdmin findAdmin(CommonAdmin admin) {
		Map<String, Object> mapper = whereMapper(admin, DELETE_ADMIN);
		return baseDao.queryForObject((String) mapper.get("QUERY"),  ((List<?>)mapper.get("ARGS")).toArray(), new AdminMapper());
	}

	@Override
	public List<CommonAdmin> findAdminForList(CommonAdmin admin) {
		Map<String, Object> mapper = whereMapper(admin, DELETE_ADMIN);
		return baseDao.queryForList((String) mapper.get("QUERY"),  ((List<?>)mapper.get("ARGS")).toArray(), new AdminMapper());
	}

	@Override
	public PageBean<CommonAdmin> findAdminForList(CommonAdmin admin, int pageON,
			int pageCount) {
		Map<String, Object> mapper = whereMapper(admin, DELETE_ADMIN);
		List<?> args = (List<?>) mapper.get("ARGS");
		PageBean<CommonAdmin> pageBean = new PageBean<CommonAdmin>();
		return null;
	}
	
	private Map<String, Object> whereMapper(CommonAdmin admin, String queryString) {
		Map<String, Object> mapper = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder(queryString);
		List<Object> args = new ArrayList<Object>();
		if(admin.getAdmid() != 0) {
			query.append(WHERE_BY_ID);
			args.add(admin.getAdmid());
		}
		if(admin.getGroupId() != 0) {
			query.append(WHERE_BY_GROUP_ID);
			args.add(admin.getGroupId());
		}
		if(admin.getCompanyId() != 0) {
			query.append(WHERE_BY_COMPANY_ID);
			args.add(admin.getCompanyId());
		}
		if(admin.getCompanyId() != 0) {
			query.append(WHERE_BY_COMPANY_ID);
			args.add(admin.getCompanyId());
		}
		mapper.put("QUERY", query.toString());
		mapper.put("ARGS", args);
		return mapper;
	}
	
	class AdminMapper implements RowMapper<CommonAdmin> {

		@Override
		public CommonAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommonAdmin admin = new CommonAdmin();
			int index = 0;
			try {
				for(Field field : CommonAdmin.class.getDeclaredFields()) {
					BeanUtils.setProperty(admin, field.getName(), rs.getObject(index + 1));
					index++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return admin;
		}
		
	}

}
