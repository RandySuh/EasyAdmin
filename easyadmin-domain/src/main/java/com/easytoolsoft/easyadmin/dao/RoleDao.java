package com.easytoolsoft.easyadmin.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.easytoolsoft.easyadmin.data.jdbc.BaseDao;
import com.easytoolsoft.easyadmin.po.RolePo;

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
