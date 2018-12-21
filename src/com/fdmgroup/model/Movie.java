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
	@NamedQuery(name = "movie.findByMoviename", query = "SELECT m FROM Movie m WHERE m.moviename = :mname"),
	@NamedQuery(name = "movie.findById", query = "SELECT m FROM Movie m WHERE m.movie_id = :mid")
})
public class Movie {
	@Id
	@Column(name  = "movie_id")
	private String movie_id;
	
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
	
	
	@Column(name="link")
	private String link;
	
	
	@Column(name="des")
	private String des;
	
	@Column(name = "onshow")
	private String onshow;
	
	
	public Movie(String id, String moviename, String length, String director, String stars, String catagory, String link, String des, String onshow) {
		super();
		this.movie_id = id;
		this.moviename = moviename;
		this.length = length;
		this.director = director;
		this.stars = stars;
		this.catagory = catagory;
		this.link = link;
		this.des = des;
		this.onshow = onshow;
	}

	public String getOnshow() {
		return onshow;
	}

	public void setOnshow(String onshow) {
		this.onshow = onshow;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Movie() {
		super();
	}

	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getId() {
		return movie_id;
	}

	public void setId(String id) {
		this.movie_id = id;
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
		return "Movie [id=" + movie_id + ", moviename=" + moviename + ", length=" + length + ", director=" + director
				+ ", stars=" + stars + ", catagory=" + catagory + ", link=" + link + ", des=" + des + ", onshow="
				+ onshow + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result + ((des == null) ? 0 : des.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((movie_id == null) ? 0 : movie_id.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((moviename == null) ? 0 : moviename.hashCode());
		result = prime * result + ((onshow == null) ? 0 : onshow.hashCode());
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
		if (des == null) {
			if (other.des != null)
				return false;
		} else if (!des.equals(other.des))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (movie_id == null) {
			if (other.movie_id != null)
				return false;
		} else if (!movie_id.equals(other.movie_id))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (moviename == null) {
			if (other.moviename != null)
				return false;
		} else if (!moviename.equals(other.moviename))
			return false;
		if (onshow == null) {
			if (other.onshow != null)
				return false;
		} else if (!onshow.equals(other.onshow))
			return false;
		if (stars == null) {
			if (other.stars != null)
				return false;
		} else if (!stars.equals(other.stars))
			return false;
		return true;
	}
	
	
}
