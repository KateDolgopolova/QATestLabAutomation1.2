import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SourceType;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement login = driver.findElement(By.name("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submit = driver.findElement(By.className("ladda-label"));
        submit.click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
        }

        WebElement dashboard = driver.findElement(By.id("tab-AdminDashboard"));
        dashboard.click();
        WebElement checkDashboard = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/ul/li"));
        System.out.println(checkDashboard.getText());



        driver.navigate().refresh();
        WebElement checkDashboardl = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/ul/li"));
       //Asserts.check(checkDashboardl.getText() == "Dashboardl", "well done");
        System.out.println(checkDashboardl.getText());
        if (checkDashboardl.getText() == "Dashboard"){
            System.out.println("good");
        } else{
            System.out.println("help");
            /*System.out.println(checkDashboardl
                    .getText());
                    метод if и Asserts.check не отрабатывает корректно, в Assert.check - выводит ошибку, if - при сравнение текста тоже.
                    */

        }



    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
