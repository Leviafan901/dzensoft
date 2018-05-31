package dzensoft.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetProposalForm extends AbstractPage {

    @FindBy(id = "register-first-name")
    private WebElement firstNameInputField;

    @FindBy(id = "register-last-name")
    private WebElement lastNameInputField;

    @FindBy(id = "register-email")
    private WebElement emailInputField;

    @FindBy(id = "click")
    private WebElement cookieNotification;

    @FindBy(css = "button.btn.btn-blue")
    private WebElement submitButton;

    private WebDriver webDriver;
    private static final String PAGE_URL = "https://new.dzensoft.com/get-proposal";

    public GetProposalForm(WebDriver webDriver) {
        super(webDriver);
    	this.webDriver = getDriver();
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public void loadPage() {
        this.webDriver.get(PAGE_URL);
    }

    public void fillFirstNameField(String text) {
        inputText(firstNameInputField, text);
    }

    public void fillLastNameField(String text) {
        inputText(lastNameInputField, text);
    }

    public void fillEmailField(String text) {
        inputText(emailInputField, text);
    }

    public void getCoockieNotification() {
        clickElement(cookieNotification);
    }

    public void submitForm() {
        clickElement(submitButton);
    }

    /*
    public void getIntoSentFolder() {
    	waitUntilElementIsPresent(sentFolder);
    	clickElement(sentFolder);
    }

    public void logOut() {
    	clickElement(userMailBoxName);
    	waitUntilElementIsPresent(logoutButton);
    	clickElement(logoutButton);
    }
    
    public void deleteMessages() {
    	clickElement(selectAllMessagesCheckbox);
    	waitUntilElementIsPresent(deleteButton);
    	clickElement(deleteButton);
    }*/
}