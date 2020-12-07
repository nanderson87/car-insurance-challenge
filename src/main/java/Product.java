public class Product {
    private String name;
    private int sellIn;
    private int price;

    public Product(String name, int sellIn, int price) {
        this.name = name;
        this.sellIn = sellIn;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
