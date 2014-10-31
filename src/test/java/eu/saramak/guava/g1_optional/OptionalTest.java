package eu.saramak.guava.g1_optional;

import static org.fest.assertions.api.Assertions.assertThat;
import static tumbler.Tumbler.Given;
import static tumbler.Tumbler.Then;
import static tumbler.Tumbler.When;

import org.junit.runner.RunWith;

import tumbler.Scenario;
import tumbler.Story;
import tumbler.TumblerRunner;
import eu.saramak.guava.test.*;

import com.google.common.base.Optional;
@RunWith(TumblerRunner.class)
@Story("Programmer should avoid NPE checking")
public class OptionalTest {

	@Scenario("Programmer should always test external lib")
	public void shouldCheckExternelLibVersion() {
		Given("A external api with method which can return null");
		NullApi api = new NullApi();
		When("Checking api version");
		String result = api.getVersion();
		String vers = "";
		if (result != null) {
			vers = result.toLowerCase();
		}
		assertThat(vers).isNotNull();
		Then("Api version should be not null");
	}
	@Scenario("Programmer should always test external lib with wrong optional")
	public void shouldCheckExternelLibVersionInfo() {
		Given("A external api with method which can not return null");
		OptionalApi api = new OptionalApi();
		When("Checking api version");
		Optional<String> result = api.getVersion();
		String version = "";
		if (result.isPresent()) {
			version = result.get().toLowerCase();
		}
		assertThat(version).isNotNull();
		Then("Api version should be not null => " + version);
	}
	
	@Scenario("Programmer should always test external lib with optional ")
	public void shouldCheckExternelLibVersionBuild() {
		Given("A external api ");
		OptionalApi api = new OptionalApi();
		When("Checking api version");
		Optional<String> result = api.getVersion();
		String version = result.or("");
		Then("Api version should not be null => " + version);
		assertThat(version).isNotNull();
	}
	
	@Scenario("should check optional api methods ")
	public void shouldShowOptionalApi() {
		Given("Api with return null");
		NullApi api  =  new NullApi();
		When("Use api method");
		Optional<String> result = Optional.<String>fromNullable(api.getVersion());
		Optional<String> result2 = Optional.<String>of("1.2R");
//		Optional<String> result3 = Optional.<String>of(null);
		Optional<String> result4 = Optional.<String>absent();
		result.orNull();
		Then("we know what use or not use ");
	}

}
