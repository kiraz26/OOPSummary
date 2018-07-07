package inheritance;

import abstraction.Rentable;
import encapsulation.Movie;

//establish inheritance relation between movie and action classes
//Action a = new Action(3.3, "Jumanji", 2018);
public class Action extends Movie implements Rentable {

	// adding a constructor
	public Action(double rating, String name, int year) {
		super(rating, name, year);
	}

	// OVERRIDE Watch method
	@Override
	public void watch() {
		System.out.println("Watching an Action movie: " + getName());
	}

	public void watch(double rating) {
		if (getRating() > rating) {
			System.out.println("Watching an Action movie: " + getName());
		} else {
			System.out.println(getName() + "'s rating is not above " + rating);
		}
	}

	@Override
	public void rent() {
		System.out.println("Renting an Action Movie: " + getName());
		
	}

}
