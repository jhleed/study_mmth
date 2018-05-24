package step1;

public class NewReleasePrice implements Price {

    @Override
    public double getCharge(int daysRented) {
        return (double) (daysRented * 3);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
