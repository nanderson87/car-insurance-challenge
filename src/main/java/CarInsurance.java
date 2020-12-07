import java.util.ArrayList;
import java.util.List;

public class CarInsurance {
    private List<Product> products = new ArrayList<Product>();

    public CarInsurance(List<Product> products) {
        this.products = products;
    }

    public List<Product> updatePrice() {
        for (int i = 0; i < this.products.size(); i++) {

            if (!this.products.get(i).name.equals("Full Coverage") && !this.products.get(i).name.equals("'Special Full Coverage'")) {
                if (this.products.get(i).price > 0) {
                    if (!this.products.get(i).name.equals("Mega Coverage")) {
                        this.products.get(i).price = this.products.get(i).price - 1;
                    }
                }
            } else {
                if (this.products.get(i).price < 50) {
                    this.products.get(i).price = this.products.get(i).price + 1;
                    if (this.products.get(i).name.equals("'Special Full Coverage'")) {
                        if (this.products.get(i).sellIn < 11) {
                            if (this.products.get(i).price < 50) {
                                this.products.get(i).price = this.products.get(i).price + 1;
                            }
                        }
                        if (this.products.get(i).sellIn < 6) {
                            if (this.products.get(i).price < 50) {
                                this.products.get(i).price = this.products.get(i).price + 1;
                            }
                        }
                    }
                }
            }
            if (!this.products.get(i).name.equals("Mega Coverage")) {
                this.products.get(i).sellIn = this.products.get(i).sellIn - 1;
            }

            if (this.products.get(i).sellIn < 0) {
                if (!this.products.get(i).name.equals("Full Coverage")) {
                    if (!this.products.get(i).name.equals("Special Full Coverage")) {
                        if (this.products.get(i).price > 0) {
                            if (!this.products.get(i).name.equals("Mega Coverage")) {
                                this.products.get(i).price = this.products.get(i).price - 1;
                            }
                        }
                    } else {
                        this.products.get(i).price = this.products.get(i).price - this.products.get(i).price;
                    }
                } else {
                    if (this.products.get(i).price < 50) {
                        this.products.get(i).price = this.products.get(i).price + 1;
                    }
                }
            }
        }

        return this.products;
    }
}

