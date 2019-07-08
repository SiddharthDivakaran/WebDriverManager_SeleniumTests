package DriverMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriver implements Driver {

	private String version;

	public ChromeDriver() {
		// default constructor
	}

	public ChromeDriver(String version) {
		version = this.version;
	}

	private WebDriver specificDriverVersion() {
		WebDriverManager.chromedriver().version(version).setup();
		return new org.openqa.selenium.chrome.ChromeDriver();
	}

	private WebDriver latestDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return new org.openqa.selenium.chrome.ChromeDriver(options);

	}

	public WebDriver getDriverInstance() {
		if (version != null) {
			return specificDriverVersion();
		}
		return latestDriver();
	}

}
