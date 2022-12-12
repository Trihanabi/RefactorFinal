package bad.robot.refactoring.chapter1;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getChargeFor(int daysRented) {
        double amount = 0;
        amount += daysRented * 3;
        return amount;
    }
}
