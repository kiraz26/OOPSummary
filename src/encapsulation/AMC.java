package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import abstraction.Rentable;
import inheritance.Action;
import inheritance.Comedy;

public class AMC {
	public static void main(String[] args) {

		Movie movie1 = new Movie(9.3, "Godfather", 1966);
		System.out.println(movie1);
		System.out.println(movie1.toString());
		List<String> genres = Movie.getAvailibleGenres();
		System.out.println(genres);

		// create an array that can hold 3 movies and assign movies
		Movie[] movies = new Movie[3];
		movies[0] = new Movie(9.3, "Godfather", 1966);
		movies[1] = new Movie(9.2, "Fight Club", 2002);
		movies[2] = new Movie(9.0, "Lord of the Rings", 2003);

		System.out.println(Arrays.toString(movies));

		for (Movie movie : movies) {
			System.out.println(movie);
		}
		System.out.println("===========================");
		// create an ArrayList that can hold movies and assign 3 movies

		List<Movie> movies1 = new ArrayList<>(); // polymorphisim
		movies1.add(new Movie(9.0, "Leon", 1999));
		movies1.add(new Movie(8.6, "Organize Isler", 2003));
		movies1.add(new Movie(4.2, "Cukur", 2018));

		System.out.println(movies1);

		// loop though movies1 if rating is> 8.2 then watch it
		for (Movie movie : movies1) {
			if (movie.getRating() > 8.2) {
				movie.watch();
			}
		}

		System.out.println("=======================");
		// ===========================================
		Action actionMovie1 = new Action(7.5, "Mission Imposible", 2017);
		actionMovie1.watch();

		// Polymorphisim way of instantiation
		Movie actionMovie2 = new Action(7.8, "Rambo", 1970);
		actionMovie2.watch();

		// Action actionMovie3 = (Action) new Movie(7.6, "Samurai", 2007);

		Movie comedy1 = new Comedy(7.7, "Liar Liar", 2001);
		comedy1.watch();

		System.out.println(Action.getAvailibleGenres());

		// actionMovie2.watch(8); -->it will not work. When using Polymorphism:
		// Reference type decided what methods you call. In our case Movie is a
		// reference type and we can call only methods that are present in Movie class.

		Action action1 = (Action) actionMovie2; // DOWNCASTING
		action1.watch(8.0); // --->it will work because of casting

		((Action) actionMovie2).watch(8.0); // DOWNCASTING --->it will work because of casting

		// =================================
		System.out.println(Rentable.AVAILIBLE_FOR_RENT);

		Movie m1 = new Comedy(7.7, "Liar Liar", 2001);
		Rentable.rentAMovie(m1, "Comedy");

		Movie m2 = new Action(7.7, "Liar Liar", 2001);
		Rentable.rentAMovie(m2, "Comedy");

		// Movie m3 = new Movie(7.7, "Liar Liar", 2001);
		Rentable.rentAMovie(new Movie(7.7, "Liar Liar", 2001), "Comedy");
		Rentable.rentAMovie(new Action(7.7, "Liar Liar", 2001), "Comedy"); // <--- polyphormic parameter

		Rentable rent = new Action(8.4, "Dexter", 2003);
		rent.rent();
		((Action) rent).watch(); // for call watch() needs to cast because Rentable doesn't have watch() method

	}
}
