package stepdef;


import commons.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.List;

public class MyStepdefs extends BaseTest{
    private WebDriver myDriver;
    public CommonLib commonLib;


    

    @Before
    public void setup() {

        commonLib = new CommonLib(MyDriver.getMyDriver());

    }


    @When("I see {string} page")
    public void seePage(String page) throws IOException, ParseException {
        commonLib.seePage(page);
    }

    @When("I go to url:{string}")
    public void navigateURL(String url) {
        commonLib.ıGoToUrl(url);
    }

    @When("I send key to {string} element text:{string}")
    public void sendKey(String element, String text) {
        commonLib.sendKeys(element, text);
    }

    @When("I click to {string} element")
    public void clickElement(String element) {
        commonLib.clickElement(element);
    }

    @When("I wait until element to be clickable and click to {string} element")
    public void clickElementWaitUntilClickable(String element) {
        commonLib.clickElementWaitUntilClickable(element);
    }

    @When("I wait {string} element")
    public void waitElement(String element) {
        commonLib.waitElement(element);
    }

    @When("^I click (enter|tab) element:(.*)$")
    public void clickKeyboard(String key, String element) {
        commonLib.clickKeyboard(element, key);
    }

    @When("I wait {string} element and check visibility")
    public void waitElementAndCheckVisibility(String element) {
        commonLib.waitElementAndCheckVisibility(element);
    }

    @When("I sleep for {int} seconds")
    public void sleep(int sec) throws InterruptedException {
        commonLib.sleep(sec);
    }


    @Then("I wait {string} elements")
    public void ıWaitElements(String elements) {
        String[] elemetsArray = elements.split(";");
        for (String element : elemetsArray) {
            waitElementAndCheckVisibility(element);
        }
    }

    @Then("I check {string} element text is equal {string}")
    public void ıCheckElementTextIsLike(String element, String text) {
       // commonLib.saveElementToGlobalVariables("username",text);
        while (text.contains("$")) {

            text = text.replace(text.substring(text.indexOf('$'), text.indexOf("}") + 1), commonLib.getElementFromGlobalVariables(text.substring(text.indexOf('$')+2, text.indexOf("}"))));

        }

        WebElement webElement = commonLib.waitElementAndCheckVisibilityAndReturnElement(element);
        String s=webElement.getText();
        if (webElement.getText().equalsIgnoreCase(text)) {
            commonLib.allureReport(StepResultType.PASS, "texts are equal", true);
        }
        else{
            commonLib.allureReport(StepResultType.FAIL, "texts are not equal", true);
        }
    }


