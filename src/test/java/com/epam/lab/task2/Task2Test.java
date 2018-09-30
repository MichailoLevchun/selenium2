package com.epam.lab.task2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2Test {
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";

	private void takeScreenShot(WebDriver driver) throws IOException {
		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
	}

	@Test
	public void testSendLetter() throws IOException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		WebElement mail = driver.findElement(By.xpath("id('identifierId')"));
		mail.sendKeys("abbad5431" + Keys.ENTER);
		WebElement psword = driver.findElement(By.xpath("//input[@name='password']"));
		psword.sendKeys("123rty789" + Keys.ENTER);
		driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.T-I-KE.L3")).click();
		driver.findElement(By.cssSelector("div.wO.nr.l1 > textarea")).sendKeys("e632509@nwytg.net");
		driver.findElement(By.cssSelector("input.aoT")).sendKeys("Tema dlya lysta");
		driver.findElement(By.xpath("//div[@role = 'textbox']")).sendKeys("Ya mayu kota");
		driver.findElement(By.cssSelector("img.Ha")).click();
		driver.findElement(By.cssSelector("*[href='https://mail.google.com/mail/u/0/#drafts']")).click();
		driver.findElement(By.xpath("//*[@role='main']//tr[contains(@class, 'zA') and contains(@class ,'yO')]"))
				.click();
		driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();
		takeScreenShot(driver);
		Assert.assertTrue(driver.findElement(By.cssSelector("div.vh")).isDisplayed());
		driver.quit();
	}

}
