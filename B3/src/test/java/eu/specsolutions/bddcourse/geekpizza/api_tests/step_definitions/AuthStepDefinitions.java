package eu.specsolutions.bddcourse.geekpizza.api_tests.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import eu.specsolutions.bddcourse.geekpizza.dto.LoginRequestDto;
import eu.specsolutions.bddcourse.geekpizza.api_tests.support.ApiAuthContext;
import eu.specsolutions.bddcourse.geekpizza.api_tests.support.WebApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthStepDefinitions {

    @Autowired
    private WebApiContext webApiContext;
    @Autowired
    private ApiAuthContext authContext;

    @Given("the client is logged in")
    public void theClientIsLoggedIn() {
        String defaultUserName = "Marvin";
        // prepare JSON payload data
        LoginRequestDto loginRequestDto = new LoginRequestDto(defaultUserName, "1234");
        // execute request
        HttpStatus statusCode = webApiContext.executePost("/api/auth", loginRequestDto);
        // functional check
        assertEquals(HttpStatus.OK, statusCode);
        authContext.setLoggedInUserName(defaultUserName);
    }

    @Given("the client is logged in with user name {string} and password {string}")
    public void theClientIsLoggedInWithUserNameFordAndPassword(String userName, String password) {

        //TODO: the code duplication will be eliminated in a later exercise

        // prepare JSON payload data
        LoginRequestDto loginRequestDto = new LoginRequestDto(userName, password);
        // execute request
        HttpStatus statusCode = webApiContext.executePost("/api/auth", loginRequestDto);
        // functional check
        assertEquals(HttpStatus.OK, statusCode);
        authContext.setLoggedInUserName(userName);
    }
}
