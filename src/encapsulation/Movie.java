package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie  {
	/*
	 * Encapsulated data: double rating; String name; int year;
	 */

	private double rating;
	private String name;
	private int year;
	private static List<String> genres;
	// static block that adds following genres:
	// Comedy, Action, Adventure, Western, Historical, Thriller, Animation
	
	
	
	static {
		genres=new ArrayList<>();
		genres.add("Comedy");
		genres.add("Action");
		genres.add("Adventure");
		genres.add("Western");
		genres.add("Historical");
		genres.add("Thriller");
		genres.add("Animation");

	}

	// CONSTRUCTOR
	public Movie() {
		this(2.2, "sd", 1231);
		
	}

	public Movie(double rating, String name, int year) {
		this.rating = rating;
		this.name = name;
		this.year = year;
	}

	// GETTERS AND SETTERS
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public static List<String> getGenres() {
		return genres;
	}

	public static void setGenres(List<String> genres) {
		Movie.genres = genres;
	}

	public static List<String> getAvailibleGenres() {
		return genres;
	}

	@Override
	public String toString() {
		return "Movie [rating=" + rating + ", name=" + name + ", year=" + year + "]";
	}
	
	public void watch() {
		System.out.println("Watching a movie: "+this.name);
	}
	
	
	

}
