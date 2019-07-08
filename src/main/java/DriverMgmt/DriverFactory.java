package DriverMgmt;

import org.openqa.selenium.WebDriver;

import Exceptions.DriverException;

public class DriverFactory {

	public static final int CHROME = 0;
	public static final int FIREFOX = 1;

	public static WebDriver getDriverInstance(int browserType) throws Exception {
		return getDriver(browserType, null);
	}

	public static WebDriver getDriverInstance(int browserType, String version) throws Exception {
		return getDriver(browserType, version);
	}

	private static WebDriver getDriver(int browserType, String version) throws Exception {
		switch (browserType) {
		case CHROME:
			return version == null ? new ChromeDriver().getDriverInstance()
					: new ChromeDriver(version).getDriverInstance();
		}
		throw new DriverException();
	}

}
