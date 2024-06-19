package baseclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppBase {

	private static AndroidDriver driver;
	private static AppiumDriverLocalService appiumServer;

	public AppBase() throws MalformedURLException {
		startAppiumServer();
		initializeDriver();
	}

	public void initializeDriver() throws MalformedURLException {
		UiAutomator2Options capabilities = new UiAutomator2Options();
//		capabilities.setCapability("deviceName", "Pixel_7_API_TiramisuPrivacySandbox");
		capabilities.setCapability("deviceName", "R52W409CCYF");
		capabilities.setCapability("platformVersion", "14.0");
//		capabilities.setCapability("udid", "emulator-5554");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("appPackage", "com.aciana.docisn");
		capabilities.setCapability("appActivity", "com.aciana.docisn.MainActivity");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("newCommandTimeout", 30);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
	}

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
		
//		Comment the following to run in real device.

//		String sdkPath = "C:\\Users\\Archents\\AppData\\Local\\Android\\Sdk";
//		String emulatorPath = sdkPath + "\\emulator" + File.separator + "emulator";
//
//		try {
//			ProcessBuilder process = new ProcessBuilder("cmd.exe", "/C", "start", emulatorPath, "-avd", "Pixel_7_API_TiramisuPrivacySandbox");
//			process.start();
//			Thread.sleep(1000000);
//			System.out.println("Emulator launched successfully!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("Appium Server started successfully.");
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

	public void endSession() {
		if (driver != null) {
			driver.quit();
		}
		stopAppiumServer();
	}
}