    @Then("I scroll down until find {string} element")
    public void ıScrollDownUntilFindElement(String element) {
        //Locating element by link text and store in variable "Element"
        WebElement webElement = commonLib.myDriver.findElement(commonLib.getElementLocator(element));
        JavascriptExecutor js = (JavascriptExecutor) commonLib.myDriver;
        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    @Then("I check alert text is equals {string}")
    public void ıCheckAlertTextIsEquals(String text) {
      commonLib.ıCheckAlertTextIsEquals(text);

    }

    @Then("I accept alert")
    public void ıAcceptAlert() {
        commonLib.myDriver.switchTo().alert().accept();
    }

    @Then("I send key to {string} element text:{string} with jsexecutor")
    public void ıSendKeyToElementTextWithJsexecutor(String text, String elementid) {
        commonLib.ıSendKeyToElementTextWithJsexecutor(text,elementid);
    }

    @Then("I delete items on cart")
    public void ıDeleteItemsOnCart() throws IOException, ParseException {
        commonLib.ıDeleteItemsOnCart();
    }

    @Then("I check element text is equal {string} with query selector {string}")
    public void ıCheckElementTextIsEqualWithQuerySelectorTbodyidH(String arg0, String arg1) {
        commonLib.ıCheckElementTextIsEqualWithQuerySelector(arg0,arg1);
    }

    @Given("I create a username that is start with {string} and end with number {int} between {int} then save username to globalvariables as a {string} and then sign up")
    public void ıCreateAUsernameThatIsAndEndwithNumberBetweenThenSaveUsernameToGlobalvariablesAsAAndThenSignUp(String startWith, int arg1, int arg2, String username) throws InterruptedException {
        commonLib.ıCreateAUsernameThatIsAndEndwithNumberBetweenThenSaveUsernameToGlobalvariablesAsAAndThenSignUp(startWith,arg1,arg2,username);
    }

    @Given("I create a adress that is start {string} and end with number {int} between {int}")
    public void ıCreateAAdressThatIsStartAndEndWithNumberBetween(String startWith, int arg1, int arg2) throws InterruptedException {
        commonLib.ıCreateAAdressThatIsStartAndEndWithNumberBetween(startWith,arg1,arg2);
    }



    @Then("I choose city {string} from list")
    public void ıChooseCityFromList(String City) {
        commonLib.ıChooseCityFromList(City);
    }

    @Then("I choose town {string} from list")
    public void ıChooseTownFromList(String Town) {
         commonLib.ıChooseTownFromList(Town);
    }

    @Then("I choose neighborhood {string} from list")
    public void ıChooseNeighborhoodFromList(String Neighborhood) {
        commonLib.ıChooseNeighborhoodFromList(Neighborhood);
    }

    @Then("I choose taxCity {string} from list")
    public void ıChooseTaxCityFromList(String TaxCity) {
        commonLib.ıChooseTaxCityFromList(TaxCity);
    }

    @Then("I clear {string} textbox")
    public void ıClearTextbox(String arg0) {
        commonLib.ıClearTextbox(arg0);
    }


    @Then("I send key to {string} element random {string}")
    public void ıSendKeyToElementRandom(String locater, String keys) {
        commonLib.ıSendKeyToElementRandom(locater,keys);
    }

    @Then("I scroll and click to {string} element with Javascript")
    public void ıScrollAndClickToElementWithJavascript(String element) {
        commonLib.ıScrollAndClickToElementWithJavascript(element);
    }


    @And("I delete saved adress")
    public void ıDeleteSavedAdress() throws IOException, ParseException, InterruptedException {
        commonLib.ıDeleteSavedAdress();
    }


    @And("I scroll until find {string} element with action")
    public void ıScrollUntilFindElementWithAction(String element)  {
        commonLib.ıScrollUntilFindElementWithAction(element);
    }

    @And("I wait load the page")
    public void ıWaitLoadThePage() {
        commonLib.clickElementWaitUntilClickable2("enis");
    }

    @And("I accept on bilgilendirme and satis sozlesmesi")
    public void ıAcceptOnBilgilendirmeAndSatisSozlesmesi() throws IOException, ParseException {
        commonLib.ıAcceptOnBilgilendirmeAndSatisSozlesmesi();
    }

    @Then("I choose city {string} from list for click and collect")
    public void ıChooseCityFromListForClickAndCollect(String City) {
        commonLib.ıChooseCityFromListForClickAndCollect(City);
    }

    @Then("I choose town {string} from list for click and collect")
    public void ıChooseTownFromListForClickAndCollect(String town) {
        commonLib.ıChooseTownFromListForClickAndCollect(town);
    }

    @Then("I wait until element to be clickable and click to {string} element if element exist:{int}")
    public void ıWaitUntilElementToBeClickableAndClickToElementIfElementExist(String element, int timeout) {
        commonLib.ıWaitUntilElementToBeClickableAndClickToElementIfElementExist(element,timeout);
    }

    @And("I create a mail that is start {string} and end with {string}")
    public void ıCreateAMailThatIsStartAndEndWith(String kullaniciAdi, String uzanti) {
        commonLib.ıCreateAMailThatIsStartAndEndWith(kullaniciAdi,uzanti);
    }

    @And("I change the frame")
    public void ıChangeTheFrame() {
    commonLib.ıChangeTheFrame();
    }

    @And("I click {string} element")
    public void ıClickElement(String element) {
        commonLib.ıClickElement(element);

    }

    @When("I click {string} element and save the file {string}")
    public void ıClickElementAndSaveTheFile(String arg0, String arg1) throws InterruptedException {
        commonLib.ıClickElementAndSaveTheFile(arg0, arg1);
    }

    @When("broken links check")
    public void brokenLinksCheck() {

    }

    @When("broken links check {string} categories and {string} file names")
    public void brokenLinksCheckCategoriesAndFileNames(String kategori, String dosyaAdi) {
        //commonLib.brokenLinksCheckCategoriesAndFileNames(kategori,dosyaAdi);
    }

    @Then("I login with {string} and {string}")
    public void ıLoginWithAnd(String arg0, String arg1) {
        commonLib.ıLoginWithAnd(arg0, arg1);
    }

    @When("I go to {string} with configuration")
    public void ıGoToWithConfiguration(String arg0) {
        commonLib.ıGoToWithConfiguration(arg0);
    }

    @Then("I login with {string} and {string} canli")
    public void ıLoginWithAndCanli(String arg0, String arg1) {
        commonLib.ıLoginWithAndCanli(arg0, arg1);
    }

    @And("I hover {string} header and click {string} category")
    public void ıHoverHeaderAndClickCategory(String header, String category) throws IOException, ParseException {
        commonLib.ıHoverHeaderAndClickCategory(header, category);
    }

    @And("I hover {string} header and click {string} category with string")
    public void ıHoverHeaderAndClickCategoryWithString(String arg0, String arg1) {
    }

    @Then("I choose city {string} and town {string} from fast delivery list")
    public void ıChooseCityAndTownFromFastDeliveryList(String il, String ilce) {
        commonLib.ıChooseCityAndTownFromFastDeliveryList(il, ilce);
    }
    private WebDriver driver;
    private List<String> allLinks;
    private List<String> brokenLinks;

    @Given("I am on the homepage")
    public void ıAmOnTheHomepage() {
        commonLib.ıAmOnTheHomepage();
    }

    @When("I collect all links from the website")
    public void ıCollectAllLinksFromTheWebsite() {
        commonLib.ıCollectAllLinksFromTheWebsite();
    }

    @And("I check each link for {int} errors")
    public void ıCheckEachLinkForErrors(int arg0) {
        commonLib.ıCheckEachLinkForErrors(arg0);
    }

    @Then("I should see a report of links with {int} errors")
    public void ıShouldSeeAReportOfLinksWithErrors(int arg0) {
        commonLib.ıShouldSeeAReportOfLinksWithErrors(arg0);

    }

    @And("I approved {string} KVKK")
    public void ıApprovedKVKK(String arg0) {
    }

    @Then("I check element count is equal {string} with xpath {string}")
    public void ıCheckElementCountIsEqualWithXpath(String arg0, String arg1) {
        commonLib.ıCheckElementCountIsEqualWithXpath(arg0, arg1);
    }


    @Then("I check element count is greater than {string} with xpath {string}")
    public void ıCheckElementCountIsGreaterThanWithXpath(String arg0, String arg1) {
        commonLib.ıCheckElementCountIsGreaterThanWithXpath(arg0, arg1);
    }

    @And("I switch to window")
    public void ıSwitchToWindow() {
        commonLib.switchToNewTabAndVerifyTitle();
    }
}
