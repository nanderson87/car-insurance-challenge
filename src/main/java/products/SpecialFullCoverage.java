package products;

public class SpecialFullCoverage extends NormalProduct {

    public SpecialFullCoverage(int sellIn, int price) {
        super("Special Full Coverage", sellIn, price);
    }

    @Override
    protected int calculateNewPrice() {
        if (this.saleDateExpired()) {
            return 0;
        }

        int newPrice = this.getPrice() + 1;

        if (this.dateToSellInRange(6, 10)) {
            newPrice = this.getPrice() + 2;
        }

        if (this.dateToSellInRange(1, 5)) {
            newPrice = this.getPrice() + 3;
        }

        return Math.min(newPrice, MAXIMUM_PRICE);
    }


    private boolean dateToSellInRange(final int lowerBound, final int upperBound) {
        return (this.getSellIn() >= lowerBound) && (this.getSellIn() <= upperBound);
    }
}
