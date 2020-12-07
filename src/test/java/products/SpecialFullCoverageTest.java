package products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Special Full Coverage Test | Unit")
public class SpecialFullCoverageTest {

    @Test
    @DisplayName("Name should be Special Full Coverage")
    void nameShouldBeFullCoverage() {
        final SpecialFullCoverage product = new SpecialFullCoverage(10, 10);

        assertEquals("Special Full Coverage", product.getName());
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {20, 11})
    @DisplayName("updatePrice | Price increases by one if there are still more than 10 days to sell it")
    void updatePriceIncreasesByOne(final int moreThan10Days) {
        final int initialPrice = 30;
        final SpecialFullCoverage productWithMoreThan10Days = new SpecialFullCoverage(moreThan10Days, initialPrice);

        productWithMoreThan10Days.updatePrice();

        assertEquals(initialPrice + 1, productWithMoreThan10Days.getPrice());
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {10, 8, 6})
    @DisplayName("updatePrice | Price increases by two if there are between 10 and 6 days to sell it")
    void updatePriceIncreasesByTwo(final int between10And6) {
        final int initialPrice = 30;
        final SpecialFullCoverage productBetween10And6Days = new SpecialFullCoverage(between10And6, initialPrice);

        productBetween10And6Days.updatePrice();

        assertEquals(initialPrice + 2, productBetween10And6Days.getPrice());
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {5, 3, 1})
    @DisplayName("updatePrice | Price increases by three if there are between 5 or less days to sell it")
        void updatePriceIncreasesByThree(final int between5And1) {
        final int initialPrice = 30;
        final SpecialFullCoverage productBetween5And1Days = new SpecialFullCoverage(between5And1, initialPrice);

        productBetween5And1Days.updatePrice();

        assertEquals(initialPrice + 3, productBetween5And1Days.getPrice());
    }

    @ParameterizedTest(name = "sell in {0} with initial price {1}")
    @DisplayName("updatePrice | Price should not exceed 50")
    @CsvSource({"20,50", "10,49", "3,48"})
    void updatePriceIncreasesByThree(final int sellInt, final int initialPrice) {
        final SpecialFullCoverage product = new SpecialFullCoverage(sellInt, initialPrice);

        product.updatePrice();

        assertEquals(50, product.getPrice());
    }

    @Test
    @DisplayName("updatePrice | The price should drop to zero when there are no days left to sell it")
    void updatePriceIncreasesByThree() {
        final SpecialFullCoverage productWithOutDaysToSell = new SpecialFullCoverage(0, 10);

        productWithOutDaysToSell.updatePrice();

        assertEquals(0, productWithOutDaysToSell.getPrice());
    }

}
