
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepdefs.ProjectSpecificMethods;

@CucumberOptions(features = "src/test/java/features",
				  glue = "stepdefs",
				  monochrome = true,
				  publish = true)
public class RunCucumberTests extends ProjectSpecificMethods{

}
 
