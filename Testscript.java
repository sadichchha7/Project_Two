package webAutomation;

import java.io.File;
import Util.Log;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.Properties;
import Util.util;
import objectRepository.ObjectRepoTestscript;

public class Testscript extends Properties {
	public static WebDriver driver;
	public String username, password;
	public String browser;
	public static WebElement element;
	public String folderName;
	public int methodCount = 1;

	// -----------------Read excel---------------------------------------------
	@DataProvider(name = "getLoginData")
	public Object[][] excelDP() throws IOException {
		util samp = new util();
		Object[][] arrObj = samp.getExcelData("D:\\Users\\F9Y5ANL\\Documents\\Testing.xlsx", "Testscript_Sheet");
		System.out.println(Arrays.toString(arrObj));
		return arrObj;
	}

	// --------------------------Test Case 1
	// started----------------------------------------------------------------
	@Test(dataProvider = "getLoginData", groups = { "Scenario1" }, priority = 1)
	public void TestcaseTest_1(String url, String browser, String scenario, String search_text, String productName,
			String cnrty_flag, String age_value, String cart_age_value, String top_stitch_thread_colour_text,
			String cart_price, String change_age_value, String text, String empty_msg, String product_Name1,
			String top_stitch_thread_colour_text1) throws Exception {
		try {
			folderName = "Scenario1";
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			System.out.println(methodName + "methodName");
			openBrowser(browser);
			Thread.sleep(3000);
			driver = Properties.driver;
			driver.get(url);
			driver.findElement(By.xpath(ObjectRepoTestscript.search_button)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.search_textbox)).sendKeys(search_text);
			takeScreenshot(methodName);
			driver.findElement(By.xpath(ObjectRepoTestscript.search_textbox)).click();
			WebDriverWait wait1 = new WebDriverWait(driver, 10000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepoTestscript.close_button)));
			driver.findElement(By.xpath(ObjectRepoTestscript.close_button)).click();
			Thread.sleep(5000);
			String tshirtFormPrice = driver.findElement(By.xpath(ObjectRepoTestscript.kids_basic_tshirt_price))
					.getText();
			driver.findElement(By.xpath(ObjectRepoTestscript.kids_basic_tshirt)).click();
			takeScreenshot(methodName);
			String tshirtDetailPagePrice = driver.findElement(By.xpath(ObjectRepoTestscript.price_on_detailed_page))
					.getText();
			tshirtDetailPagePrice.contains(tshirtFormPrice);
			Thread.sleep(5000);
			driver.findElement(By.xpath(ObjectRepoTestscript.add_to_wishList)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.wishList_button)).click();
			Thread.sleep(5000);
			takeScreenshot(methodName);
			String prod_name = driver.findElement(By.xpath(ObjectRepoTestscript.wishList_product_name)).getText();
			Assert.assertEquals(prod_name, productName);
			String prod_price = driver.findElement(By.xpath(ObjectRepoTestscript.wishList_product_price)).getText();
			prod_price.contains(tshirtFormPrice);
			takeScreenshot(methodName);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
			Log.error(e.toString());
			driver.quit();
		}
	}

	// --------------------------Test Case 2
	// started----------------------------------------------------------------
	@Test(dataProvider = "getLoginData", groups = { "Scenario2" }, priority = 2)
	public void TestcaseTest_2(String url, String browser, String scenario, String search_text, String productName,
			String cnrty_flag, String age_value, String cart_age_value, String top_stitch_thread_colour_text,
			String cart_price, String change_age_value, String text, String empty_msg, String product_Name1,
			String top_stitch_thread_colour_text1) throws Exception {
		try {
			folderName = "Scenario2";
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			System.out.println(methodName + "methodName");
			openBrowser(browser);
			Thread.sleep(3000);
			driver = Properties.driver;
			driver.get(url);
			driver.findElement(By.xpath(ObjectRepoTestscript.search_button)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.search_textbox)).sendKeys(search_text);
			takeScreenshot(methodName);
			driver.findElement(By.xpath(ObjectRepoTestscript.search_textbox)).click();
			WebDriverWait wait1 = new WebDriverWait(driver, 10000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepoTestscript.close_button)));
			driver.findElement(By.xpath(ObjectRepoTestscript.close_button)).click();
			WebDriverWait wait17 = new WebDriverWait(driver, 10000);
			wait17.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepoTestscript.kids_basic_tshirt)));
			driver.findElement(By.xpath(ObjectRepoTestscript.kids_basic_tshirt)).click();
			takeScreenshot(methodName);
			WebDriverWait wait3 = new WebDriverWait(driver, 50000);
			wait3.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepoTestscript.start_design_option)));

			driver.findElement(By.xpath(ObjectRepoTestscript.start_design_option)).click();
			takeScreenshot(methodName);
			driver.findElement(By.xpath(ObjectRepoTestscript.boys_basic_tshirt)).click();
			Thread.sleep(5000);
			takeScreenshot(methodName);
			try {
				Select select = new Select(driver.findElement(By.xpath(ObjectRepoTestscript.age)));
				select.selectByVisibleText(age_value);
			} catch (Exception e) {
				Log.error(e.toString());
			}
			Thread.sleep(10000);
			driver.findElement(By.xpath(ObjectRepoTestscript.choose_thread)).click();
			WebElement n1 = driver.findElement(By.xpath(ObjectRepoTestscript.scroll1));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", n1);
			driver.findElement(By.xpath(ObjectRepoTestscript.design_button)).click();
			takeScreenshot(methodName);
			Thread.sleep(10000);
			driver.findElement(By.xpath(ObjectRepoTestscript.clip_art)).click();
			Thread.sleep(10000);
			try {
				driver.findElement(By.xpath(ObjectRepoTestscript.country_flag)).click();
			} catch (Exception e) {
				Log.error(e.toString());
			}
			takeScreenshot(methodName);
			Thread.sleep(5000);
			driver.findElement(By.xpath(ObjectRepoTestscript.close)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.preview_and_buy)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.proceed_to_cart)).click();
			WebDriverWait wait11 = new WebDriverWait(driver, 10000);
			wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepoTestscript.close_popup)));
			driver.findElement(By.xpath(ObjectRepoTestscript.close_popup)).click();
			String prod_name_cart = driver.findElement(By.xpath(ObjectRepoTestscript.age_in_cart)).getText();
			Assert.assertEquals(prod_name_cart, product_Name1);
			String colour_cart = driver.findElement(By.xpath(ObjectRepoTestscript.colour)).getText();
			Assert.assertEquals(colour_cart, top_stitch_thread_colour_text1);
			String price_cart = driver.findElement(By.xpath(ObjectRepoTestscript.price)).getText();
			Assert.assertEquals(price_cart, cart_price);
			driver.findElement(By.xpath(ObjectRepoTestscript.edit_design)).click();
			takeScreenshot(methodName);
			Thread.sleep(5000);
			try {
				Select select = new Select(driver.findElement(By.xpath(ObjectRepoTestscript.age)));
				select.selectByVisibleText(age_value);
			} catch (Exception e) {
				Log.error(e.toString());
			}
			WebDriverWait wait111 = new WebDriverWait(driver, 10000);
			wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepoTestscript.change_thread)));
			driver.findElement(By.xpath(ObjectRepoTestscript.change_thread)).click();
			takeScreenshot(methodName);
			System.out.println("I am rached after chang thread");
			driver.findElement(By.xpath(ObjectRepoTestscript.images_tools)).click();
			System.out.println("I am rached after images_tools");
			driver.findElement(By.xpath(ObjectRepoTestscript.addtext_button)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.text_field)).sendKeys(text);
			driver.findElement(By.xpath(ObjectRepoTestscript.add)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.autosize)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.update_design)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.proceedToCartOption)).click();
			takeScreenshot(methodName);
			Thread.sleep(5000);
			String prod_name_cart1 = driver.findElement(By.xpath(ObjectRepoTestscript.prd_in_cart)).getText();
			String prod_name_cart2 = prod_name_cart1.toLowerCase();
			String product_Name2 = product_Name1.toLowerCase();
			Assert.assertEquals(prod_name_cart2, product_Name2);
			Thread.sleep(5000);
			String colour_cart1 = driver.findElement(By.xpath(ObjectRepoTestscript.colour_in_cart)).getText();
			Assert.assertEquals(colour_cart1, top_stitch_thread_colour_text);
			Thread.sleep(5000);
			String price_cart1 = driver.findElement(By.xpath(ObjectRepoTestscript.price_in_cart_new)).getText();
			Assert.assertEquals(price_cart1, cart_price);
			driver.findElement(By.xpath(ObjectRepoTestscript.delete)).click();
			driver.findElement(By.xpath(ObjectRepoTestscript.remove_item)).click();
			Thread.sleep(5000);
			String message = driver.findElement(By.xpath(ObjectRepoTestscript.msg)).getText();
			Assert.assertEquals(message, empty_msg);
			takeScreenshot(methodName);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
			Log.error(e.toString());
			driver.quit();
		}
	}

	// -----------------------Take Screenshot------------------------
	public void takeScreenshot(String methodName) throws Exception {
		String timeStamp;
		File screenShotName = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String folderPath = "./test-output/Screenshots/" + folderName;
		System.out.println(folderPath + "folderPath");
		File f1 = new File(folderPath);
		if (f1.exists()) {
			screenShotName = new File(folderPath + "/" + methodName + "_" + timeStamp + ".png");
		} else {
			boolean bool = f1.mkdir();
			screenShotName = new File(folderPath + "/" + methodName + "_" + timeStamp + ".png");
		}
		FileHandler.copy(scrFile, screenShotName);
		String filePath = timeStamp + ".png";
		Reporter.log(filePath);

	}

}
