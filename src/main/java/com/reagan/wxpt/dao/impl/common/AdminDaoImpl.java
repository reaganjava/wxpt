package com.reagan.wxpt.dao.impl.common;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.IBaseDao;
import com.reagan.core.util.ObjectParams;
import com.reagan.core.util.QueryMapper;
import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.pojo.common.CommonAdmin;

@Repository
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
		System.out.println(args.length);
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
		QueryMapper mapper = whereMapper(admin, DELETE_ADMIN);
		return baseDao.executeReturn(mapper.toQueryString(), mapper.toQueryArgs());
	}

	@Override
	public CommonAdmin queryAdmin(CommonAdmin admin) {
		QueryMapper mapper = whereMapper(admin, DELETE_ADMIN);
		return baseDao.queryForObject(mapper.toQueryString(), mapper.toQueryArgs(), new AdminMapper());
	}

	@Override
	public List<CommonAdmin> queryAdminForList(CommonAdmin admin) {
		QueryMapper mapper = whereMapper(admin, DELETE_ADMIN);
		return baseDao.queryForList(mapper.toQueryString(), mapper.toQueryArgs(), new AdminMapper());
	}

	@Override
	public PageBean<CommonAdmin> queryAdminForList(CommonAdmin admin, int pageON,
			int pageCount) {
		QueryMapper mapper = whereMapper(admin, QUERY_ADMIN);
		PageBean<CommonAdmin> pageBean = new PageBean<CommonAdmin>();
		pageBean.setCurrentPage(pageON);
		if(pageON > 0) {
			pageON = pageON - 1;
		}
		long count = (long) baseDao.queryForValue(mapper.toQueryString(new String[]{"count(*)"}), mapper.toQueryArgs(), Long.class);
		//设置开始位置
		int startPage = pageON * pageCount;
		mapper = whereMapper(admin, QUERY_ADMIN, startPage, pageCount);
		List<CommonAdmin> commonAdminList = baseDao.queryForList(mapper.toQueryString(new String[]{"*"}), mapper.toQueryArgs(), new AdminMapper());
		//放入分页容器
		pageBean.setDataList(commonAdminList);
		//设置页大小
		pageBean.setPageSize(pageCount);
		//总记录数
		pageBean.setRecordCount(count);
		return pageBean;
	}
	
	private QueryMapper whereMapper(CommonAdmin admin, String queryString) {
		QueryMapper queryMapper = new QueryMapper(queryString);
		if(admin.getAdmid() != 0) {
			queryMapper.addQueryWhere(WHERE_BY_ID, admin.getAdmid());
		}
		if(admin.getGroupId() != 0) {
			queryMapper.addQueryWhere(WHERE_BY_GROUP_ID, admin.getGroupId());
		}
		if(admin.getCompanyId() != 0) {
			queryMapper.addQueryWhere(WHERE_BY_COMPANY_ID, admin.getCompanyId());
		}
		return queryMapper;
	}
	
	private QueryMapper whereMapper(CommonAdmin admin, String queryString, int pageNO, int pageCount) {
		QueryMapper queryMapper = whereMapper(admin, queryString);
		queryMapper.getQueryBuilder().append(LIMIT);
		queryMapper.getArgs().add(pageNO);
		queryMapper.getArgs().add(pageCount);
		return queryMapper;
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
