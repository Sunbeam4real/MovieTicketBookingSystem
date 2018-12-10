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
@Table(name = "JPA_BOOKING")
@NamedQueries({
	@NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
	@NamedQuery(name = "Booking.findByUserId", query = "SELECT b FROM Booking b WHERE b.userid = :uid")
})
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name  = "booking_id")
	private int id;
	
	
	@Column(name  = "seatingid")
	private int seatingid;
	
	@Column(name  = "userid")
	private int userid;
	
	@Column(name  = "quantity")
	private int quantity;

	public Booking(int seatingid, int userid, int quantity) {
		super();
		
		this.seatingid = seatingid;
		this.userid = userid;
		this.quantity = quantity;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeatingid() {
		return seatingid;
	}

	public void setSeatingid(int seatingid) {
		this.seatingid = seatingid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", seatingid=" + seatingid + ", userid=" + userid + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + quantity;
		result = prime * result + seatingid;
		result = prime * result + userid;
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
		Booking other = (Booking) obj;
		if (id != other.id)
			return false;
		if (quantity != other.quantity)
			return false;
		if (seatingid != other.seatingid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
	
}
