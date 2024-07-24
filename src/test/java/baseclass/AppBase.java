package baseclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.After;

public class AppBase {

	private static AndroidDriver driver;
	private static AppiumDriverLocalService appiumServer;

	public void startAppiumServer() {
		AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
		appiumServiceBuilder.withAppiumJS(new File("C:\\Users\\Archents\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
		.usingPort(4723)
		.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
		.withLogFile(new File("D:\\DummyProj\\TestAppium\\LogFile.txt"))
		.withIPAddress("127.0.0.1");

		appiumServer = AppiumDriverLocalService.buildService(appiumServiceBuilder);
		appiumServer.start();

		System.out.println("Appium Server started successfully.");
	}

	public void initializeDriver() {
		try {
			UiAutomator2Options capabilities = new UiAutomator2Options();
			            capabilities.setCapability("deviceName", "R52W409CCYF");
//			capabilities.setCapability("deviceName", "Pixel_7_Pro_API_31");
//			capabilities.setCapability("platformVersion", "12.0");
			            capabilities.setCapability("platformVersion", "14.0");
			capabilities.setCapability("noReset", true);
			//            capabilities.setCapability("appPackage", "com.aciana.docisn");
			//            capabilities.setCapability("appActivity", "com.aciana.docisn.MainActivity");
			capabilities.setCapability("automationName", "UiAutomator2");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("newCommandTimeout", 60);
			capabilities.setCapability("skipUnlock", true);
//			capabilities.setAvdReadyTimeout(Duration.ofSeconds(60000)); // to wait for the emulator to be ready or opened properly or boot up
			capabilities.setCapability("appium:appiumVersion", "2.11.1");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);


		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}


	public void startEmulator() {
		try {
			String androidSdkPath = "C:\\Users\\Archents\\AppData\\Local\\Android\\Sdk";
			String emulatorName = "Pixel_7_Pro_API_31";
			ProcessBuilder processBuilder = new ProcessBuilder(androidSdkPath + "/emulator/emulator", "-avd", emulatorName);
			processBuilder.start();	
			System.out.println("Waiting for 5 seconds to launch emulator");
			Thread.sleep(5000);
			System.out.println("Emulator launched");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public void stopAppiumServer() {
		if (appiumServer != null) {
			appiumServer.stop();
			System.out.println("Appium Server stopped.");
		} else {
			System.out.println("Appium Server is not running.");
		}
	}

	@After
	public void endSession() {
		if (driver != null) {
			driver.quit();
		}
		stopAppiumServer();
	}
}
