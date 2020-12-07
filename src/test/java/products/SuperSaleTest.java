package products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Super Sale Test | Unit")
public class SuperSaleTest {

    @Test
    @DisplayName("Name should be Super Sale")
    void nameShouldBeFullCoverage() {
        final SuperSale product = new SuperSale(10, 10);

        assertEquals("Super Sale", product.getName());
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {10, 0, -10})
    @DisplayName("updatePrice | Price should degrade twice as fast as normal Product")
    void updatePricePriceShouldDegradeTwiceAsFastAsNormalProduct(final int sellInt) {
        final int initialPrice = 10;

        NormalProduct normalProduct = new NormalProduct("Normal Product", sellInt, initialPrice);
        SuperSale superSale = new SuperSale(sellInt, initialPrice);

        normalProduct.updatePrice();
        superSale.updatePrice();

        final int variationNormalProduct = initialPrice - normalProduct.getPrice();
        final int variationSuperSale = initialPrice - superSale.getPrice();

        assertEquals(variationNormalProduct * 2, variationSuperSale);
    }
}
