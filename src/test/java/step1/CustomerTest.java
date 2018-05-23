package step1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Test
    public void 생성자_null() {
        customer = new Customer(null);
        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", customer.statement());
    }

    @Test
    public void 생성자_이름_설정() {
        customer = new Customer("종호");
        assertEquals("Rental Record for 종호\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", customer.statement());
    }
}