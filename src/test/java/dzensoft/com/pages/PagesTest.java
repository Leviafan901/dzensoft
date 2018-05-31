package dzensoft.com.pages;

import dzensoft.com.data.TestData;
import dzensoft.com.domain.UserAccount;
import dzensoft.com.util.BrowserType;
import dzensoft.com.util.TestLogger;
import dzensoft.com.util.WebDriverHandler;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class PagesTest {

	private final static Logger LOGGER = TestLogger.getLogger(PagesTest.class, "pagestest.log");

    private Pages pages;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup(ITestContext testContext)  {
        driver = WebDriverHandler.loadDriver(BrowserType.CHROME);
        pages = PageFactory.initElements(driver, Pages.class);
    }

    @Test
    public void inputValuesInFormAndCheckItInAdminPanelAndEmail() {

        pages.getProposalFormPage().loadPage();
        pages.getProposalFormPage().fillFirstNameField("Alexei");
        pages.getProposalFormPage().fillLastNameField("Sosenkov");
        pages.getProposalFormPage().fillEmailField("test@mail.ru");
        pages.getProposalFormPage().getCoockieNotification();
        pages.getProposalFormPage().submitForm();
        LOGGER.info("The form is submited!");

        pages.adminPanelPage().loadPage();
        pages.adminPanelPage().logIn("admin@dzensoft.com", "WNtwbQ72aZPY");
        pages.adminPanelPage().getEmailsFolder();

    }
    
    @AfterClass(alwaysRun = true)
    public void teardown() {
    	LOGGER.info("Test suite is over!");
        driver.quit();
    }
}