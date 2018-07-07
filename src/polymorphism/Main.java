package polymorphism;

import java.util.List;

import abstraction.Rentable;
import encapsulation.Movie;
import inheritance.Action;
import inheritance.Comedy;

public class Main {

	public static void main(String[] args) {
		List<Movie> netflixMovies = Netflix.getMoviesList();

		if (netflixMovies.get(0) instanceof Action) {
			System.out.println("It is an action movie");
		}

		System.out.println(netflixMovies.get(0).getClass());

		Rentable movie1 = new Action(5.4, "Transformer", 2012);
		Rentable movie2 = new Action(5.4, "Transformer", 2012);

		System.out.println(movie1.getClass());
		System.out.println(movie1 instanceof Action);

		System.out.println(movie2.getClass());
		System.out.println(movie2 instanceof Comedy);
		
		System.out.println("================");
		Movie movieToWatch=Netflix.rentARandom("Action");
		System.out.println(movieToWatch.toString());
		
		Netflix nt =new Netflix();
		Netflix.rent1("Comedy");

	}

}
