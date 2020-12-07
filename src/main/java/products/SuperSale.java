package products;

public class SuperSale extends NormalProduct {

    public SuperSale(int sellIn, int price) {
        super("Super Sale", sellIn, price);
    }

    @Override
    protected int calculateNewPrice() {
        final int actualPrice = this.getPrice();
        final int variationNormalPrice = actualPrice - super.calculateNewPrice();
        return Math.max(actualPrice - (variationNormalPrice * 2), MINIMUM_PRICE);
    }
}
