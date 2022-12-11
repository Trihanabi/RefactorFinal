package bad.robot.refactoring.chapter1;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public Movie(Movie m) {
        this.title = m.title;
        setPriceCode(m.priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }
    
    double getChargeFor(int daysRented) {
        double amount = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }
        return amount;
    }
    
    public int getFrequentRenterPoints(int daysRented)
    {
    	if((getPriceCode() == NEW_RELEASE) && daysRented > 1)
    		return 2;
    	else
    		return 1;
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                this.priceCode = new RegularPrice().getPriceCode();
                break;
            case CHILDREN:
                this.priceCode = new ChildrensPrice().getPriceCode();
                break;
            case NEW_RELEASE:
                this.priceCode = new NewReleasePrice().getPriceCode();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
}