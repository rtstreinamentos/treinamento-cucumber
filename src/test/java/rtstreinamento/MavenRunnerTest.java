package rtstreinamento;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features="src/test/features",
			format = {
					"pretty", 
					"html:target/cucumber", 
					"json:target/cucumber/cucumber.json"
			}
		)
public class MavenRunnerTest {

}
