package HW3_waits;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyManager {

    private static final String EXTENSION = ".properties";
    private Properties properties = new Properties();

    public PropertyManager(String resourceName) {

        String resourceNameWithExtension = resourceName + EXTENSION;
        InputStream propertiesStream = this.getClass().getClassLoader().getResourceAsStream(resourceNameWithExtension);

        try {
            properties.load(propertiesStream);
            propertiesStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String getSystemProperty(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}
