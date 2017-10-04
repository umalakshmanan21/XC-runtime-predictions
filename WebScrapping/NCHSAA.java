/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NCHSAA;

/**
 *
 * @author UMA
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile ; 
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.concurrent.TimeUnit;
import learningselenium.objectclass;
import java.io.*;

public class NCMileSplit {

    /**
     * 8
     */
    public static void main(String[] args) throws IOException {

        // Firefox profile creation
        ProfilesIni prof = new ProfilesIni()	;			
        
        FirefoxProfile profile= prof.getProfile ("my profile");
        System.setProperty("webdriver.gecko.driver", "/Users/VP/Downloads/geckodriver");
        
//FirefoxProfile testprofile = profile.getProfile("default");
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        File extensionToInstall = new File("/Users/VP/Downloads/adblock_plus-2.7.3-sm+tb+fx+an.xpi");
        profile.addExtension(extensionToInstall);
        WebDriver driver = new FirefoxDriver(profile);
        // setting the appurl
        String appUrl = "http://nc.milesplit.com";
        // launch the firefox browser and open the application url
        driver.get(appUrl);
        //driver.switchTo().defaultContent();
        //Getting all the links' text in the page
       driver.findElement(By.className("login")).click();
        //Seperating each text 
        //String[] linkTexts = ds.split("\n");
        //driver.findElement(By.xpath("//a[@href='#account']")).click();
       // driver.findElement(By.xpath("//a[@href='/login?next=http%3A%2F%2Fnc.milesplit.com%2F&site=34']")).click();
        driver.findElement(By.name("username")).sendKeys("uvadivel");
        driver.findElement(By.name("password")).sendKeys("woodward135");
        WebElement element = driver.findElement(By.className("btn-login"));
        element.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        //driver.get("http://nc.milesplit.com/");
        driver.get("http://nc.milesplit.com/rankings/pro/high-school-boys/cross-country/5000m?year=all");
        driver.quit();
        System.exit(0);
        

        //creating an object to accomadate the school location/classification/Name
        List<objectclass> Alldata = null;
        Alldata = new ArrayList<>();
        int k = 0;
        for (String j : linkTexts) {
            if (driver.findElements(By.linkText(j)).size() != 0) {
                driver.findElement(By.linkText(j)).click();
                if (driver.findElements(By.className("field-name-field-school-classification")).size() != 0) {
                    String Classification = driver.findElement(By.className("field-name-field-school-classification")).getText();
                    String SchoolLocality = driver.findElement(By.className("locality")).getText();
                    objectclass newschool = new objectclass();
                    newschool.setSchoolName(j);
                    newschool.setClassification(Classification);
                    newschool.setSchoolLocality(SchoolLocality);
                    Alldata.add(newschool);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    k++;
                } else if (driver.findElements(By.className("field-name-field-school-conferences")).size() != 0) {
                    String Classification = driver.findElement(By.className("field-name-field-school-conferences")).getText();
                    String SchoolLocality = driver.findElement(By.className("locality")).getText();
                    objectclass newschool = new objectclass();
                    newschool.setSchoolName(j);
                    newschool.setClassification(Classification);
                    newschool.setSchoolLocality(SchoolLocality);
                    Alldata.add(newschool);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
                driver.navigate().back();
            }
        }

        // close the web browser
        driver.close();
        System.out.println("Test script executed successfully.");

        //creating a file in which the school data gets saved
        File file = new File("/Users/VP/Downloads/schoolList.csv");

        // creates the file
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        // unpacking the object and writing it to a file
        for (objectclass schools : Alldata) {
            String classficiation = schools.getClassification();
            String locality = schools.getSchoolLocality();
            String name = schools.getSchoolName();
            writer.write(classficiation + "," + locality + "," + name);
            writer.write("\n");
        }
        writer.close();

// terminate the program
        
    }

}
    
}
