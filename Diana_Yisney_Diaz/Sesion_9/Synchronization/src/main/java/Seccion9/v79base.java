package Seccion9;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class v79base {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
//String mousePad= 
		   // System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Se adiciona temporizador  implicitlyWait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//relaciona la adicion del v80 uso de implicitlyWait
		
		System.out.println("Inicio del Navegador");
//Creacion de una lista de productos a seleccionar en el carrito por medio de su path de cssSelector de H4
		//https://www.geeksforgeeks.org/conversion-of-array-to-arraylist-in-java/ ver
		
		//int j=0;   se mueve el contador a la funcion
		
		String[] itemsNeeded={"Cucumber","Brocolli","Cauliflower","Beetroot","Carrot"};

		driver.get("http://rahulshettyacademy.com/seleniumPractise/");
		 Thread.sleep(3000);
		 //se realiza llamado a la funcion AddItem
		 addItems(driver,itemsNeeded);
		 //base b=new base();
		 //b.addItems(driver,itemsNeeded);	
		 	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		 	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		 	Thread.sleep(3000);
		 	driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		 	driver.findElement(By.cssSelector("button.promoBtn")).click();
		 	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		 	
		 
		 
		 		System.out.println("salida del Navegador");
				// Cierra el navegador  y todas las ventanas asociadas al final del script.
				driver.quit();
	}
	
	private static void implicitlyWait(int i, TimeUnit seconds) {
		// TODO Auto-generated method stub
		
	}

	public static void addItems(WebDriver driver,String[] itemsNeeded) {
		int j=0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		 
		 for (int i=0; i<products.size(); i++)
		 {
			System.out.println("Ingreso al for");
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			//convert array into array list for easy search
			//check whether name you extracdris present in arraylist or not
			//Adiccion de funcion v73
			
			System.out.println("Funcion Validacion Lista de productos");
			List itemsNeededList = Arrays.asList((itemsNeeded));
			
				//int j=0;
				//if(name.contains("Cucumber")  se hace el ajuste en el nombre de la variable en el video de secuencia
				if(itemsNeededList.contains(formattedName))  //Se trae la inf tomada con la variable name por medio de la funcion get
				{
					j++;
					//Adicionar carrito
					System.out.println("Ingreso al if y adicion al carrito");
					//driver.findElements(By.xpath("//button[@class='product-action']")).get(i).click();
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						if(j==itemsNeeded.length)
						{	
							break;
						}
				}
		 }
	}
}
