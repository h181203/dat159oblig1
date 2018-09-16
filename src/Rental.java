

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }
    
	/**
	 * @param thisAmount
	 * @param each
	 * @return
	 * 
	 * Extracted the switch into its own method and moved it into the Rental class. I would normally use inheritance and multiple classes, but that was not asked for here.
	 */
	public double elementAmount() {
		int thisAmount = 0;
		switch (this.getMovie().getPriceCode()) {
		    case Movie.REGULAR:
		        thisAmount += 2;
		        if (this.getDaysRented() > 2)
		            thisAmount += (this.getDaysRented() - 2) * 1.5;
		        break;
		    case Movie.NEW_RELEASE:
		        thisAmount += this.getDaysRented() * 3;
		        break;
		    case Movie.CHILDRENS:
		        thisAmount += 1.5;
		        if (this.getDaysRented() > 3)
		            thisAmount += (this.getDaysRented() - 3) * 1.5;
		        break;
		}
		return thisAmount;
	}

	/**
	 * @param frequentRenterPoints
	 * @return
	 * 
	 * Made everything related to frequent renting into a method. This rendered the variable extraction of movie rather useless.
	 * This method was then moved into this class, as there was a clear feature envy in the Customer class.
	 */
	int addFrequentRenterPoints(int frequentRenterPoints) {
		frequentRenterPoints ++;
		// add bonus for a two day new release rental
		/**
	     * Extracted booleans isNewRelease and rentedMoreThanOneDay from 
	     * ((movie.getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
	     */
		boolean isNewRelease = (getMovie().getPriceCode() == Movie.NEW_RELEASE);
		boolean rentedMoreThanOneDay = (getDaysRented() > 1);
		if (isNewRelease && rentedMoreThanOneDay) frequentRenterPoints ++;
		return frequentRenterPoints;
	}
}
