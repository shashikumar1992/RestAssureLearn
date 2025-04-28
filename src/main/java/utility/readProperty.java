package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class readProperty {

	static Properties pro = new Properties();

	public static String getValueBykey(String key) {

		String filePath = System.getProperty("user.dir").concat("//src//main//resources//config.properties");
		String value = null;
		try {
			FileInputStream file = new FileInputStream(filePath);

			pro.load(file);
			value = pro.getProperty(key);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return value;

	}
}
