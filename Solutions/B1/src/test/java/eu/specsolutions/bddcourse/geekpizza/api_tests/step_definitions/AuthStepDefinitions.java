package eu.specsolutions.bddcourse.geekpizza.api_tests.step_definitions;

import io.cucumber.java.en.Given;
import eu.specsolutions.bddcourse.geekpizza.dto.LoginRequestDto;
import eu.specsolutions.bddcourse.geekpizza.api_tests.support.WebApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthStepDefinitions {

    @Autowired
    private WebApiContext webApiContext;

    @Given("the client is logged in")
    public void theClientIsLoggedIn() {
        // prepare JSON payload data
        LoginRequestDto loginRequestDto = new LoginRequestDto("Marvin", "1234");
        // execute request
        HttpStatus statusCode = webApiContext.executePost("/api/auth", loginRequestDto);
        // functional check
        assertEquals(HttpStatus.OK, statusCode);
    }
}
