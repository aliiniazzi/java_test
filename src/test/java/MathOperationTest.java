import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathOperationTest {


    private double numberOne = 10;
    private double numberTwo = 5;
    private MathOperation mathOperation;

    @BeforeAll
    void setup() {
        mathOperation = new MathOperation();
    }


    @Nested
    class AddSubTest {

        @Test
        void shouldAddNumbersCorrectly() {
            // When
            double addResult = mathOperation.add(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(15 , addResult);
        }

        @Test
        void shouldSubtractNumbersCorrectly(){
            // When
            double subtractionResult = mathOperation.subtraction(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(5 , subtractionResult);
        }
    }

    @Nested
    class MulDivTests{

        @Test
        void shouldMultiplyNumbersCorrectly() {
            // When
            double multiplyResult = mathOperation.multiply(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(50 , multiplyResult);
        }

        @Test
        void shouldDivideNumbersCorrectly(){
            // When
            double divideResult = mathOperation.divide(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(2 , divideResult);
        }

        @Test
        void shouldThrowArithmeticExceptionWhenDivideByZero(){
            // When + Then
            Assertions.assertThrows(ArithmeticException.class , () -> {
                mathOperation.divide(numberOne , 0);
            });
        }
    }





}
