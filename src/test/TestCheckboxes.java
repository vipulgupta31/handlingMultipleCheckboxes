package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCheckboxes extends BaseClass{

	@Test
	public void testSingleCheckbox()
	{
		System.out.println("Navigating to the URL");
		driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		
		//using ID attribute to locate checkbox
		WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
		
		//pre-validation to confirm that checkbox is displayed.
		if(checkbox.isDisplayed())
		{
			System.out.println("Checkbox is displayed. Clicking on it now");
			checkbox.click();
		}
		
		//post-validation to confirm that checkbox is selected.
		if(checkbox.isSelected())
		{
			System.out.println("Checkbox is checked");
		}
	}
	
	
	@Test
	public void testMultipleCheckbox()
	{
		System.out.println("Navigating to the URL");
		driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		
		//using class name to fetch the group of multiple checkboxes
		List<WebElement> checkboxes = driver.findElements(By.className("cb-element mr-10"));

		//traverse through the list and select all checkboxes if they are enabled and displayed.
		for(int i=0; i<checkboxes.size(); i++)
		{
			if(checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled())
			{
				checkboxes.get(i).click();
			}
		}
		
		//deselect the checkbox on index 1 from the list of checkboxes selected above
		System.out.println("de-selecting checkbox with index 1");
		checkboxes.get(1).click();
		if(checkboxes.get(1).isSelected())
		{
			System.out.println("Checkbox is still selected");
		}
		else
		{
			System.out.println("Checkbox is deselected successfully");
		}
	}
}
