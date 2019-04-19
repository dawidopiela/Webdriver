import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    WebDriver driver;

   @Before
public void start() {
       System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Dawid\\IdeaProjects\\Webdriver\\src\\test\\java\\chromedriver.exe");
// dodajemy link gdzie sie znajduje chromedriver
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       //zmaksymalizuje nam okno przegladarki
       driver.get("https://www.wp.pl/");
       driver.get("https://profil.wp.pl/login.html?zaloguj=poczta");

   }



   @Test
    public void firsttest() throws InterruptedException {

       WebElement znacznik = driver.findElement(By.cssSelector("[class='goZaloz']"));
        znacznik.click();
       //szukanie w przegladarce wedlug selektorow css
       Thread.sleep(5000);
       //po wlaczeniu przegladarki przytrzymuje ja otwarta 5sekund

       boolean sprawdzenie= driver.findElement(By.className("alert")).isDisplayed();
       Assert.assertTrue(sprawdzenie);
       // driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        // strona ma 10 sek aby zdązyc się załądować jezli nie to wyrzuci sie bład



      //  driver.findElement(By.partialLinkText("POCZTA")).click();
       // driver.findElement(By.name("login_username")).sendKeys("dawid18122@wp.pl");
        //pobranie z zrodla strony inputu i wpisanie takiego uzytkownika
   //     driver.findElement(By.name("password")).sendKeys("david1824");
   //    driver.findElement(By.id("btnSubmit")).click();
    //   Assert.assertFalse(driver.getPageSource().contains("Niestety podany login lub hasło jest błędne"));
       //assercia tu polega ze tekst ten musi sie znajdowac na stronie i wtedy assertTrue
       // a assertFalse jezeli sie nie zgadza
       //czy tekst jest podany na stronie assert true przechodzi test, asssertfalse nie przechodzi test

    }
    @After
    public void koniec(){
        driver.quit();
    }
}
