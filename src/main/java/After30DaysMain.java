import org.apache.log4j.Logger;
import products.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class After30DaysMain {
    private static final Logger LOGGER = Logger.getLogger(After30DaysMain.class);
    private static final int FROM = 0;
    private static final int TO = 30;

    public static void main(String[] args) {
        List<Product> productsAtDayZero = Arrays.asList(
                new NormalProduct("Medium Coverage", 10, 20),
                new FullCoverage(2, 0),
                new NormalProduct("Low Coverage", 5, 7),
                new MegaCoverage(0),
                new MegaCoverage(-1),
                new SpecialFullCoverage(15, 20),
                new SpecialFullCoverage(10, 49),
                new SpecialFullCoverage(5, 49),
                new SuperSale(3, 6));

        final CarInsurance carInsurance = new CarInsurance(productsAtDayZero);

        IntStream.rangeClosed(FROM, TO).forEach(i -> {
            LOGGER.info(String.format(" ---- days %s ---- ", i));
            LOGGER.info("name, sellIn, price");

            if (i == 0) {
                logProducts(productsAtDayZero);
            } else {
                logProducts(carInsurance.updatePrice());
            }

            LOGGER.info("");
        });
    }

    static private void logProducts(List<Product> products) {
        products.forEach(product -> LOGGER.info(String.format("%s, %s, %s",
                product.getName(), product.getSellIn(), product.getPrice())));
    }
}
