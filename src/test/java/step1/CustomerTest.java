package step1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer = new Customer("이종호");
    private Movie movie = new Movie("어벤져스");


    @Test
    public void 첫번째_테스트_이름_null() {
        Customer customer = new Customer(null);
        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", customer.statement());
    }

    @Test
    public void 두번째_테스트_이름_설정() {
        assertEquals("Rental Record for 이종호\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", customer.statement());
    }

    @Test
    public void 네번째_테스트_priceCode_Regular() {
        movie.setPriceCode(Movie.REGULAR);
        int daysRented = 3;
        Rental rental = new Rental(movie, daysRented);

        customer.addRental(rental);
        assertEquals("Rental Record for 이종호\n" +
                "\t3.5(어벤져스)\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }

    @Test
    public void 다섯번째_테스트_priceCode_Regular() {
        movie.setPriceCode(Movie.NEW_RELEASE);
        int daysRented = 3;
        Rental rental = new Rental(movie, daysRented);

        customer.addRental(rental);
        assertEquals("Rental Record for 이종호\n" +
                "\t9.0(어벤져스)\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter pointers", customer.statement());
    }

    @Test
    public void 여섯번째_테스트_priceCode_Regular() {
        movie.setPriceCode(Movie.CHILDRENS);
        int daysRented = 4;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);
        assertEquals("Rental Record for 이종호\n" +
                "\t3.0(어벤져스)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }
}