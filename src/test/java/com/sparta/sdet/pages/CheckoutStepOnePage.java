package com.sparta.sdet.pages;

import com.sparta.sdet.util.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage {
    private static WebDriver webDriver;
    private CheckoutStepTwoPage csTwoPage;
    private CartPage cartPage;
    private @FindBy(id = "first-name")
    WebElement firstName;
    private @FindBy(id = "last-name")
    WebElement lastName;
    private @FindBy(id = "postal-code")
    WebElement postcode;
    private @FindBy(id = "cancel")
    WebElement cancelButton;
    private @FindBy(id = "continue")
    WebElement continueButton;
    private @FindBy(className = "error-message-container")
    WebElement errorMessage;

    public CheckoutStepOnePage() {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void fillFirstName() {
        firstName.sendKeys(PropertiesLoader.getProperties().getProperty("firstName"));
    }

    public void fillLastName() {
        lastName.sendKeys(PropertiesLoader.getProperties().getProperty("lastName"));
    }

    public void fillPostalCode() {
        postcode.sendKeys(PropertiesLoader.getProperties().getProperty("postCode"));
    }

    public void fillInAllFields() {
        firstName.sendKeys(PropertiesLoader.getProperties().getProperty("firstName"));
        lastName.sendKeys(PropertiesLoader.getProperties().getProperty("lastName"));
        postcode.sendKeys(PropertiesLoader.getProperties().getProperty("postCode"));
    }

    public boolean isFirstNameBlank(){
        return firstName==null||firstName.getText().isBlank();
    }

    public boolean isLastNameBlank(){
        return lastName==null||lastName.getText().isBlank();
    }

    public boolean isPostalCodeBlank(){
        return postcode==null||postcode.getText().isBlank();
    }

    public boolean areAllFieldsBlank() {
        return isFirstNameBlank() &&
                isLastNameBlank() &&
                isPostalCodeBlank();
    }

    public boolean isFirstNameValid(){
    return !firstName.getText().contains("[^a-zA-Z]");
    }

    public boolean isLastNameValid(){
        return !lastName.getText().contains("[^a-zA-Z]");
    }

    public boolean isPostalCodeValid(){
        return !postcode.getText().contains("[^a-zA-Z]");
    }

    public boolean areAllFieldsValid(){
        return  !firstName.getText().contains("[^a-zA-Z]")||
                !lastName.getText().contains("[^a-zA-Z]")||
                !postcode.getText().contains("[^a-zA-Z]");
    }

    public CheckoutStepTwoPage goToCheckoutStepTwoPage() {
        clickContinue();
        return new CheckoutStepTwoPage();
    }

    public CartPage goToCartPage() {
        clickCancel();
        return new CartPage();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public boolean isFirstNameEmptyErrorDisplayed() {
        return getErrorMessage().contains("Error: First Name is required");
    }

    public boolean isLastNameEmptyErrorDisplayed() {
        return getErrorMessage().contains("Error: Last Name is required");
    }

    public boolean isPostalCodeEmptyErrorDisplayed() {
        return getErrorMessage().contains("Error: Postal Code is required");
    }

    public boolean areAllEmptyFieldsErrorDisplayed(){
        return  getErrorMessage().contains("Error: First Name is required") &&
                getErrorMessage().contains("Error: Last Name is required") &&
                getErrorMessage().contains("Error: Postal Code is required");
    }
}

