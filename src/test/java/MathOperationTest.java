import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathOperationTest {
    @Test
    void ShouldThrowZeroException(){
        // Given
        int numberOne = 24;
        int numberTwo = 0;

        // When
        // ! int result = numberOne / numberTwo;

        // When + Then
        Assertions.assertThrows(ArithmeticException.class , () -> {
            int result = numberOne / numberTwo;
        });
    }
}
