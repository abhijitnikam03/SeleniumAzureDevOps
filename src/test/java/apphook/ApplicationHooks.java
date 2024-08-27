package apphook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;
import util.ScreenRecorderUtil;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	String screenshotName; 
	Path screenshotPath;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() throws Exception {
		String browserName = prop.getProperty("browser");
		File file = new File("recordings/");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}
	
	@Before(order = 2)
	public void filespath(Scenario scenario) throws Exception
	{	
		ScreenRecorderUtil.startRecord("filespath");
		screenshotPath = Paths.get("test-output/ScreenShot/"+scenario.getName().replaceAll(" ", "_"));
		Path pdfPath = Paths.get("test-output/PdfReport");
		Path sparkreportPath = Paths.get("test-output/SparkReport");
		Path vrPath = Paths.get("test-output/VideoRecord");

		deletefiles(screenshotPath);
		deletefiles(pdfPath);
		deletefiles(sparkreportPath);
		deletefiles(vrPath);

	}

	@After(order = 0)
	public void quitBrowser() throws Exception {
		ScreenRecorderUtil.stopRecord();
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException {		
		screenshotName=scenario.getName().replaceAll(" ", "_");
		Shutterbug.shootPage(driver, Capture.FULL, false).save("./test-output/ScreenShot/" +screenshotName);	
	}
	
	public void deletefiles(Path folderPath) {
		try {
            // List all files and directories in the specified folder
            try (Stream<Path> paths = Files.list(folderPath)) {
                paths.forEach(path -> {
                    try {
                        if (Files.isRegularFile(path)) {
                            // Delete the file
                            Files.delete(path);
                            System.out.println("Deleted file: " + path);
                        } else if (Files.isDirectory(path)) {
                            // Handle directories if needed (optional)
                            System.out.println("Skipping directory: " + path);
                        }
                    } catch (IOException e) {
                        System.err.println("Failed to delete file: " + path + " due to: " + e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            System.err.println("Error listing files: " + e.getMessage());
        }
	}
	
	

}