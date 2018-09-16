
import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // determine amount for each line
            double thisAmount = elementAmount(each);
            
            /**
             * Extracted variable movie from each.getMovie()
             */
            Movie movie = each.getMovie();
            
            // add frequent renter points
            frequentRenterPoints = each.addFrequentRenterPoints(frequentRenterPoints);

            //show figures for this rental
            result += "\t" + movie.getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        result = addFooterLines(totalAmount, frequentRenterPoints, result);
        return result;
    }

	/**
	 * @param totalAmount
	 * @param frequentRenterPoints
	 * @param result
	 * @return
	 * 
	 * Extracted method
	 */
	private String addFooterLines(double totalAmount, int frequentRenterPoints, String result) {
		//add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
		return result;
	}
	
	private double elementAmount(Rental each){
		return each.elementAmount();
	}


    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}
