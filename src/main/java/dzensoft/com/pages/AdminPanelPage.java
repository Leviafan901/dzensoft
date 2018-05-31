package dzensoft.com.pages;

import dzensoft.com.domain.UserAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement loginInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//span[contains(text(), 'Email Section')]")
    private WebElement emailSectionButton;

    @FindBy(xpath = "//span[contains(text(), 'Email from client')]")
    private WebElement emailFromClients;

    private static final String URL = "https://new.dzensoft.com/login";
    private WebDriver webDriver;

    public AdminPanelPage(WebDriver webDriver) {
    	super(webDriver);
    	this.webDriver = getDriver();
        setPageUrl(URL);
        PageFactory.initElements(this.webDriver, this);
    }

    public void logIn(String login, String password) {
    	waitUntilElementIsPresent(loginInputField);
    	setElementText(loginInputField, login);
    	setElementText(passwordInputField, password);
    	clickElement(loginSubmitButton);
    }

    public void getEmailsFolder() {
        waitUntilElementIsPresent(emailSectionButton);
        clickElement(emailSectionButton);
        waitUntilElementIsPresent(emailFromClients);
        clickElement(emailFromClients);
    }
}
