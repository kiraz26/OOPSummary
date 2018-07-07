package abstraction;

import encapsulation.Movie;
import inheritance.Comedy;

public interface Rentable {
	
	public static final boolean AVAILIBLE_FOR_RENT = true;
	
	public abstract void rent();
	
	
	/**
	 * Movie m1 = new Comedy(7.7, "Liar Liar", 2001);
	 * Rentable.rentAMovie(m1, "Comedy");
	 * 
	 * Movie m2 = new Action(7.7, "Liar Liar", 2001);
	 * Rentable.rentAMovie(m2, "Comedy");
	 * 
	 * Movie m3 = new Movie(7.7, "Liar Liar", 2001);
	 * Rentable.rentAMovie(m3, "Comedy");
	 */
	public static void rentAMovie(Movie movie, String genre) {
		movie.watch();
	}
	
	
}
