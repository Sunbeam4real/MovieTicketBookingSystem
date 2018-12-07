package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_SEATING")
@NamedQueries({
	@NamedQuery(name = "Seating.findAll", query = "SELECT s FROM Seating s"),
	@NamedQuery(name = "Seating.findByMoviename", query = "SELECT s FROM Seating s WHERE s.moviename = :mname")
})
public class Seating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name  = "seating_id")
	private int id;
	@Column(name = "moviename")
	private String moviename;
	@Column(name = "ticketsleft")
	private int ticketsleft;
	@Column(name = "type")
	private String type;
	@Column(name = "showtime")
	private String showtime;
	@Column(name = "price")
	private double price;
	@Column(name = "screennum")
	private int screennum;
	
	public Seating() {
		super();
	}
	
	

	public String getShowtime() {
		return showtime;
	}



	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getScreennum() {
		return screennum;
	}



	public void setScreennum(int screennum) {
		this.screennum = screennum;
	}



	public Seating(String moviename, int ticketsleft, String type, String showtime, double price,
			int screennum) {
		super();
		this.moviename = moviename;
		this.ticketsleft = ticketsleft;
		this.type = type;
		this.showtime = showtime;
		this.price = price;
		this.screennum = screennum;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public int getTicketsleft() {
		return ticketsleft;
	}

	public void setTicketsleft(int ticketsleft) {
		this.ticketsleft = ticketsleft;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Seating [id=" + id + ", moviename=" + moviename + ", ticketsleft=" + ticketsleft + ", type=" + type
				+ ", showtime=" + showtime + ", price=" + price + ", screennum=" + screennum + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((moviename == null) ? 0 : moviename.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + screennum;
		result = prime * result + ((showtime == null) ? 0 : showtime.hashCode());
		result = prime * result + ticketsleft;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seating other = (Seating) obj;
		if (id != other.id)
			return false;
		if (moviename == null) {
			if (other.moviename != null)
				return false;
		} else if (!moviename.equals(other.moviename))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (screennum != other.screennum)
			return false;
		if (showtime == null) {
			if (other.showtime != null)
				return false;
		} else if (!showtime.equals(other.showtime))
			return false;
		if (ticketsleft != other.ticketsleft)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
