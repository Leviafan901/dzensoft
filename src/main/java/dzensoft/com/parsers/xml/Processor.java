package dzensoft.com.parsers.xml;

import dzensoft.com.domain.UserAccount;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class Processor implements ElementConstants {

	private List<UserAccount> accountList = new ArrayList<>();
	private UserAccount userAccount;

	public List<UserAccount> getAccountList() {
		return accountList;
	}

	public void processStartDocument() throws SAXException {
		
	}

	public void processStartElement(String qName, Attributes attributes) throws SAXException {
		if (USER_ACCOUNT.equals(qName)) {
			userAccount = new UserAccount();
		}
	}

	public void processEndElement(String qName) throws SAXException {
		boolean isUserAccount = USER_ACCOUNT.equals(qName);
		if (isUserAccount) {
			accountList.add(userAccount);
		}
	}

	public void processCharacters(String currentElement, String elementValue) {
		switch (currentElement) {
		case LOGIN:
			userAccount.setLogin(elementValue);
			break;

		case PASSWORD:
			userAccount.setPassword((elementValue));
			break;
		}
		currentElement = null;
	}

	public void processEndDocument() {
		
	}
}
