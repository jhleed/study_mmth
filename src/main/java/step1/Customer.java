package step1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    ;

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    ;

    /**
     * 영화에 대한 계산서를 제공
     *
     * @return
     */
    public String statement() {
        double totalAmount = 0; //총 대여료
        int frequentRenterPoints = 0; //포인트
        Iterator<Rental> iterator = rentals.iterator();
        String result = "Rental Record for " + getName() + "\n"; //결과값 (계산서)

        while (iterator.hasNext()) {
            double thisAmount = 0;
            Rental each = (Rental) iterator.next();
            // 각 영화에 대한 요금을 결정한다.
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;

                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;

                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            // 포인트를 추가한다.
            frequentRenterPoints++;
            // 최신 영화를 2일 이상 대여하는 경우 추가 포인트 제공
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            // 이 대여에 대한 요금 계산결과 표시
            result += "\t" + String.valueOf(thisAmount) + "(" + each.getMovie().getTitle() + ")" + "\n";

            totalAmount += thisAmount;
        }

        //footer 추가
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter pointers";

        return result;
    }
}