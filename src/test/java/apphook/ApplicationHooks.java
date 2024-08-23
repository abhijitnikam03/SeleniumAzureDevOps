package apphook;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
	private ScreenRecorder screenRecorder;
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
	public void filespath() throws Exception
	{
		ScreenRecorderUtil.startRecord("filespath");
		Path screenshotPath = Paths.get("test-output/ScreenShot");
		Path pdfPath = Paths.get("test-output/PdfReport");
		Path sparkreportPath = Paths.get("test-output/SparkReport");
		deletefiles(screenshotPath);
		deletefiles(pdfPath);
		deletefiles(sparkreportPath);
	}

	@After(order = 0)
	public void quitBrowser() throws Exception {
		ScreenRecorderUtil.stopRecord();
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException {
	//	if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
		//	byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//  scenario.attach(sourcePath, "image/png", screenshotName);
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./test-output/ScreenShot/"+screenshotName+".png"));
	//	}
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