package products;

public class MegaCoverage extends Product {

    public MegaCoverage(int sellIn) {
        super("Mega Coverage", sellIn, 80);
    }

    @Override
    protected int calculateNewPrice() {
        return this.getPrice();
    }

    @Override
    protected void updateSellIn() {
    }
}
