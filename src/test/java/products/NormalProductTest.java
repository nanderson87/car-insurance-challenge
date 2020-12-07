package products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Normal Product Test | Unit")
public class NormalProductTest {
    private static final String NORMAL_PRODUCT_NAME = "Normal products";

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {10, 0, -10})
    @DisplayName("updatePrice | Price cannot become negative")
    void updatePricePriceCannotBecomeNegative(final int sellIn) {
        final int zeroPrice = 0;
        final NormalProduct product = new NormalProduct(NORMAL_PRODUCT_NAME, sellIn, zeroPrice);

        product.updatePrice();

        assertEquals(zeroPrice, product.getPrice());
    }

    @Test
    @DisplayName("updatePrice | Price degrades in two units once there are no more days to sell it")
    void updatePricePriceDegradesInTwoUnits() {
        final int initialPrice = 50;
        final NormalProduct productWithoutDaysToSell = new NormalProduct(NORMAL_PRODUCT_NAME, -1, initialPrice);

        productWithoutDaysToSell.updatePrice();

        assertEquals(initialPrice - 2, productWithoutDaysToSell.getPrice());
    }

    @Test
    @DisplayName("updatePrice | Price degrades in one units if there are days to sell it")
    void updatePricePriceDegradesInOneUnit() {
        final int initialPrice = 50;
        final NormalProduct productWithDaysToSell = new NormalProduct(NORMAL_PRODUCT_NAME, 10, initialPrice);

        productWithDaysToSell.updatePrice();

        assertEquals(initialPrice - 1, productWithDaysToSell.getPrice());
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {10, 0, -10})
    @DisplayName("updatePrice | Sell in days should decrease by one")
    void updatePriceSellInDaysShouldDecreaseByOne(final int sellIn) {
        final NormalProduct productWithDaysToSell = new NormalProduct(NORMAL_PRODUCT_NAME, sellIn, 12);

        productWithDaysToSell.updatePrice();

        assertEquals(sellIn - 1, productWithDaysToSell.getSellIn());
    }

}
