package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class Elements {

    // Text box
    public void textBox(WebDriver driver) throws InterruptedException {

        driver.findElement(By.id("userName")).sendKeys("Naveen");
        driver.findElement(By.id("userEmail")).sendKeys("naveen@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Coimbatore");
        driver.findElement(By.id("permanentAddress")).sendKeys("Namakkal");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        WebElement output = driver.findElement(By.cssSelector("#output"));
        System.out.println(output.getText());
        System.out.println("Text box test completed...");
    }

    public void checkbox(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='tree-node']/div/button")).click();

        driver.findElement(By.cssSelector("label[for='tree-node-home']")).click();
        Thread.sleep(1000);
        String result = driver.findElement(By.id("result")).getText();
        System.out.println(result);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("label[for='tree-node-desktop']")).click();
        Thread.sleep(1000);
        String result1 = driver.findElement(By.id("result")).getText();
        System.out.println(result1);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("label[for='tree-node-documents']")).click();
        Thread.sleep(1000);
        String result2 = driver.findElement(By.id("result")).getText();
        System.out.println(result2);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("label[for='tree-node-downloads']")).click();
        Thread.sleep(1000);
        String result3 = driver.findElement(By.id("result")).getText();
        System.out.println(result3);
        Thread.sleep(1000);
    }

    public void radioButton(WebDriver driver) throws InterruptedException {
        driver.findElement(By.cssSelector("label[for='yesRadio']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div/p[@class='mt-3']")).getText());

        driver.findElement(By.cssSelector("label[for='impressiveRadio']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div/p[@class='mt-3']")).getText());

        driver.findElement(By.cssSelector("label[for='noRadio']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div/p[@class='mt-3']")).getText());
    }

    public void webTable(WebDriver driver) throws InterruptedException {
//        driver.findElement(By.id("addNewRecordButton")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("firstName")).sendKeys("Naveen");
//        Thread.sleep(1000);
//        driver.findElement(By.id("lastName")).sendKeys("Karthik");
//        Thread.sleep(1000);
//        driver.findElement(By.id("userEmail")).sendKeys("naveen@gmail.com");
//        Thread.sleep(1000);
//        driver.findElement(By.id("userEmail")).sendKeys("28");
//        Thread.sleep(1000);
//        driver.findElement(By.id("salary")).sendKeys("40000");
//        Thread.sleep(1000);
//        driver.findElement(By.id("department")).sendKeys("Civil Department");
//        Thread.sleep(1000);
//        driver.findElement(By.id("submit")).submit();
//        Thread.sleep(1000);

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='rt-table']/div[@class='rt-tbody']/div"));
        System.out.println(list.size());
//
        for (WebElement element : list) {
            System.out.println(element.findElement(By.xpath("//div/div/div/div[1]")).getText());
            ;
        }

//        System.out.println(driver.findElement(By.xpath("//div[@class='rt-table']/div[@class='rt-tbody']/div[1]/div/div[1]")).getText());
    }


    public void buttons(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.contextClick(driver.findElement(By.id("doubleClickBtn"))).doubleClick().perform();
        Thread.sleep(500);
        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());
        Thread.sleep(500);

        actions.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        Thread.sleep(500);
        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());
        Thread.sleep(500);

        driver.findElement(By.xpath("//div/div/button[text()='Click Me']")).click();
        Thread.sleep(500);
        System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());
    }


    public void links(WebDriver driver) throws InterruptedException {
        // open in new tab
        driver.findElement(By.linkText("Home")).click();
        String currentTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        System.out.println("New tab title: " + driver.getTitle());

        // dynamic link open in tab
        driver.findElement(By.partialLinkText()).click();
    }
}
