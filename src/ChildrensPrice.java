package bad.robot.refactoring.chapter1;

public class ChildrensPrice extends Price{

    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getChargeFor(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}
