package org.easyframework.easyadmin.dao;

import javax.annotation.Resource;

import org.easyframework.easyadmin.data.jdbc.BaseDao;
import org.easyframework.easyadmin.po.EventPo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 用户操作日志表数据访问实现类
 */
@Repository
public class EventDao extends BaseDao<EventPo> {

	public EventDao() {
		super(EventPo.EntityName, EventPo.EventId);
	}

	@Resource
	public void setJDBCTemplate(JdbcTemplate membershipJdbcTemplate) {
		this.setJdbcTemplate(membershipJdbcTemplate);
	}
}
