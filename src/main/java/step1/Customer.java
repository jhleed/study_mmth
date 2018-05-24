package step1;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    ;

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    ;

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals) {
            result += "\t" + String.valueOf(rental.getCharge()) + "(" + rental.getMovie().getTitle() + ")" + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter pointers";

        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental Record for " + getName() + "</h1>\n";
        for (Rental rental : _rentals) {
            result += "\t" + String.valueOf(rental.getCharge()) + "(" + rental.getMovie().getTitle() + ")" + "\n";
        }

        result += "<p>Amount owed is " + String.valueOf(getTotalCharge()) + "</p>\n";
        result += "<p>You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter pointers</p>";

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : _rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : _rentals) {
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

}