package log4jfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class logfile {

	public static Logger log;

	public static Logger getlogger() throws FileNotFoundException {

		String path = "C:\\Users\\webca\\eclipse-workspace\\ordercenterASI\\propertyData\\log4j.properties";
		File f1 = new File(path);
		FileInputStream file = new FileInputStream(f1);

		log = LogManager.getLogger(logfile.class.getName());

		PropertyConfigurator.configure(file);

		return log;

	}
}
