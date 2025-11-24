import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathOperationTest {


    private final double numberOne = 10;
    private final double numberTwo = 5;
    private MathOperation mathOperation;

    @BeforeAll
    void setup() {
        mathOperation = new MathOperation();
    }


    @TestInstance(TestInstance.Lifecycle.PER_CLASS) // one creation object for all test
    @DisplayName("addition and subtraction operation tests from MathOperation_Object")
    @Nested
    class AddSubTest {

        // ! with default lifecycle this constructor was executed for each test (2times)
        AddSubTest(){
            System.out.println("from AddSubTestConstructor");
        }



        @Test
        @DisplayName("Should correctly add two numbers")
        void shouldAddNumbersCorrectly() {
            // When
            double addResult = mathOperation.add(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(15, addResult);
        }

        @Test
        void shouldSubtractNumbersCorrectly() {
            // When
            double subtractionResult = mathOperation.subtraction(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(5, subtractionResult);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS) // one creation object for all test
    @DisplayName("Multiplication and Division operation tests from MathOperation_Object")
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    @Nested
    class MulDivTests {

        @Test
        void shouldMultiplyNumbersCorrectly() {
            // When
            double multiplyResult = mathOperation.multiply(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(50, multiplyResult);
        }

        @Test
        void should_Divide_Numbers_Correctly() {
            // When
            double divideResult = mathOperation.divide(numberOne, numberTwo);

            // Then
            Assertions.assertEquals(2, divideResult);
        }


        @Test
        void divide_Result_Should_Be_Greater_Than_Zero_When_Numbers_Are_Positive(){
            // When
            double divideResult = mathOperation.divide(numberOne, numberTwo);

            // Then
            Assertions.assertTrue(divideResult > 0 , "result should be greater than zero") ;
        }

        @Test
        @DisplayName("Should throw ArithmeticException when dividing by zero")
        void shouldThrowArithmeticExceptionWhenDivideByZero() {
            // When + Then
            Assertions.assertThrows(ArithmeticException.class, () -> mathOperation.divide(numberOne, 0),
                    "Division by zero should throw ArithmeticException");
        }
    }

    @Nested
    @DisplayName("modulus and cosine operation tests from MathOperation_Object")
    @Disabled("modulus and cosine operation not implemented yet")
    class AdvanceOperationTest{

        @Test
        void shouldReturnRemainder(){
            Assertions.assertEquals(0 , mathOperation.modulus(numberOne , numberTwo));
        }
    }

    @Test
    void calculateAllShouldReturnCorrectArray(){
        // When
        double[] actual = mathOperation.calculateAll(numberOne , numberTwo);
        double[] expected  = {15 , 5 , 50 , 2};

        // Then
        Assertions.assertArrayEquals(expected , actual);
    }


}
