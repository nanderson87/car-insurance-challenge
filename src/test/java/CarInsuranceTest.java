import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Car Insurance Test | Unit")
public class CarInsuranceTest {
    private static final String NORMAL_PRODUCT_NAME = "Normal Product";
    private static final String FULL_COVERAGE_NAME = "Full Coverage";
    private static final String MEGA_COVERAGE_NAME = "Mega Coverage";
    private static final String SPECIAL_FULL_COVERAGE_NAME = "Special Full Coverage";
    private static final String SUPER_SALE_NAME = "Super Sale";

    @Test
    @DisplayName("updatePrice | Normal Product | Price cannot become negative")
    void updatePriceMediumCoverageThePriceCannotBecomeNegative() {
        final Product normalProductWithZeroPrice = new Product(NORMAL_PRODUCT_NAME, 10, 0);

        List<Product> products = Arrays.asList(normalProductWithZeroPrice);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(0, result.get(0).price);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {30, 10, 1})
    @DisplayName("updatePrice | Normal Product | Price should decrease one unit if there are still days to sell it")
    void updatePriceMediumCoveragePriceDecreaseOneUnit(final int sellIn) {
        final int price = 10;
        final Product normalProductWithDaysToSell = new Product(NORMAL_PRODUCT_NAME, sellIn, price);

        List<Product> products = Arrays.asList(normalProductWithDaysToSell);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(price - 1, result.get(0).price);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {0, -1, -10})
    @DisplayName("updatePrice | Medium Coverage | Price should decrease two units if there are no longer days to sell it")
    void updatePriceMediumCoveragePriceDecreaseTwoUnits(final int sellIn) {
        final int price = 8;
        final Product normalProductWithoutDaysToSell = new Product(NORMAL_PRODUCT_NAME, sellIn, price);

        List<Product> products = Arrays.asList(normalProductWithoutDaysToSell);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(price - 2, result.get(0).price);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {30, 10, 1})
    @DisplayName("updatePrice | Full Coverage | Price should increase one unit if there are still days to sell it")
    void updatePriceFullCoveragePriceIncreaseOneUnit(final int sellIn) {
        final int price = 20;
        final Product fullCoverageWithDaysToSell = new Product(FULL_COVERAGE_NAME, sellIn, price);

        List<Product> products = Arrays.asList(fullCoverageWithDaysToSell);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(price + 1, result.get(0).price);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {0, -2, -20})
    @DisplayName("updatePrice | Full Coverage | Price should increase two units if there are no longer days to sell it")
    void updatePriceFullCoveragePriceIncreaseTwoUnits(final int sellIn) {
        final int price = 18;
        final Product fullCoverageWithoutDaysToSell = new Product(FULL_COVERAGE_NAME, sellIn, price);

        List<Product> products = Arrays.asList(fullCoverageWithoutDaysToSell);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(price + 2, result.get(0).price);
    }

    @Test
    @DisplayName("updatePrice | Full Coverage | price does not exceed 50")
    void updatePriceFullCoveragePriceDoesNotExceed50() {
        final int limitPrice50 = 50;
        final Product fullCoverageWithPrice50 = new Product(FULL_COVERAGE_NAME, 10, limitPrice50);

        List<Product> products = Arrays.asList(fullCoverageWithPrice50);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();
        assertEquals(limitPrice50, result.get(0).price);
    }

    @Test
    @DisplayName("updatePrice | Mega Coverage | price should not change")
    void updatePriceMegaCoveragePriceShouldNotChange() {
        final int price = 80;
        final Product megaCoverage = new Product(MEGA_COVERAGE_NAME, 0, price);

        List<Product> products = Arrays.asList(megaCoverage);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();
        assertEquals(price, result.get(0).price);
    }

    @Test
    @DisplayName("updatePrice | Mega Coverage | sell in should not change")
    void updatePriceMegaCoverageSellInShouldNotChange() {
        final int sellIn = 0;
        final Product megaCoverage = new Product(MEGA_COVERAGE_NAME, 0, 80);

        List<Product> products = Arrays.asList(megaCoverage);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(sellIn, result.get(0).sellIn);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {10, 9, 8, 7, 6})
    @DisplayName("updatePrice | Special Full Coverage | price should increase by 2 when there are between 10 and 6 days to sell it")
    void updatePriceSpecialFullCoverageShouldIncreaseBy2(int sellIn) {
        final int price = 20;
        final Product specialFullCoverage = new Product(SPECIAL_FULL_COVERAGE_NAME, sellIn, price);

        List<Product> products = Arrays.asList(specialFullCoverage);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(price + 2, result.get(0).price);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {5, 4, 3, 2, 1})
    @DisplayName("updatePrice | Special Full Coverage | price should increase by 3 when there are between 5 and 1 days to sell it")
    void updatePriceSpecialFullCoverageShouldIncreaseBy3(int sellIn) {
        final int price = 20;
        final Product specialFullCoverage = new Product(SPECIAL_FULL_COVERAGE_NAME, sellIn, price);

        List<Product> products = Arrays.asList(specialFullCoverage);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(price + 3, result.get(0).price);
    }

    @Test
    @DisplayName("updatePrice | Special Full Coverage | price should drops to 0 when no more days left")
    void updatePriceSpecialFullCoveragePriceShouldDropsIncreaseBy3() {
        final int price = 20;
        final Product specialFullCoverage = new Product(SPECIAL_FULL_COVERAGE_NAME, 0, price);

        List<Product> products = Arrays.asList(specialFullCoverage);
        final CarInsurance carInsurance = new CarInsurance(products);

        List<Product> result = carInsurance.updatePrice();

        assertEquals(0, result.get(0).price);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {20, 10, 1})
    @DisplayName("updatePrice | Super Sale | Price should decrease two unit if there are still days to sell it")
    void updatePriceSuperSalePriceDecreaseTwoUnits(final int sellIn) {
        final int price = 20;
        final Product superSaleWithDaysToSell = new Product(SUPER_SALE_NAME, sellIn, price);

        List<Product> products = Arrays.asList(superSaleWithDaysToSell);
        final CarInsurance carInsurance = new CarInsurance(products);


        List<Product> result = carInsurance.updatePrice();

        assertEquals(price - 2, result.get(0).price);
    }

    @ParameterizedTest(name = "sell in {0}")
    @ValueSource(ints = {0, -1, -10})
    @DisplayName("updatePrice | Super Sale | Price should decrease four units if there are no longer days to sell it")
    void updatePriceSuperSalePriceDecreaseFourUnits(final int sellIn) {
        final int price = 20;
        final Product superSaleWithoutDaysToSell = new Product(SUPER_SALE_NAME, sellIn, price);

        List<Product> products = Arrays.asList(superSaleWithoutDaysToSell);
        final CarInsurance carInsurance = new CarInsurance(products);


        List<Product> result = carInsurance.updatePrice();

        assertEquals(price - 4, result.get(0).price);
    }
}
