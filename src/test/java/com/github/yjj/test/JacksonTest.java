package com.github.yjj.test;

import org.junit.Test;

import com.github.yjj.dto.Order;
import com.github.yjj.dto.OrderList;
import com.github.yjj.handler.JacksonFactory;
import com.github.yjj.handler.XStreamFactory;
import com.thoughtworks.xstream.XStream;

public class JacksonTest {

	@Test
	public void testPerson1() {

		Person p1 = new Person();
		p1.setName("aaa");
		System.out.println(p1); // aaa
		System.out.println();

		changePerson1(p1);// xxx
		System.out.println(p1);// xxx

	}
	
	void changePerson1(Person p) {
		p.setName("xxx");
		System.out.println(p);
		System.out.println();
	}

	@Test
	public void testPerson2() throws InstantiationException,
			IllegalAccessException {

		Person p1 = new Person();
		p1.setName("aaa");
		System.out.println(p1); // aaa
		System.out.println();

		changePerson2(p1);// yyy
		System.out.println(p1);// xxx
	}



	void changePerson2(Person p) throws InstantiationException,
			IllegalAccessException {
		Person newPerson = Person.class.newInstance();
		newPerson.setName("yyy");

		p = newPerson;

		System.out.println(p);
		System.out.println();
	}

	@Test
	public void testJson() {
		String test = "{\"id\":\"3\",\"clientName\":\"Bob\",\"amount\":33,\"createTime\":\"1413947088717\"}";
		Order order = new Order();

		System.out.println(order);
		System.out.println(order.hashCode());

		System.out.println("----");

		toObjectJson(test, order);

		System.out.println("----");

		System.out.println(order);
		System.out.println(order.hashCode());
	}

	public void toObjectJson(String in, Object target) {
		try {
			target = JacksonFactory.getObjectMapper().readValue(in,
					target.getClass());
			System.out.println(target);
			System.out.println(target.hashCode());

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testXml() {
		String test = "<order><id>3</id><clientName>Bob</clientName><amount>33</amount><createTime>2014-10-21 09:06:56.241 UTC</createTime></order>";
		Order order = new Order();

		System.out.println(order);
		System.out.println(order.hashCode());

		System.out.println("----");

		toObjectXml(test, order);

		System.out.println("----");

		System.out.println(order);
		System.out.println(order.hashCode());

	}

	public void toObjectXml(String in, Object target) {
		XStream xstream = XStreamFactory.getInstance();

		xstream.alias("data", OrderList.class);
		xstream.alias("order", Order.class);
		xstream.processAnnotations(target.getClass());

		target = xstream.fromXML(in, target);

		System.out.println(target);
		System.out.println(target.hashCode());
	}

}
