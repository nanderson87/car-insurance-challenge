import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import products.MegaCoverage;
import products.NormalProduct;
import products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Car Insurance Test | Unit")
public class CarInsuranceTest {

    @Test
    @DisplayName("updatePrice | EmptyList")
    void updateEmptyList() {
        List<Product> withoutProducts = new ArrayList<>();
        CarInsurance carInsurance = new CarInsurance(withoutProducts);

        List<Product> result = carInsurance.updatePrice();

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("updatePrice | Should modify the products")
    void updatePriceShouldModifyTheProducts() {
        final NormalProduct oneProduct = mock(NormalProduct.class);
        final MegaCoverage otherProduct = mock(MegaCoverage.class);

        CarInsurance carInsurance = new CarInsurance(Arrays.asList(oneProduct, otherProduct));
        List<Product> result = carInsurance.updatePrice();

        assertEquals(2, result.size());
        verify(oneProduct, times(1)).updatePrice();
        verify(otherProduct, times(1)).updatePrice();
    }
}
