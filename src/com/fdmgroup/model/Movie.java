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
@Table(name = "JPA_MOVIE")
@NamedQueries({
	@NamedQuery(name = "movie.findAll", query = "SELECT m FROM Movie m"),
	@NamedQuery(name = "movie.findByMoviename", query = "SELECT m FROM Movie m WHERE m.moviename = :mname")
})
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name  = "movie_id")
	private int id;
	
	@Column(name = "moviename")
	private String moviename;
	
	@Column(name = "length")
	private String length;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "stars")
	private String stars;
	
	@Column(name = "catagory")
	private String catagory;
	
	public Movie() {
		super();
	}

	public Movie(String moviename, String length, String director, String stars, String catagory) {
		super();
		this.moviename = moviename;
		this.length = length;
		this.director = director;
		this.stars = stars;
		this.catagory = catagory;
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

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", moviename=" + moviename + ", length=" + length + ", director=" + director
				+ ", stars=" + stars + ", catagory=" + catagory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + id;
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((moviename == null) ? 0 : moviename.hashCode());
		result = prime * result + ((stars == null) ? 0 : stars.hashCode());
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
		Movie other = (Movie) obj;
		if (catagory == null) {
			if (other.catagory != null)
				return false;
		} else if (!catagory.equals(other.catagory))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (id != other.id)
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (moviename == null) {
			if (other.moviename != null)
				return false;
		} else if (!moviename.equals(other.moviename))
			return false;
		if (stars == null) {
			if (other.stars != null)
				return false;
		} else if (!stars.equals(other.stars))
			return false;
		return true;
	}
	
	
}
