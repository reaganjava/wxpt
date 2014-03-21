package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.IBaseDao;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectParams;
import com.reagan.core.util.QueryMapper;
import com.reagan.util.ValidatorUtil;
import com.reagan.views.dto.PageBean;
import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.vo.common.AdminVO;

@Repository
public class AdminDaoImpl implements IAdminDao {
	
	public final String UPDATE_ADMIN_PASSWORD = "UPDATE COMMON_ADMIN SET PASSWORD = ? WHERE ADMID = ?";
	
	public final String UPDATE_ADMIN_STATUS = "UPDATE COMMON_ADMIN SET STATUS = ? WHERE ADMID = ?";
	
	public final String DELETE_ADMIN = "DELETE FROM COMMON_ADMIN WHERE 1=1 ";
	
	public final String QUERY_ADMIN = "SELECT {0} FROM COMMON_ADMIN WHERE 1=1 ";
	
	public final String WHERE_BY_ID = "AND ADMID = ? ";
	
	public final String WHERE_BY_GROUP_ID = "AND GROUP_ID = ? ";
	
	public final String WHERE_BY_COMPANY_ID = "AND COMPANY_ID = ? ";
	
	public final String WHERE_BY_USERNAME = " AND USERNAME = ? ";
	
	public final String WHERE_BY_PASSWORD = " AND PASSWORD = ? ";
	
	public final String WHERE_BY_STATUS = "AND STATUS = ? ";
	
	public final String WHERE_BY_CREATEDATE_LT = " AND CREATEDATE < ?";

	public final String WHERE_BY_CREATEDATE_GT = " AND CREATEDATE > ?";
	
	public final String WHERE_BY_CREATENAME = "AND CREATENAME = ?";
	
	public final String LIKE_BY_REALNAME = "AND REALNAME LIKE ? ";
	
	public final String LIKE_BY_CREATEDATE = "AND CREATEDATE LIKE ? ";
	
	public final String LIMIT = " LIMIT ?, ?";
	
	@Autowired
	private IBaseDao<CommonAdmin> baseDao;

	@Override
	public void saveAdmin(CommonAdmin admin) {
		ObjectParams<CommonAdmin> objectParams = new ObjectParams<CommonAdmin>();
		try {
			objectParams.objectArrayFactory(admin);
			baseDao.execute(objectParams.getSql(), objectParams.getArgs());
		} catch (MapperException e) {
			e.printStackTrace();
		}
	}
	
	public int updateAdmin(CommonAdmin admin) {
		ObjectParams<CommonAdmin> objectParams = new ObjectParams<CommonAdmin>();
		try {
			objectParams.objectArrayUpdateFactory(admin);
			return baseDao.executeReturn(objectParams.getSql(), objectParams.getArgs());
		} catch (MapperException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteAdmin(AdminVO adminVO) {		
		QueryMapper mapper = whereMapper(adminVO, DELETE_ADMIN);
		return baseDao.executeReturn(mapper.toQueryString(), mapper.toQueryArgs());
	}

	@Override
	public CommonAdmin queryAdmin(AdminVO adminVO) {
		QueryMapper mapper = whereMapper(adminVO, QUERY_ADMIN);
		return baseDao.queryForObject(mapper.toQueryString(new String[]{"*"}), mapper.toQueryArgs(), new AdminMapper());
	}

	@Override
	public List<CommonAdmin> queryAdminForList(AdminVO adminVO) {
		QueryMapper mapper = whereMapper(adminVO, QUERY_ADMIN);
		return baseDao.queryForList(mapper.toQueryString(), mapper.toQueryArgs(), new AdminMapper());
	}

	@Override
	public PageBean<CommonAdmin> queryAdminForPage(AdminVO adminVO) {
		QueryMapper mapper = whereMapper(adminVO, QUERY_ADMIN);
		PageBean<CommonAdmin> pageBean = new PageBean<CommonAdmin>();
		int pageNO = adminVO.getPageNO();
		int pageCount = adminVO.getPageCount();
		pageBean.setCurrentPage(pageNO);
		if(pageNO > 0) {
			pageNO = pageNO - 1;
		}
		long count = (long) baseDao.queryForValue(mapper.toQueryString(new String[]{"count(*)"}), mapper.toQueryArgs(), Long.class);
		//设置开始位置
		int startPage = pageNO * pageCount;
		mapper = whereMapper(adminVO, QUERY_ADMIN, startPage, pageCount);
		List<CommonAdmin> commonAdminList = baseDao.queryForList(mapper.toQueryString(new String[]{"*"}), mapper.toQueryArgs(), new AdminMapper());
		//放入分页容器
		pageBean.setDataList(commonAdminList);
		//设置页大小
		pageBean.setPageSize(pageCount);
		//总记录数
		pageBean.setRecordCount(count);
		return pageBean;
	}
	
	private QueryMapper whereMapper(AdminVO adminVO, String queryString) {
		QueryMapper queryMapper = new QueryMapper(queryString);
		CommonAdmin admin = adminVO.getAdmin();
		if(ValidatorUtil.isNotObjectNull(admin.getAdmid())) {
			queryMapper.addQueryWhere(WHERE_BY_ID, admin.getAdmid());
		}
		if(ValidatorUtil.isNotObjectNull(admin.getGroupId())) {
			queryMapper.addQueryWhere(WHERE_BY_GROUP_ID, admin.getGroupId());
		}
		if(ValidatorUtil.isNotObjectNull(admin.getCompanyId())) {
			queryMapper.addQueryWhere(WHERE_BY_COMPANY_ID, admin.getCompanyId());
		}
		if(ValidatorUtil.isNotEmpty(admin.getUsername())) {
			queryMapper.addQueryWhere(WHERE_BY_USERNAME, admin.getUsername());
		}
		if(ValidatorUtil.isNotEmpty(admin.getPassword())) {
			queryMapper.addQueryWhere(WHERE_BY_PASSWORD, admin.getPassword());
		}
		if(ValidatorUtil.isNotEmpty(admin.getRealname())) {
			queryMapper.addQueryWhere(LIKE_BY_REALNAME, "%" + admin.getRealname() + "%");
		}
		if(ValidatorUtil.isNotObjectNull(admin.getStatus())) {
			queryMapper.addQueryWhere(WHERE_BY_STATUS, admin.getStatus());
		}
		if(ValidatorUtil.isNotEmpty(adminVO.getDate())) {
			queryMapper.addQueryWhere(LIKE_BY_CREATEDATE,  "'%" + adminVO.getDate() + "%'");
		}
		if(ValidatorUtil.isNotEmpty(adminVO.getStartDate())
				&& ValidatorUtil.isNotEmpty(adminVO.getEndDate())) {
			queryMapper.addQueryWhere(WHERE_BY_CREATEDATE_LT,  adminVO.getStartDate());
			queryMapper.addQueryWhere(WHERE_BY_CREATEDATE_GT,  adminVO.getEndDate());
		}
		return queryMapper;
	}
	
	private QueryMapper whereMapper(AdminVO adminVO, String queryString, int pageNO, int pageCount) {
		QueryMapper queryMapper = whereMapper(adminVO, queryString);
		queryMapper.getQueryBuilder().append(LIMIT);
		queryMapper.getArgs().add(pageNO);
		queryMapper.getArgs().add(pageCount);
		return queryMapper;
	}
	
	class AdminMapper implements RowMapper<CommonAdmin> {

		@Override
		public CommonAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommonAdmin admin = new CommonAdmin();
			ObjectParams<CommonAdmin> objectParams = new ObjectParams<CommonAdmin>();
			try {
				return objectParams.resultObjectFactory(admin, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

}
