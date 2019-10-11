package framework.configurations;

import aqa.properties.PropertiesResourceManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum Environment {
    PROD("prod"),
    STAGE("stage");

    Path dataPath;
    Path configPath;
    PropertiesResourceManager envManager;

    Environment(String name) {
        String envPath = String.valueOf(Paths.get("environment", name));
        configPath = Paths.get(envPath, "config.properties");
        envManager = new PropertiesResourceManager(String.valueOf(configPath));
        String dataPathFromConfig = envManager.getProperty("dataPath");
        String baseDir = System.getProperty("user.dir") != null ? System.getProperty("user.dir") : System.getProperty("project.basedir");
        Path resourcePath = Paths.get(baseDir, "src", "test", "resources");
        dataPath = Paths.get(String.valueOf(resourcePath), envPath, dataPathFromConfig);
    }

    public Path getConfigPath() {
        return configPath;
    }

    public Path getDataPath() {
        return dataPath;
    }

    public String getStartUrl() {
        return getEnvProperty("startUrl");
    }

    public String getEnvProperty(String property) {
        return envManager.getProperty(property);
    }

    public String getLang() {
        return envManager.getProperty("lang");
    }
}