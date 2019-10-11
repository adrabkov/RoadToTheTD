package framework.configurations;


import aqa.properties.PropertiesResourceManager;

public class Configuration {
    private static Environment currentEnvironment;

    private Configuration() {
    }

    public static synchronized Environment getCurrentEnvironment() {
        if (currentEnvironment == null)
            currentEnvironment = Environment.valueOf((System.getProperty("environment") != null ? System.getProperty("environment")
                    : new PropertiesResourceManager("config.properties").getProperty("environment")).toUpperCase());
        return currentEnvironment;
    }
}
