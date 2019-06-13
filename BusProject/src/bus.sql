create database bus;


create table passenger(
passenger_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
password VARCHAR(40) NOT NULL,
email VARCHAR(40) NOT NULL,
mobile VARCHAR(40) NOT NULL,
photoname VARCHAR(40) NOT NULL,
phototype VARCHAR(40) NOT NULL,
photo blob
);
alter table passenger modify photo blob NOT NULL;





create table route(
route_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
origin VARCHAR(40) NOT NULL,
destination VARCHAR(40) NOT NULL
);
CREATE UNIQUE INDEX ROUTE_UNIQUE ON route(origin,destination);

insert into route(origin,destination) values('Macherla','Hyderbad');
insert into route(origin,destination) values('Bapatla','Hyderbad');


create table bus(
bus_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
route_id INT NOT NULL,
passenger_id INT NOT NULL,
fare INT NOT NULL,
departuretime VARCHAR(40) NOT NULL,
arrivaltime VARCHAR(40) NOT NULL,
FOREIGN KEY (route_id) REFERENCES route(route_id)
);
insert into bus(route_id,fare,departuretime,arrivaltime)values(1,1600,'20:00','09:00');
insert into bus(route_id,fare,departuretime,arrivaltime)values(2,1600,'20:00','09:00');



create table reserve(
reserve_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
passenger_id INT NOT NULL,
bus_id INT NOT NULL,
dt DATE NOT NULL, 
tstamp DATE NOT NULL,
seat INT NOT NULL,
FOREIGN KEY(passenger_id) REFERENCES passenger(passenger_id),
FOREIGN KEY(bus_id) REFERENCES bus(bus_id)
);
CREATE UNIQUE INDEX SEAT_UNIQUE ON reserve(bus_id,dt,seat);



create view reservation as 
	select
		reserve.reserve_id as reserve_id,
		reserve.passenger_id as passenger_id,
		reserve.bus_id as bus_id,
		reserve.seat as seat,
		reserve.dt as dt,
		reserve.tstamp as tstamp,
		route.origin as origin,
		route.destination as destination,
		bus.departuretime as departuretime,
		bus.arrivaltime as arrivaltime
	from 
		((reserve
		join bus)
		join route)
	where
		((reserve.bus_id=bus.bus_id)
			and (route.route_id=bus.route_id))
	order by reserve.reserve_id;
		
	





