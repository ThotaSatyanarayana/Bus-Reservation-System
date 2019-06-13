package com.badri.bean;

import com.badri.hibernate.model.Reserve;

public class Reservation extends Reserve {
	private String origin;
	private String destination;
	private String departuretime;
	private String arrivaltime;
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public Reservation() {
	}

	public Reservation(Reserve reserve) {
		this.setReserve_id(reserve.getReserve_id());
		this.setPassenger_id(reserve.getPassenger_id());
		this.setBus_id(reserve.getBus_id());
		this.setDt(reserve.getDt());
		this.setTstamp(reserve.getTstamp());
		this.setSeat(reserve.getSeat());
	}

	public Reservation(int reserve_id, int passenger_id, int bus_id, String dt, String tstamp, int seat, String origin,
			String destination, String departuretime, String arrivaltime) {
		this.setReserve_id(reserve_id);
		this.setPassenger_id(passenger_id);
		this.setBus_id(bus_id);
		this.setDt(dt);
		this.setTstamp(tstamp);
		this.setSeat(seat);
		this.origin = origin;
		this.destination = destination;
		this.departuretime = departuretime;
		this.arrivaltime = arrivaltime;
	}

}
