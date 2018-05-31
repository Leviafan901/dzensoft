package dzensoft.com.data;

import dzensoft.com.domain.Accounts;
import dzensoft.com.parsers.csv.CsvParser;

public class CsvDataLoader implements DataLoader {

	@Override
	public Accounts load(String dataOrConfigFilePath) {
		Accounts accounts = CsvParser.parse(dataOrConfigFilePath);
		return accounts;
	}
}
