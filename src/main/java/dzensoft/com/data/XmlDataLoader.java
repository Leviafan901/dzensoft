package dzensoft.com.data;

import dzensoft.com.domain.Accounts;
import dzensoft.com.parsers.xml.SaxParser;

public class XmlDataLoader implements DataLoader {

	public Accounts load(String dataOrConfigFilePath) {
		Accounts accounts = SaxParser.parse(dataOrConfigFilePath);
		return accounts;
	}
}