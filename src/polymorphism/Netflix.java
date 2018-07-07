package polymorphism;

import java.util.ArrayList;
import java.util.List;

import encapsulation.Movie;
import inheritance.Action;
import inheritance.Comedy;

public class Netflix {

	public static List<Movie> getMoviesList() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Action(8.4, "Dexter", 2003));
		movies.add(new Action(9.8, "Rambo", 1970));
		movies.add(new Movie(9.0, "Leon", 1999));
		movies.add(new Movie(9.3, "Godfather", 1966));
		movies.add(new Comedy(8.6, "Organize Isler", 2003));
		movies.add(new Comedy(7.7, "Liar Liar", 2001));

		return movies;
	}

	public static Movie rentARandom(String genre) {
		// getMoviesList();
		List<Movie> availible = getMoviesList();

		for (Movie movie : availible) {
			if (genre.equals("Action")) {
				if (movie instanceof Action) {
					return movie;
				}
			} else if (genre.equals("Comedy")) {
				if (movie instanceof Comedy) {
					return movie;
				}
			} else if (genre.equals("Movie")) {
				if (movie instanceof Movie) {
					return movie;
				}
			}

		}
		return null;
	}

	// Homework -->return highest rated movie
	// public static Movie rent(String genre)
	public static Movie rent1(String genre) {
		// getMoviesList();
		List<Movie> availible = getMoviesList();

		for (int i = 0; i < availible.size(); i++) {

			if (availible.size() - 1 >= i && genre.equals("Action")) {
				if (availible.get(i).getRating() > availible.get(i + 1).getRating()) {
					if (availible instanceof Action) {
						return availible.get(i);
					} else {
						return availible.get(i + 1);
					}
				} else if (genre.equals("Comedy")) {
					if (availible.get(i).getRating() > availible.get(i + 1).getRating()) {
						if (availible instanceof Comedy) {
							return availible.get(i);
						} else {
							return availible.get(i + 1);
						}
					}
				} else if (genre.equals("Movie")) {
					if (availible.get(i).getRating() > availible.get(i + 1).getRating()) {
						if (availible instanceof Movie) {
							return availible.get(i);
						}else {
							return availible.get(i + 1);
						}
					}
				}
			}
			
		}
		return null;
	}

}
