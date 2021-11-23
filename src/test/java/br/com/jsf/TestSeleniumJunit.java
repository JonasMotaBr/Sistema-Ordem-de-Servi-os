package br.com.jsf;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSeleniumJunit {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drive_chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost:8080/Projeto_JSF/");
		
		Thread.sleep(3000);
	}

}
