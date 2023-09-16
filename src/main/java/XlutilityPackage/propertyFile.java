package XlutilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFile {

	public Properties pro;

	static String path = "C:\\Users\\webca\\eclipse-workspace\\ordercenterASI\\propertyData\\propertydata.properties";

	public propertyFile() throws IOException {

		File f2 = new File(path);

		FileInputStream file = new FileInputStream(f2);

		try {
			pro = new Properties();
			pro.load(file);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	public String getUrl() {

		return pro.getProperty("Url");

	}

	public String getUsername() {
		return pro.getProperty("Username");
	}

	public String getPassoword() {
		return pro.getProperty("Password");

	}

	public String getBrowser() {
		return pro.getProperty("Browser");

	}
}
