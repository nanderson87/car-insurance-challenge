package products;

import exceptions.InvalidProductStateException;

public abstract class Product {
    protected static final int MINIMUM_PRICE = 0;

    private String name;
    private int sellIn;
    private int price;

    public Product(String name, int sellIn, int price) {
        this.name = name;
        this.sellIn = sellIn;
        this.setPrice(price);
    }

    protected abstract int calculateNewPrice();

    protected abstract void updateSellIn();

    protected abstract void validateSpecificProductPrice(int price);

    public void updatePrice() {
        this.setPrice(this.calculateNewPrice());
        this.updateSellIn();
    }

    public boolean saleDateExpired() {
        return sellIn <= 0;
    }

    protected void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    private void setPrice(int price) {
        this.validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        validateNegativePrice(price);
        validateSpecificProductPrice(price);
    }


    private void validateNegativePrice(int price) {
        if(price < MINIMUM_PRICE) {
            throw new InvalidProductStateException(String.format("Product cannot be negatively priced %s", price));
        }
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getPrice() {
        return price;
    }

}
