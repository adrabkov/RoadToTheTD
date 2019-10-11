package project.steps;

import a1qa.selenium.browser.BrowserManager;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import a1qa.selenium.waitings.SmartWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@PageInfo(xpath = "//span[@id]/a/img")

public class CheckFileDownloaded extends BaseForm {
    private static final String DEFAULT_FILE_NAME = "SteamSetup.exe";

    public void testFileDownloaded() {

        String filePath = getTargetFilePath();
        File file = new File(filePath.concat(DEFAULT_FILE_NAME));

        String fileAddress = "file://".concat(filePath);

        SmartWait.waitForTrue(webDriver -> file.exists());
        BrowserManager.getBrowser().goTo(fileAddress);

        Assert.assertTrue(file.length() != 0);
        deleteFile(file);
    }

    private void deleteFile(File file) {
        if (file.exists()) {
            try {
                Files.delete(Paths.get(file.getCanonicalPath()));
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    private String getTargetFilePath() {
        String downloadDirectory = BrowserManager.getBrowser().getDownloadDirectory();

        if (downloadDirectory.contains("/") && !downloadDirectory.endsWith("/")) {
            downloadDirectory = downloadDirectory.concat("/");
        }
        if (downloadDirectory.contains("\\") && !downloadDirectory.endsWith("\\")) {
            downloadDirectory = downloadDirectory.concat("\\");
        }

        return downloadDirectory;

    }
}
