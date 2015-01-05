package org.easyframework.easyadmin.dao;

import javax.annotation.Resource;

import org.easyframework.easyadmin.data.jdbc.BaseDao;
import org.easyframework.easyadmin.po.RolePo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 系统角色表数据访问实现类
 */
@Repository
public class RoleDao extends BaseDao<RolePo> {

	public RoleDao() {
		super(RolePo.EntityName, RolePo.RoleId);
	}

	@Override
	@Resource
	public void setJDBCTemplate(JdbcTemplate membershipJdbcTemplate) {
		this.setJdbcTemplate(membershipJdbcTemplate);
	}
}
