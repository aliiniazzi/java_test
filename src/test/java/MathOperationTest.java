import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathOperationTest {

    MathOperation mathOperation;

    @BeforeAll
    void setup(){
        mathOperation = new MathOperation();
    }

    // without instance
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

    // with instance
    @Test
    void shouldCalculateBasicOperationsCorrectly(){

        // Given
        double numberOne = 10;
        double numberTwo = 5;

        // When
        double addResult = mathOperation.add(numberOne , numberTwo);
        double subtractionResult = mathOperation.subtraction(numberOne , numberTwo);
        double multiplyResult = mathOperation.multiply(numberOne , numberTwo);
        double divideResult = mathOperation.divide(numberOne , numberTwo);


        // Then
        Assertions.assertAll(
                () -> Assertions.assertEquals(15 , addResult),
                () -> Assertions.assertEquals(5 , subtractionResult),
                () -> Assertions.assertEquals(50 , multiplyResult),
                () -> Assertions.assertEquals(2 , divideResult)
        );
    }



}
