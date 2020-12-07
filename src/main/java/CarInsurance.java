import java.util.ArrayList;
import java.util.List;

public class CarInsurance {
    private List<Product> products = new ArrayList<>();

    public CarInsurance(List<Product> products) {
        this.products = products;
    }

    public List<Product> updatePrice() {
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getName().equals("Super Sale")) {
                if (this.products.get(i).getPrice() > 0) {
                    final int actualPrice = this.products.get(i).getPrice();
                    final int newPrice = (actualPrice - 2 > 0) ? actualPrice - 2 : 0;
                    this.products.get(i).setPrice(newPrice);
                }

                if (this.products.get(i).getSellIn() <= 0) {
                    final int actualPrice = this.products.get(i).getPrice();
                    final int newPrice = (actualPrice - 2 > 0) ? actualPrice - 2 : 0;
                    this.products.get(i).setPrice(newPrice);
                }
            } else {
                if (!this.products.get(i).getName().equals("Full Coverage") && !this.products.get(i).getName().equals("Special Full Coverage")) {
                    if (this.products.get(i).getPrice() > 0) {
                        if (!this.products.get(i).getName().equals("Mega Coverage")) {
                            this.products.get(i).setPrice(this.products.get(i).getPrice() - 1);
                        }
                    }
                } else {
                    if (this.products.get(i).getPrice() < 50) {
                        this.products.get(i).setPrice(this.products.get(i).getPrice() + 1);
                        if (this.products.get(i).getName().equals("Special Full Coverage")) {
                            if (this.products.get(i).getSellIn() < 11) {
                                if (this.products.get(i).getPrice() < 50) {
                                    this.products.get(i).setPrice(this.products.get(i).getPrice() + 1);
                                }
                            }
                            if (this.products.get(i).getSellIn() < 6) {
                                if (this.products.get(i).getPrice() < 50) {
                                    this.products.get(i).setPrice(this.products.get(i).getPrice() + 1);
                                }
                            }
                        }
                    }
                }
                if (!this.products.get(i).getName().equals("Mega Coverage")) {
                    this.products.get(i).setSellIn(this.products.get(i).getSellIn() - 1);
                }

                if (this.products.get(i).getSellIn() < 0) {
                    if (!this.products.get(i).getName().equals("Full Coverage")) {
                        if (!this.products.get(i).getName().equals("Special Full Coverage")) {
                            if (this.products.get(i).getPrice() > 0) {
                                if (!this.products.get(i).getName().equals("Mega Coverage")) {
                                    this.products.get(i).setPrice(this.products.get(i).getPrice() - 1);
                                }
                            }
                        } else {
                            this.products.get(i).setPrice(this.products.get(i).getPrice() - this.products.get(i).getPrice());
                        }
                    } else {
                        if (this.products.get(i).getPrice() < 50) {
                            this.products.get(i).setPrice(this.products.get(i).getPrice() + 1);
                        }
                    }
                }
            }
        }

        return this.products;
    }
}

