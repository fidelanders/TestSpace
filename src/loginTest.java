
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class loginTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.chrome.driver",path_of_browser_driver);

		String url = "https://the-internet.herokuapp.com/";

		driver.manage().window().maximize();
		driver.get(url);

		// Question 1: Valid Login

		// Click "Form Authentication"
		WebElement formAuth = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a"));
		System.out.println("Clicking on the Form Authentication in the main page");
		formAuth.click();

		// 2. Enter username and password
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.className("radius"));

		// Valid username and password
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		loginBtn.click();

		// Asserting the success message
		String expectedText = "You logged into a secure area!";
		String message = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		Assert.assertTrue(message.contains(expectedText));
		System.out.println(expectedText + " ***Assertion Passed*** ***Login Passed***");

		// Logout
		WebElement logout = driver.findElement(By.xpath("//*[@id='content']/div/a"));
		System.out.println("Clicking the Logout button");
		logout.click();

		// Question 2: Invalid Login

		driver.navigate().refresh();

		// Enter username and password
		WebElement username2 = driver.findElement(By.id("username"));
		WebElement password2 = driver.findElement(By.id("password"));
		WebElement loginBtn2 = driver.findElement(By.className("radius"));

		// Valid username and password
		username2.sendKeys("thomas");
		password2.sendKeys("SecretPassword!");
		loginBtn2.click();

		// Asserting the invalid username message
		String expectedText2 = "Your username is Invalid!";
		String message2 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
		Assert.assertFalse(message2.contains(expectedText2));
		System.out.println(expectedText2 + " ***Assertion Passed*** ***Invalid Login***");

		driver.close();
	}
}
