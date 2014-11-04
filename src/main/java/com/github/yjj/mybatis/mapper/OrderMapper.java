package com.github.yjj.mybatis.mapper;

import java.util.List;

import com.github.yjj.entity.TOrder;

public interface OrderMapper {

	void insertOrder(TOrder entity);

	List<TOrder> getAllOrder();

	TOrder getOrder(int id);

	void deleteOrder(int id);
}
