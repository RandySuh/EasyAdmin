package org.easyframework.easyadmin.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.lf5.LogLevel;
import org.easyframework.easyadmin.dao.EventDao;
import org.easyframework.easyadmin.data.PageInfo;
import org.easyframework.easyadmin.data.jdbc.BaseService;
import org.easyframework.easyadmin.po.EventPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService extends BaseService<EventDao, EventPo> {
	@Autowired
	public EventService(EventDao dao) {
		super(dao);
	}

	public void append(String source, String message, int userId, String account, LogLevel level) {
		EventPo event = new EventPo();
		event.setSource(source);
		event.setMessage(message);
		event.setUserId(userId);
		event.setAccount(account);
		event.setLevel(level.toString());
		event.setCreateTime(event.getCreateTime());
		event.setUrl("");
		this.add(event);
	}

	public List<EventPo> getEventsByKeyword(PageInfo page, String fieldName, String keyword) {
		String condition = "";
		if (StringUtils.isNotBlank(keyword)) {
			condition = fieldName + " like '%" + keyword + "%' ";
		}
		return this.getDao().query(condition, page);
	}
}