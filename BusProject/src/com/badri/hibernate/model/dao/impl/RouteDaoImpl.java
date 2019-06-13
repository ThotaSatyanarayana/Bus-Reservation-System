package com.badri.hibernate.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.badri.hibernate.model.Route;
import com.badri.hibernate.model.dao.RouteDao;

@Repository
public class RouteDaoImpl implements RouteDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	SessionFactory sessionFactory;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public List<String> getRoutes() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Route.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("origin"));
		criteria.setProjection(Projections.distinct(projList));
		List<String> routes = criteria.list();
		return routes;
	}

	@SuppressWarnings("unchecked")
	public List<Route> getDestinationByOrigin(String origin) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Route.class);
		criteria.add(Restrictions.eq("origin", origin));
		List<Route> destinations = criteria.list();
		return destinations;
	}

	@SuppressWarnings("unchecked")
	public Route getRoute(int id) {
		Session session = sessionFactory.openSession();
		String hql = "from Route r where r.route_id =(select b.route_id from Bus b where b.bus_id=:id)";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		List<Route> routes = query.list();
		return routes.size() > 0 ? routes.get(0) : null;
	}

}
