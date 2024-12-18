package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // Intialize the instance variable webdriver
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));

	}

	public BrowserUtility(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {

			logger.info("Launching browser");
			System.err.println("Invalid Browser name..Pleas select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName) {

		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid Browser name..Pleas select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser");
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--disbale-gpu");
				driver.set(new EdgeDriver(options));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");

				driver.set(new FirefoxDriver(options));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else {
			System.err.println("Invalid Browser name..Please select chrome or edge");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Login to the website");
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator " + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		logger.info("Element found and now performing click");
		element.click();
	}
	public void clickOnCheckBox(By locator) {
		logger.info("Finding element with the locator " + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now performing click");
		element.click();
	}
	public void clickOn(WebElement elementtobeclicked) {

		logger.info("Element found and now performing click");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementtobeclicked));
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with locator" + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void ClearText(By textBoxlocator) {
		logger.info("Finding element with locator" + textBoxlocator);

		// WebElement element = driver.get().findElement(textBoxlocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxlocator));
		logger.info("Element found and clearing the text box field");
		element.clear();
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element with the locator " + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Selecting the Option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding element with the locator " + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter special key" + keyToEnter);

		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding the element with locator" + locator);

		WebElement element = driver.get().findElement(locator);
		return element.getText();

	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding all the elements with the locator" + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element found and now printing the list of elements" + locator);
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {

			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));

		}
		return visibleTextList;

	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding all the elements with the locator" + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element found and now printing the list of elements" + locator);

		return elementList;

	}

	public String getVisibleText(WebElement element) {
		logger.info("Return the visible text " + element.getText());

		return element.getText();

	}

	public String takeScreenShot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);

		String path = "./screenshots/" + name + " - " + timestamp + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}

	public void quit() {
		logger.info("Exit session");
		driver.get().quit();

	}
}
