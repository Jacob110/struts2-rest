package com.github.yjj.service.support;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

public class BaseServiceImpl implements Serializable {

	private static final long serialVersionUID = -33988360094493502L;

	/**
	 * hibernate入口
	 */
	@Resource(name = "sessionFactory")
	protected SessionFactory hibernateSessionFactory;

	/**
	 * mybatis入口
	 */
	@Resource(name = "sqlSessionFactory")
	protected SqlSessionFactory mybatisSessionFactory;

	protected Session openSession() {
		return hibernateSessionFactory.openSession();
	}

	protected StatelessSession openStatelessSession() {
		return hibernateSessionFactory.openStatelessSession();
	}

	protected Session getCurrentSession() {
		return hibernateSessionFactory.getCurrentSession();
	}

}
