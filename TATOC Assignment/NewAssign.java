package JavaFiles;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;;

public class NewAssign {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		
		//1st page
		driver.findElement(By.className("greenbox")).click();
		
		//2nd page
		WebDriver main = driver.switchTo().frame("main");
		final String colour = main.findElement(By.id("answer")).getAttribute("class");
		System.out.println(colour);
		WebElement child = main.switchTo().frame("child").findElement(By.id("answer"));
		String changecolour = child.getAttribute("class");
		System.out.println(changecolour);
		while(!colour.equals(changecolour)) {
			driver.switchTo().parentFrame().findElements(By.tagName("a")).get(0).click();
			changecolour = driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
			System.out.println(changecolour);
		}
		driver.switchTo().parentFrame().findElements(By.tagName("a")).get(1).click();
		driver.switchTo().defaultContent();
		
		//3rd page
		WebElement From = driver.findElement(By.id("dragbox"));
		WebElement To = driver.findElement(By.id("dropbox"));
		Actions act=new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
		driver.findElement(By.tagName("a")).click();
		
		//4th page
		String MainWindow=driver.getWindowHandle();
		driver.findElements(By.tagName("a")).get(0).click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.id("name")).sendKeys("Hardik");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(MainWindow);
		driver.findElements(By.tagName("a")).get(1).click();
		
		//5th page
		driver.findElements(By.tagName("a")).get(0).click();
		String token = driver.findElement(By.id("token")).getText();
		token = token.substring(7);
		Cookie cookie = new Cookie("Token", token);
		driver.manage().addCookie(cookie);
		driver.findElements(By.tagName("a")).get(1).click();
		System.out.println(token);
	}

}
