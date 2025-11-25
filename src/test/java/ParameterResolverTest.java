import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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


    @Test
    void shouldCreateTempDirectory(@TempDir Path tempDir) throws IOException {
        // Given
        MathOperation math = new MathOperation();
        double numberOne = 10;
        double numberTwo = 5;


        // When
        double result = math.add(numberOne, numberTwo);
        Path outFile = tempDir.resolve("result.txt");
        File resultFile = outFile.toFile();

        try (FileOutputStream fos = new FileOutputStream(resultFile)){
            String text = "Result = " + result;
            fos.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Then
        Assertions.assertTrue(Files.exists(outFile));
        String expected = "Result = 15.0";
        String actual = new String(Files.readAllBytes(outFile) , StandardCharsets.UTF_8);

        Assertions.assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void randomNumberShouldBeBetween10And100(RepetitionInfo info){

        // Given
        double min = 10;
        double max = 100;

        // When
        double result = min + Math.random() * (max - min);


        // Then
        Assertions.assertTrue(result > min && result < max);

        // log with RepetitionInfo for each repetition
        System.out.println(info.getCurrentRepetition() + " of " + info.getTotalRepetitions() + " -> " + result);

    }


    @ParameterizedTest
    @CsvSource({"2 , 2 , 4" , "5 , 10 , 15" , "5 , 7 , 12"})
    void testAdditionWithCsv(double numberOne , double numberTwo , double expected){
        // Given
        MathOperation mathOperation = new MathOperation();

        // When
        double actual = mathOperation.add(numberOne , numberTwo);

        // Then
        Assertions.assertEquals(expected , actual);
    }


}
