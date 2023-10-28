package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/BookingTravel.feature",
        glue = "com.space.and.beyond.test.steps",
        plugin = {"pretty", "html:target/cucumber", "json:target/result.json"}
)
public class BookingRunner {
}
