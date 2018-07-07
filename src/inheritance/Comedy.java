package inheritance;

import abstraction.Rentable;
import encapsulation.Movie;

public class Comedy extends Movie implements Rentable {

	public Comedy(double rating, String name, int year) {
		// super(rating, name, year); -----> OR
		setRating(rating);
		setName(name);
		setYear(year);
	}

	@Override
	public void watch() {
		System.out.println("Watching an Comedy movie: " + getName());
	}

	@Override
	public void rent() {
		System.out.println("Renting a Comedy Movie: " + getName());

	}
}
