package com.github.yjj.service;

import java.util.List;

import com.github.yjj.dto.Order;

public interface OrderService {

	public Order get(String id);

	public List<Order> getAll();

	public void doSave(Order order);

	public void doRemove(String id);

}