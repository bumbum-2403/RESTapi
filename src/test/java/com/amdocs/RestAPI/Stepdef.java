package com.amdocs.RestAPI;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT, classes=RestApiApplication.class)
public class Stepdef {
	String url;
	Double result;
	
	@Given("a Rest Api {string}")
	public void a_Rest_Api(String url) {
		this.url=url;
	    
	}

	@When("invoking the rest API")
	public void invoking_the_rest_API() {
	    RestTemplate restTemplate=new RestTemplate();
	    result=restTemplate.getForObject(url, Double.class);
		
	}

	@Then("give result as {double}")
	public void give_result_as(Double expected) {
	    assertEquals(expected,result,0.01);
	}


}
