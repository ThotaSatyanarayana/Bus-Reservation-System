 package com.badri.hibernate.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.badri.hibernate.model.Passenger;
import com.badri.hibernate.model.dao.PassengerDao;

@Repository
public class PassengerDaoImpl implements PassengerDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	SessionFactory sessionFactory;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional(readOnly = false)
	public void savePassenger(Passenger passenger) {
		hibernateTemplate.save(passenger);
	}

	@SuppressWarnings("unchecked")
	public Passenger validateLogin(Passenger passenger) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Passenger.class);
		criteria.add(Restrictions.eq("email", passenger.getEmail()));
		criteria.add(Restrictions.eq("password", passenger.getPassword()));
		List<Passenger> passengers = criteria.list();
		return passengers.size() > 0 ? passengers.get(0) : null;
	}

}
