package CambTranslator;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CambTransStepDef 
{
	private static final String searchkey = null;
	WebDriver driver;
	
	@Given("User navigate to cambridge home page")
	public void User_navigates_homepage() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
        String baseUrl = "https://dictionary.cambridge.org";
        driver.get(baseUrl);
       
     }
	
     @Given("user clicks on translate icon")
		 public void Translator_page()
		 { 
    	 driver.findElement(By.xpath("//span[contains(text(),'Translate')]")).click();
    		
		 }
		 @When("User writes a English sentence")
		 public void write_enlish_sentence() throws IOException
		
		 {

			    FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\language.xlsx");
				XSSFWorkbook workbook =new XSSFWorkbook(fis);
				XSSFSheet ws = workbook.getSheetAt(0);	
				int rownum = ws.getLastRowNum();
				int colnum =ws.getRow(0).getPhysicalNumberOfCells();
				System.out.println(rownum);
				System.out.println(colnum);
				XSSFCell searchkey ;
				
		 }
		 
	@Then("User have successfully display the traslation")
	public void Translation_display_successfully() {
		int rownum = 0;
		for(int i=1; i<=rownum;i++) { 	
			//driver.navigate().to("url");
			Select drplan = new Select(driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[1]/div[1]/div[1]")));
			int colnum = 0;
			for(int j=1; j<=colnum;j++) { 
		    drplan.selectByVisibleText("english");
		    drplan.selectByVisibleText("Japanese");
		    drplan.selectByVisibleText("searchkey");
		    
		    driver.findElement(By.xpath("//button[@id='button-submit']")).click();
		    WebElement Translate=driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[3]/div[2]/div[1]"));
		    System.out.println("Translation of the "+ searchkey +"is"+Translate.getText());
			
			}
	}
	}
		 @When("user navigate to Expolre the english grammer")
		 public void Grammer_page()
		 {
			 Object document;
			driver.findElement(By.name("Grammar")).click();
		        
		 }
		 
		 @Then("user click on Adjectives and adverb and navigated to description on Adjectives and adverbs")
		 public void Adjectives_and_adverbsr_page() throws InterruptedException
		 {
			 driver.findElement(By.name("Adjectives and adverbs")).click();
		     driver.findElement(By.name("Grammar")).sendKeys("Adjectives and adverbs");
		     System.out.println("The Description of Adjectives and adverbs is- "+driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/span/p[2]")).getText());
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		 }
		 
		 @When("user navigate to Expolre the english grammer")
		 public void user_navigate_back_to_Gram_page() throws InterruptedException
		 {
			 
		        driver.navigate().back();
		 }
		 
		@Then("user click on Easily confused words and navigated to description on Easily confused words")
		public void Easily_confused_words_page_inside() 
		{
			 driver.findElement(By.name("Easily confused words")).click();
		     driver.findElement(By.name("Grammar")).sendKeys("Easily confused words");
		     System.out.println("The Description of Easily confused words is- "+driver.findElement(By.xpath("content")).getText());
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		 @When("user navigate to Expolre the english grammer")
		 public void user_navigate_back_to_Gram_page_from_Easily_confused_words() 
		 {
			 
		        driver.navigate().back();
		 }
		
		 @Then("user click on Nouns,pronouns and determiners and navigated to description on Nouns,pronouns")
			public void Nouns_pronouns_page_inside() 
			{
			 driver.findElement(By.name("Nouns, pronouns and determiners")).click();
		     driver.findElement(By.name("Grammar")).sendKeys("Nouns, pronouns and determiners");
		     System.out.println("The Description of Nouns, pronouns and determiners is- "+driver.findElement(By.xpath("content")).getText());
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));    
		    }
		 
		 @When("user navigate to Expolre the english grammer")
		 public void user_navigate_back_to_Gram_page_from_Nouns_pronouns_page() 
		 {
			 
		        driver.navigate().back();
		 }
		 
		 @Then("user click on Prepositions and particles and navigated to description on Prepositions and particles")
			public void Prepositions_and_particles_page_inside() 
			{
			 driver.findElement(By.name("Prepositions and particles")).click();
		     driver.findElement(By.name("Grammar")).sendKeys("Prepositions and particles");
		     System.out.println("The Description of Prepositions and particles is- "+driver.findElement(By.xpath("content")).getText());
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		    }
		
		 @When("user navigate to Expolre the english grammer")
		 public void user_navigate_back_to_Gram_page_from_Prepositions_and_particles() 
		 {
			driver.navigate().back();
		 }
		 @Then("user click on Using English page and navigated to description on Using English page")
		 
		 public void Using_English_page_inside() 
			{
			 driver.findElement(By.name("Using English")).click();
		     driver.findElement(By.name("Grammar")).sendKeys("Using English");
		     System.out.println("The Description of Using English is- "+driver.findElement(By.xpath("content")).getText());
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
		 
		 @When("user navigate to Expolre the english grammer")
		 public void user_navigate_back_to_Gram_page_from_Using_English_page() 
		 {
			driver.navigate().back();
		 }
		
		 @Then("user click on Verbs and navigated to description on Verbs")
		 
		 public void Using_Verbs_page_inside() 
			{
			 driver.findElement(By.name("Verbs")).click();
		     driver.findElement(By.name("Grammar")).sendKeys("Verbs");
		     System.out.println("The Description of Verbs is- "+driver.findElement(By.xpath("content")).getText());
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
		    }
		 
		 @When("user navigate to Expolre the english grammer")
		 public void user_navigate_back_to_Gram_page_from_Verbs_page() 
		 {
			driver.navigate().back();
		 }
	     @Then("user click on Words, sentences and clauses and navigated to description on Words, sentences and clauses")
		 
		 public void Words_sentences_clauses_page_inside() 
			{
	    	 driver.findElement(By.name("Words, sentences and clauses")).click();
		     driver.findElement(By.name("Grammar")).sendKeys("Words, sentences and clauses");
		     System.out.println("The Description of Words, sentences and clauses is- "+driver.findElement(By.xpath("content")).getText());
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  
		    }
}

