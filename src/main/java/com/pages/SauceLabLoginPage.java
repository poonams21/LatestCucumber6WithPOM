package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLabLoginPage {
    private WebDriver driver;
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By logInButton = By.id("login-button");

    // 2. Constructor of the page class:
    public SauceLabLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void enterUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(logInButton).click();
    }

    public InventoryPage loginSauceApp(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(userName).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(logInButton).click();
        return new InventoryPage(driver);
    }
}
