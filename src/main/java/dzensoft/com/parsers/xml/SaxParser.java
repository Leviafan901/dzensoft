package dzensoft.com.parsers.xml;

import dzensoft.com.domain.Accounts;
import dzensoft.com.exceptions.ParsingException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SaxParser {
	
	public static Accounts parse(String pathToXmlFile) {
		boolean isEmptyXmlPath = pathToXmlFile.isEmpty();
		if (isEmptyXmlPath) {
			throw new IllegalArgumentException("Incorrect path to XML file!");
		}
		
		SaxHandler saxHandler = new SaxHandler();
		try (InputStream file = new BufferedInputStream(new FileInputStream(pathToXmlFile))) {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(file, saxHandler);
	    } catch (ParserConfigurationException | SAXException | IOException e) {
			throw new ParsingException("Parsing failed!", e);
		}
		
		Accounts accounts = new Accounts(saxHandler.getPlantList());
	    return accounts;
	}
}