package bad.robot.refactoring.chapter1;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getChargeFor(int daysRented) {
        int amount = 0;
        amount += daysRented * 3;
        return amount;
    }
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
