package StepDefs;

import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class buyAProductSteps {

    WebDriver driver;
    static final int WAIT_TIME = 10;

    HeaderComponent headerComponent;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    FooterComponent footerComponent;
    NewProductsPage newProductsPage;
    BlousePage blousePage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;
    int numberOfProductsBeforeAddingToCart;
    int numberOfProductsAfterAddingToCart;
    MyOrderAddressPage myOrderAddressPage;
    ShippingDetailsPage shippingDetailsPage;
    PaymentPage paymentPage;
    ChequePaymentPage chequePaymentPage;
    OrderConfirmationPage orderConfirmationPage;
    String orderRef;
    OrderHistoryPage orderHistoryPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
    }

    @Given("The user has navigated to {string}")
    public void navigateToURL(String url) {
        driver.get(url);
    }

    @And("has logged in with email as {string} and password as {string}")
    public void login(String email, String password){
        headerComponent = PageFactory.initElements(driver, HeaderComponent.class);
        signInPage = headerComponent.clickSignInLink();
        myAccountPage = signInPage.signIn(email, password);
    }

    @Then("There is a saved address under My account -> My addresses")
    public void verifySavedAddressPresent() {
        Assert.assertTrue(myAccountPage.checkAddressPresent());
    }

    @Given("The user clicks on New products in the footer menu")
    public void clickLinkInFooter() {
        footerComponent = PageFactory.initElements(driver, FooterComponent.class);
        newProductsPage = footerComponent.navigateToNewProductsPage();
    }

    @And("the user clicks on Blouse")
    public void clickBlouseLink() {
        blousePage = newProductsPage.clickBlouseLink();
    }

    @And("in the right hand pane, the user selects {string} under colour")
    public void selectColour(String productColour) {
        blousePage.chooseColour(productColour);
    }

    @And("adds to cart")
    public void addToCart() {
        numberOfProductsBeforeAddingToCart = headerComponent.checkNumberInCart();
        blousePage.addToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(headerComponent.numberOfProductsInCart)));
        numberOfProductsAfterAddingToCart = headerComponent.checkNumberInCart();
        System.out.println("*** number in cart after adding = ***"+ numberOfProductsAfterAddingToCart);
    }

    @Then("the product is successfully added to cart")
    public void verifyCart() {
        numberOfProductsBeforeAddingToCart+=1;
        Assert.assertEquals(numberOfProductsBeforeAddingToCart, numberOfProductsAfterAddingToCart);
    }

    @And("the user clicks on Proceed to checkout in the popup page")
    public void proceedToCheckoutFromPopup() {
        shoppingCartSummaryPage = blousePage.proceedToCheckout();
    }

    @Then("the product added is present in the shopping-cart summary page")
    public void verifyShoppingCartSummaryPage() {
        Assert.assertTrue(shoppingCartSummaryPage.verifyBlousePresentInCart());
    }

    @And("the user clicks on Proceed to checkout in the shopping-cart summary page")
    public void proceedToCheckoutFromShoppingCartSummaryPage() {
        myOrderAddressPage = shoppingCartSummaryPage.proceedToCheckout();
    }

    @Then("the address is automatically populated in the My order - address page")
    public void verifyAddressDisplayedInMyOrderAddressPage() {
        Assert.assertTrue(myOrderAddressPage.verifyAddressPopulated());
    }

    @And("the user clicks on Proceed to checkout in the My order - address page")
    public void proceedToCheckoutFromMyOrderAddressPage() {
        shippingDetailsPage = myOrderAddressPage.proceedToCheckout();
    }

    @Then("the user is taken to the shipping details page populated with shipping options")
    public void verifyShippingOptionsPopulated() {
        Assert.assertTrue(shippingDetailsPage.verifyShippingOptionsPopulated());
    }

    @When("the user agrees on terms and conditions and proceeds to checkout")
    public void agreesOnTermsAndProceedToCheckout() {
        paymentPage = shippingDetailsPage.agreeAndProceed();
    }


    @Then("The user is taken to payment page where user clicks on pay by cheque option")
    public void clickOnPayByCheque() {
        chequePaymentPage = paymentPage.clickPayByCheque();
    }

    @When("The user selects {string} in the dropdown menu and clicks on I confirm my order")
    public void selectPaymentOptionAndConfirmOrder(String option) {
        chequePaymentPage.selectOption(option);
        orderConfirmationPage = chequePaymentPage.confirmOrder();
    }


    @Then("The order confirmation page appears with the order reference number")
    public void verifyOrderConfirmationPageAppears() {
        Assert.assertTrue(orderConfirmationPage.verifyOrderConfirmationPage());
        orderRef = orderConfirmationPage.getOrderReferenceNumber();
        Assert.assertFalse(orderRef.equalsIgnoreCase("dummy"));
    }


    @When("the user clicks on View your order history link in the order confirmation page")
    public void clickViewOrderHistoryPageLink() {
        orderHistoryPage = orderConfirmationPage.viewOrderHistoryPage();
    }

    @Then("the order history page shows up with the correct order reference number")
    public void verifyOrderReferenceNumberIsCorrect() {
        Assert.assertEquals(orderHistoryPage.getFirstOrderReference(), orderRef);
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
