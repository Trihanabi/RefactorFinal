package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getChargeFor()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(calculateTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    private double getTotalCharge()
    {
        double result = 0;
        for (Rental rental: rentals) {
            result += rental.getChargeFor();
        }
        return result;
    }

    private int calculateTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental: rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    private String htmlStatement()
    {
    	String result;
    	result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
    	for (Rental rental: rentals) {
            result += rental.getMovie().getTitle() + ": " + rental.getChargeFor() + "<BR>\n";
        }
    	
    	result += "<P>You owe <EM>" + getTotalCharge() + "</EM></P>\n";
    	result += "On this rental you earned <EM>" + calculateTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";
    	
    	return result;
    }

}