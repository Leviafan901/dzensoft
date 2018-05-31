package dzensoft.com.util;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

public class TestLogger {

	private final static Logger LOGGER = Logger.getLogger(TestLogger.class);
	
	public static Logger getLogger(Class classForLogin, String fileName) {
		Logger logger = Logger.getLogger(classForLogin);
		SimpleLayout layout = new SimpleLayout();    
	      FileAppender appender = null;
		try {
			appender = new FileAppender(layout, fileName, false);
		} catch (IOException e) {
			LOGGER.error("Can't inizialize test logger!", e);
		}    
	      logger.addAppender(appender);

	      logger.setLevel((Level) Level.INFO);
	      return logger;
	}
}
