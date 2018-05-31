package dzensoft.com.pages;

import org.openqa.selenium.WebDriver;

public class Pages {

    private GetProposalForm mailBoxPage = null;
    private AdminPanelPage mailTutByPage = null;
    private WebDriver webDriver;

    public Pages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public AdminPanelPage adminPanelPage() {
        if (mailTutByPage == null) {
            mailTutByPage = new AdminPanelPage(webDriver);
        }
        return mailTutByPage;
    }

    public GetProposalForm getProposalFormPage() {
        if (mailBoxPage == null) {
            mailBoxPage = new GetProposalForm(webDriver);
        }
        return mailBoxPage;
    }
}
