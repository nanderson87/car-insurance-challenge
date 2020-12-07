import products.Product;

import java.util.ArrayList;
import java.util.List;

public class CarInsurance {
    private List<Product> products = new ArrayList<>();

    public CarInsurance(List<Product> products) {
        this.products = products;
    }

    public List<Product> updatePrice() {
        products.forEach(product -> product.updatePrice());
        return this.products;
    }
}

