package step1;

public interface Price {
    double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented);
}
