package parallel;

import com.pages.InventoryPage;
import com.pages.SauceLabLoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SauceLabStepdef {
    private static String title;
    private SauceLabLoginPage loginPage = new SauceLabLoginPage(DriverFactory.getDriver());
    private InventoryPage inventoryPage;

    @Given("user has already logged in to sauceApplication")
    public void user_has_already_logged_in_to_sauceApplication(DataTable credTable) {

        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver()
                .get("https://www.saucedemo.com/");
        inventoryPage = loginPage.loginSauceApp(userName, password);

    }
    @Given("user is on Inventory page")
    public void user_is_on_inventory_page() {
        String title = inventoryPage.getAccountsPageTitle();
        System.out.println("Accounts Page title is: " + title);
    }
    @When("user gets the title of the SauceLabPage")
    public void user_gets_the_title_of_the_sauceLabpage() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("SauceLabPage title should be {string}")
    public void sauceLabpage_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

}
