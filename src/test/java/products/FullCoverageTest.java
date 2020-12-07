package products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Full Coverage Test | Unit")
public class FullCoverageTest {

    @Test
    @DisplayName("Name should be Full Coverage")
    void nameShouldBeFullCoverage() {
        final FullCoverage product = new FullCoverage(10, 10);

        assertEquals("Full Coverage", product.getName());
    }

    @Test
    @DisplayName("updatePrice | Price increases by two units once there are no more days to sell it")
    void updatePricePriceIncrementInTwoUnits() {
        final int initialPrice = 2;
        final FullCoverage productWithoutDaysToSell = new FullCoverage(-1, initialPrice);

        productWithoutDaysToSell.updatePrice();

        assertEquals(initialPrice + 2, productWithoutDaysToSell.getPrice());
    }

    @Test
    @DisplayName("updatePrice | Price increases by one units if there are days to sell it")
    void updatePricePriceIncrementInOneUnit() {
        final int initialPrice = 3;
        final FullCoverage productWithDaysToSell = new FullCoverage(10, initialPrice);

        productWithDaysToSell.updatePrice();

        assertEquals(initialPrice + 1, productWithDaysToSell.getPrice());
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {10, 0, -10})
    @DisplayName("updatePrice | Price cannot be higher than 50")
    void updatePricePriceCannotBeHigherThan50(final int sellIn) {
        final FullCoverage product = new FullCoverage(sellIn, 49);

        product.updatePrice();

        assertEquals(50, product.getPrice());
    }
}

