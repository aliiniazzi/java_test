import org.junit.jupiter.api.*;

public class ParameterResolverTest {

    @Test
    @DisplayName("should Inject TestInfo parameter and show details from test method")
    void shouldInjectTestInfo(TestInfo testInfo){
        System.out.println("Display name : " + testInfo.getDisplayName());
        Assertions.assertNotNull(testInfo);
    }

    @Test
    void shouldInjectTestReporterAndShouldReportOperationStatus(TestReporter testReporter){
        // Start report
        testReporter.publishEntry("status", "test started successfully");

        // Given
        MathOperation mathOperation = new MathOperation();
        double numberOne = 10;
        double numberTwo = 5;

        // When
        double result = mathOperation.add(numberOne, numberTwo);

        // report from process
        testReporter.publishEntry("operation" , "addition");
        testReporter.publishEntry("input", numberOne + " + " + numberTwo);
        testReporter.publishEntry("result", String.valueOf(result));

        // Then
        Assertions.assertEquals(15 , result , "Addition result should be correct");

        // Final Report
        testReporter.publishEntry("status", "Test completed successfully");
    }

}
