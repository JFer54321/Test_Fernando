package CursoTutorial_Ahora_Si;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Test_prueba {

	private WebDriver driver;

	@Before	
	public void setUp() {
	
		System.setProperty("webdriver.firefox.driver", "./src/test/resources/geckodriver/geckodriver.exe");
		driver = (WebDriver) new GeckoDriverInfo();
		driver.manage().window().maximize();
		driver.get("https://www.falabella.cl/");

	}
		
	@Test
	public void testFalabellaPage() {
		
		WebElement homePage = driver.findElement(By.name("Ntt"));
		
		homePage.clear();
		
		homePage.sendKeys("lavadora");
		
		homePage.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("lavadora", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
