package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import page.CartPage;
import page.LoginPage;
import page.SearchPage;
import page.SelectProductPage;

public class FlowOfTest extends BaseTest {


    @Test
    public void completeUserJourney() throws InterruptedException  {
        LoginPage loginPage = new LoginPage(driver, props);
        loginPage.login();

        SearchPage searchPage = new SearchPage(driver, props);
        searchPage.searchProduct();

        SelectProductPage selectProductPage = new SelectProductPage(driver, props);
        selectProductPage.selectFirstProduct();

        CartPage cartPage = new CartPage(driver, props);
        cartPage.addToCartAndCheckout();

        System.out.println("✅ User journey completed till checkout page.");
    }
}
