package com.record10.model;

public class Rating {
	
	private String movie;
	private int rating;
	
	
	public Rating(String movie, int rating) {
		super();
		this.movie = movie;
		this.rating = rating;
	}
	
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
