package products;

public abstract class Product {
    protected static final int MINIMUM_PRICE = 0;

    private String name;
    private int sellIn;
    private int price;

    public Product(String name, int sellIn, int price) {
        this.name = name;
        this.sellIn = sellIn;
        this.price = price;
    }

    protected abstract int calculateNewPrice();

    protected abstract void updateSellIn();

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

    protected void setPrice(int price) {
        this.price = price;
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
