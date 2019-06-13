package com.badri.hibernate.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.badri.hibernate.model.Bus;
import com.badri.hibernate.model.Route;
import com.badri.hibernate.model.dao.BusDao;

@Repository
public class BusDaoImpl implements BusDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	SessionFactory sessionFactory;

	public List<Bus> findByRouteAndDate(Route route, String date) {
		String query = "select bus_id,DEPARTURETIME,ARRIVALTIME,FARE,(select 40-count(*) from reserve where bus_id=bus.bus_id and  dt=STR_TO_DATE(?,'%e-%M-%Y')) as AVAILABLITY"
				+ " from bus" + " where route_id in (select route_id from route where origin=? and destination=?)";

		List<Bus> buses = new ArrayList<Bus>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query,
				new Object[] { date, route.getOrigin(), route.getDestination() });
		for (Map<String, Object> row : rows) {
			Bus bus = new Bus();
			bus.setBus_id((Integer) row.get("bus_id"));
			bus.setFare((Integer) row.get("fare"));
			bus.setDeparturetime((String) row.get("departuretime"));
			bus.setArrivaltime((String) row.get("arrivaltime"));
			bus.setAvailablityCount(((Long) row.get("AVAILABLITY")).intValue());
			buses.add(bus);
		}
		return buses;
	}

	public Bus searchbus(int id) {
		Session session = sessionFactory.openSession();
		Bus bus=(Bus)session.get(Bus.class, id);
		return bus;
	}

}
