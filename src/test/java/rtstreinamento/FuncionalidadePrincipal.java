package rtstreinamento;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features="src/test/features",
			tags="@funcionalidade-principal"
		)
public class FuncionalidadePrincipal {

}
