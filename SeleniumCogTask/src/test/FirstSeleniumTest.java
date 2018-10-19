package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstSeleniumTest {

	//Registration email value (change to test code w/o clash of duplicate email when registering)
	public static String Remail ="autoselsss@gmail.com"; 
	
	public static void main(String[] args) {

		String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectLocation + "\\SelLibs\\GeckoDriver\\geckodriver.exe");
        
        WebDriver driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")).click(); //press sign in button after page launch
        
        //First Registration Steps
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(Remail); //enter new user registration email
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click(); //click create account
        
        //Thread wait
        WebDriverWait wait = new WebDriverWait (driver, 30); //30 set by trial and error to give time for all inputs
        WebElement mr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
        mr.click(); //need thread to wait until i can click elements
        
        //Personal Info
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("auto"); //enter  first name
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("selenium"); //enter last name
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("xyz123"); //enter password
        
        //Address Info
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("123 USA Drive");//Address
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Los Angeles");//City
        WebElement postcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"postcode\"]")));//needed to wait again since postcode was unavailable for me
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("97572");//Zip Code
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("0123456789");//Mob #
        Select State = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        State.selectByValue("5");
        Select Country = new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
        Country.selectByValue("21");
        
        //Register Finish
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();//Register
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[2]/a")).click();//Logout
        
        //Login 
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Remail);//Login w/ Registered Email
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("xyz123");//Login w/ password
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();//Press Login
        
        //Search Products 
        //WebDriverWait wait = new WebDriverWait (driver, 30);
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("Dress");//Enter Dress in Search bar
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[2]/form/button")).click();//Click Search icon
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")).click();//Choose an item to view
        
        //Cart Manipulation
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")).click();//place item in cart
        WebElement ContinueShop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")));//needed to wait again since button was unavailable for me
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")).click();//Continue shopping
        driver.findElement(By.xpath("//*[@id=\"color_14\"]")).click();//Change item color
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div/div/div/div[4]/form/div/div[2]/p[1]/a[2]/span/i")).click();//update Quantity 
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")).click();//add to cart again
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[3]/div/a")).click();//view cart
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i")).click();//Delete 1st cart content
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();//Proceed to Checkout
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button")).click();//Keep Proceeding to Checkout
        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();//Agree to terms and conditions
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button")).click();//Delivery option and proceed payment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();//Payment Choice
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button")).click();//Order Confirmation
        
        
	}
}

	