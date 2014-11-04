package com.github.yjj.convertor;

import java.math.BigDecimal;





import org.springframework.util.StringUtils;

import com.github.yjj.dto.Order;
import com.github.yjj.entity.TOrder;
import com.github.yjj.util.NumberUtil;

public class OrderConverter {

	public static Order toDto(TOrder entity) {
		Order order = new Order();
		order.setAmount(NumberUtil.getIntValue(entity.getAmount()));
		order.setClientName(entity.getClientname());
		order.setCreateTime(entity.getCreatetime());
		order.setId("" + NumberUtil.getIntValue(entity.getId()));
		return order;
	}

	public static TOrder toEntity(Order dto) {
		TOrder entity = new TOrder();
		entity.setAmount(new BigDecimal(dto.getAmount()));
		entity.setClientname(dto.getClientName());
		entity.setCreatetime(dto.getCreateTime());
		if (StringUtils.isEmpty(dto.getId())) {
			entity.setId(null);
		} else {
			entity.setId(new BigDecimal(Integer.parseInt(dto.getId())));
		}
		return entity;

	}
}
