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

}