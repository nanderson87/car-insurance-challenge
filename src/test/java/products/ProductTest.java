package products;

import exceptions.InvalidProductStateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Product Test | Unit")
public class ProductTest {

    @Test
    @DisplayName("initialization | Throw InvalidProductStateException | When price less than zero")
    void initializationThrowInvalidProductStateExceptionZeroPrice() {
        final int negativePrice = -10;

        InvalidProductStateException exception = assertThrows(InvalidProductStateException.class, () ->
                new ProductForTest("product", 0, negativePrice)
        );
        assertEquals(String.format("Product cannot be negatively priced %s", negativePrice), exception.getMessage());
    }

    final static class ProductForTest extends Product {

        public ProductForTest(String name, int sellIn, int price) {
            super(name, sellIn, price);
        }

        @Override
        protected int calculateNewPrice() {
            return 0;
        }

        @Override
        protected void updateSellIn() {
            return;
        }

        @Override
        protected void validateSpecificProductPrice(int price) {
            return;
        }
    }
}
