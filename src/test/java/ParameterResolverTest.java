import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ParameterResolverTest {

    @Test
    @DisplayName("should Inject TestInfo parameter and show details from test method")
    void shouldInjectTestInfo(TestInfo testInfo){
        System.out.println("Display name : " + testInfo.getDisplayName());
        Assertions.assertNotNull(testInfo);
    }

}
