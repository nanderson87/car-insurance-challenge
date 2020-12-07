package products;

public class FullCoverage extends NormalProduct {

    public FullCoverage(int sellIn, int price) {
        super("Full Coverage", sellIn, price);
    }

    @Override
    protected int calculateNewPrice() {
        final int newPrice;

        if (saleDateExpired()) {
            newPrice = this.getPrice() + 2;
        } else {
            newPrice = this.getPrice() + 1;
        }

        return Math.min(newPrice, MAXIMUM_PRICE);
    }
}
