package products;

import exceptions.InvalidProductStateException;

public class NormalProduct extends Product {
    protected static final int MAXIMUM_PRICE = 50;

    public NormalProduct(String name, int sellIn, int price) {
        super(name, sellIn, price);
    }

    @Override
    protected int calculateNewPrice() {
        final int newPrice;

        if (saleDateExpired()) {
            newPrice = this.getPrice() - 2;
        } else {
            newPrice = this.getPrice() - 1;
        }

        return Math.max(newPrice, MINIMUM_PRICE);
    }

    @Override
    protected void updateSellIn() {
        this.setSellIn(this.getSellIn() - 1);
    }

    @Override
    protected void validateSpecificProductPrice(int price) {
        validateMaximumPrice(price);
    }

    private void validateMaximumPrice(int price) {
        if(price > MAXIMUM_PRICE) {
            throw new InvalidProductStateException(String.format("The product cannot be priced [%s] higher than %s",
                    price, MAXIMUM_PRICE));
        }
    }

}
