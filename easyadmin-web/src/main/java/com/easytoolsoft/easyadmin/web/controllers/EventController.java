package com.easytoolsoft.easyadmin.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easytoolsoft.easyadmin.common.viewmodel.ParamJsonResult;
import com.easytoolsoft.easyadmin.data.PageInfo;
import com.easytoolsoft.easyadmin.po.EventPo;
import com.easytoolsoft.easyadmin.service.EventService;
import com.easytoolsoft.easyadmin.web.DataTablePageInfo;

@Controller
@RequestMapping(value = "/membership/event")
public class EventController extends AbstractController {
	@Resource
	private EventService eventService;

	@RequestMapping(value = { "", "/", "/index" })
	public String index() {
		return "membership/event";
	}

	@RequestMapping(value = "/getevents")
	@ResponseBody
	public Map<String, Object> getEvents(DataTablePageInfo dtPageInfo, HttpServletRequest request) {
		PageInfo page = dtPageInfo.toPageInfo(request.getParameterMap(), EventPo.CreateTime);
		List<EventPo> list = this.eventService.getByPage(page);
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("draw", dtPageInfo.getDraw());
		modelMap.put("recordsTotal", page.getTotals());
		modelMap.put("recordsFiltered", page.getTotals());
		modelMap.put("data", list);

		return modelMap;
	}

	@RequestMapping(value = "/geteventsbykeyword")
	@ResponseBody
	public Map<String, Object> getEventsByKeyword(DataTablePageInfo dtPageInfo, String fieldName, String keyword, HttpServletRequest request) {
		PageInfo page = dtPageInfo.toPageInfo(request.getParameterMap(), EventPo.CreateTime);
		List<EventPo> list = this.eventService.getEventsByKeyword(page, fieldName, keyword);
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("draw", dtPageInfo.getDraw());
		modelMap.put("recordsTotal", page.getTotals());
		modelMap.put("recordsFiltered", page.getTotals());
		modelMap.put("data", list);
		return modelMap;
	}

	@RequestMapping(value = "/removeById")
	@ResponseBody
	public ParamJsonResult<EventPo> remove(Integer id, HttpServletRequest request) {
		ParamJsonResult<EventPo> result = new ParamJsonResult<EventPo>(false, "删除日志失败！");

		try {
			this.eventService.remove(id);
			this.setSuccessResult(result, "删除日志成功！");
		} catch (Exception ex) {
			this.setExceptionResult(result, ex);
		}

		return result;
	}

	@RequestMapping(value = "/clear")
	@ResponseBody
	public ParamJsonResult<EventPo> clear() {
		ParamJsonResult<EventPo> result = new ParamJsonResult<EventPo>(false, "清空日志失败！");
		try {
			this.eventService.getDao().deleteAll();
			this.setSuccessResult(result, "清空日志成功！");
		} catch (Exception ex) {
			this.setExceptionResult(result, ex);
		}
		return result;
	}
}