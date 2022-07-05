package eu.specsolutions.bddcourse.geekpizza.api_tests.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import eu.specsolutions.bddcourse.geekpizza.dto.OrderDetailsPageModelDto;
import eu.specsolutions.bddcourse.geekpizza.model.Order;
import eu.specsolutions.bddcourse.geekpizza.api_tests.support.WebApiContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDetailsStepDefinitions {

    @Autowired
    private WebApiContext webApiContext;

    @When("the client specifies {date} at {time} as delivery time")
    public void theClientSpecifiesDateAtTimeAsDeliveryTime(LocalDate date, LocalTime time) {
        OrderDetailsPageModelDto pageModelDto = new OrderDetailsPageModelDto();
        pageModelDto.setDeliveryDate(date);
        pageModelDto.setDeliveryTime(time);
        webApiContext.executePut("/api/order", pageModelDto);
    }

    @Then("the order should indicate that the delivery date is {date}")
    public void theOrderShouldIndicateThatTheDeliveryDateIsDate(LocalDate expectedDate) {
        Order myOrderResponse = webApiContext.executeGet("/api/order", Order.class);
        assertEquals(expectedDate, myOrderResponse.getDeliveryDate());
    }

    @Then("the delivery time should be {time}")
    public void theDeliveryTimeShouldBe(LocalTime expectedTime) {
        Order myOrderResponse = webApiContext.executeGet("/api/order", Order.class);
        assertEquals(expectedTime, myOrderResponse.getDeliveryTime());
    }
}
