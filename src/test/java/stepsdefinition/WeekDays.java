package stepsdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WeekDays {
    private String day;
    private String answer;

    @Given("today is {string}")
    public void todayIs(String day) {
        this.day = day;
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        answer = isFriday();
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String answer) {
        Assert.assertEquals(answer, this.answer);
    }

    private String isFriday(){
        if (day.equals("Friday")) return "Yes";
        return "No";
    }
}
