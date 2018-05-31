package dzensoft.com.parsers.csv;

import com.opencsv.CSVReader;
import dzensoft.com.domain.Accounts;
import dzensoft.com.domain.UserAccount;
import dzensoft.com.exceptions.ParsingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvParser {

    private static final int LOGIN = 0;
    private static final int PASSWORD = 1;

    public static Accounts parse(String pathToCsvFile) {
    	boolean isEmptyPath = pathToCsvFile.isEmpty();
		if (isEmptyPath) {
			throw new IllegalArgumentException("Incorrect path to XML file!");
		}
    	
    	Accounts accounts = new Accounts();
        try (BufferedReader bufferedStream = new BufferedReader(new FileReader(pathToCsvFile));
             CSVReader reader = new CSVReader(bufferedStream)) {
            String[] line = reader.readNext();
            while (line != null) {
                UserAccount newAccount = new UserAccount(line[LOGIN], line[PASSWORD]);
                accounts.add(newAccount);
                line = reader.readNext();
            }
        } catch (IOException e) {
        	throw new ParsingException("Parsing failed!", e);
        }
        return accounts;
    }
}
