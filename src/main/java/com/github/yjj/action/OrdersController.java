package com.github.yjj.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.yjj.action.base.RestBaseAction;
import com.github.yjj.dto.Order;
import com.github.yjj.dto.OrderList;
import com.github.yjj.service.OrderService;
import com.opensymphony.xwork2.Validateable;

public class OrdersController extends RestBaseAction implements Validateable {

	// /orders
	/*
	 * public String execute() { return "success"; }
	 */

	private static final long serialVersionUID = 552739094829928114L;

	Order model = new Order();
	String id;
	OrderList orders;

	@Autowired
	OrderService ordersService;

	// GET /rest/orders/1
	public HttpHeaders show() {
		if (id != null) {
			// 如果id=x，演示拦截异常处理
			if (id.equals("x")) {
				testException();
			}
			this.model = ordersService.get(id);
		}
		return new DefaultHttpHeaders("show");
	}

	// GET /orders.xhtml
	public HttpHeaders index() {
		if (orders == null) {
			orders = new OrderList();
		}
		orders.setOrders(ordersService.getAll());
		return new DefaultHttpHeaders("index").disableCaching();
	}

	// GET /rest/orders/1/edit
	public String edit() {
		if (id != null) {
			this.model = ordersService.get(id);
		}
		return "edit";
	}

	// GET /rest/orders/new
	public String editNew() {
		model = new Order();
		return "editNew";
	}

	// GET /rest/orders/1/deleteConfirm
	public String deleteConfirm() {
		if (id != null) {
			this.model = ordersService.get(id);
		}
		return "deleteConfirm";
	}

	// DELETE /rest/orders/1
	public HttpHeaders destroy() {
		ordersService.doRemove(id);
		addActionMessage("Order removed successfully");
		return index();		
	}

	// POST /orders
	public HttpHeaders create() throws IOException {
		ordersService.doSave(model);
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String accept = request.getHeader("Accept");
		if (accept.contains("text/html")) { // 页面视图过来的
			response.sendRedirect("orders/");
		} else if (accept.contains("text/xml")) { // 发送xml过来的
			response.sendRedirect("orders/" + model.getId() + ".xml");
		} else { // 其它的返回json视图
			response.sendRedirect("orders/" + model.getId() + ".json");
		}
		return null;
	}

	// PUT /rest/orders/1
	public HttpHeaders update() {
		ordersService.doSave(model);
		addActionMessage("Order updated successfully");		
		return index();
	}

	public void validate() {
		if (model.getClientName() == null
				|| model.getClientName().length() == 0) {
			addFieldError("clientName", "The client name is empty");
		}
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getModel() {
		return (orders != null ? orders : model);
	}

	private void testException() {
		int j = 1 / 0;
		System.out.println(j);
	}

}
