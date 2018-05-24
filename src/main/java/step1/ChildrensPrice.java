package step1;

public class ChildrensPrice implements Price {

    @Override
    public double getCharge(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;

    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        return frequentRenterPoints;
    }
}
