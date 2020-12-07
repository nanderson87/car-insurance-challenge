package products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Mega Coverage Test | Unit")
public class MegaCoverageTest {

    @Test
    @DisplayName("Name should be Mega Coverage")
    void nameShouldBeFullCoverage() {
        final MegaCoverage product = new MegaCoverage(0);

        assertEquals("Mega Coverage", product.getName());
    }

    @Test
    @DisplayName("updatePrice | sellIn should not change")
    void updatePriceSellInShouldNotChange() {
        final int initialSellIn = 0;

        final MegaCoverage product = new MegaCoverage(initialSellIn);

        product.updatePrice();

        assertEquals(initialSellIn, product.getSellIn());
    }

    @Test
    @DisplayName("updatePrice | Price should be 80")
    void updatePricePriceShouldBe80() {
        final MegaCoverage product = new MegaCoverage(0);

        product.updatePrice();

        assertEquals(80, product.getPrice());
    }
}
