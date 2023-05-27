package testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.Assert;

class Desc {
	private String name;
	private int age;
	private String gender;

	public Desc(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

public class auto {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Prakhar\\Downloads\\Browser Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		ArrayList<Desc> list = new ArrayList();

		String jsonData = "[{\"name\":\"Bob\", \"age\":20, \"gender\":\"Male\"}, {\"name\":\"George\", \"age\":42, \"gender\":\"Male\"}, {\"name\":\"Sara\", \"age\":20, \"gender\":\"Female\"}, {\"name\":\"Jane\", \"age\":25, \"gender\":\"Female\"}, {\"name\":\"Jim\", \"age\":30, \"gender\":\"Male\"}]";

		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

		Thread.sleep(2000);

		driver.manage().window().maximize();

		Thread.sleep(2000);

		WebElement tableclick = driver.findElement(By.xpath("//summary"));

		tableclick.click();

		Thread.sleep(2000);

		WebElement json = driver.findElement(By.xpath("//textarea[@id='jsondata']"));

		json.click();

		Actions actions = new Actions(driver);

		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		actions.keyDown(Keys.BACK_SPACE);
		actions.keyUp(Keys.BACK_SPACE);
		actions.build().perform();

		json.sendKeys(jsonData);

		WebElement refresh = driver.findElement(By.xpath("//button[@id='refreshtable']"));

		refresh.click();

		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.xpath(".//td"));

			for (WebElement cell : cells) {
				String data = cell.getText();
				System.out.print(data + "\t");
			}

			System.out.println();

			Thread.sleep(5000);

			// Assert.assertEquals(original, expected);

			

		}

	}
}
