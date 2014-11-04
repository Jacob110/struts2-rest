package com.github.yjj.service.support;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.yjj.convertor.OrderConverter;
import com.github.yjj.dao.BaseDAO;
import com.github.yjj.dto.Order;
import com.github.yjj.entity.TOrder;
import com.github.yjj.mybatis.mapper.OrderMapper;
import com.github.yjj.service.OrderService;

@Service
public class OrdersServiceImpl extends BaseServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;

	@Resource
	BaseDAO<TOrder> tOrderDAO;

	private static final long serialVersionUID = 1513133416493770048L;

	@Override
	public Order get(String id) {
		// hibernate实现
		// return OrderConverter.toDto((TOrder) getCurrentSession().get(
		// TOrder.class, new BigDecimal(Integer.parseInt(id))));
		return OrderConverter.toDto(tOrderDAO.get(TOrder.class, new BigDecimal(
				Integer.parseInt(id))));

		// mybatis实现
		// return
		// OrderConverter.toDto(orderMapper.getOrder(Integer.parseInt(id)));
	}

	@Override
	public List<Order> getAll() {
		List<TOrder> entities = orderMapper.getAllOrder();
		List<Order> orders = new ArrayList<Order>();
		for (TOrder entity : entities) {
			orders.add(OrderConverter.toDto(entity));
		}
		return orders;
	}

	@Override
	public void doSave(Order order) {
		// hibernate
		TOrder entity = OrderConverter.toEntity(order);
		if (entity.getId() != null) {
			entity = (TOrder) getCurrentSession().get(TOrder.class,
					entity.getId());

			// update fields
			entity.setClientname(order.getClientName());
			entity.setAmount(new BigDecimal(order.getAmount()));
		}
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void doRemove(String id) {
		// mybatis
		orderMapper.deleteOrder(Integer.parseInt(id));

	}

}
